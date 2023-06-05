package org.feather.eshop.product.service;

import lombok.extern.slf4j.Slf4j;
import org.feather.eshop.product.dao.SkillGoodRepository;
import org.feather.eshop.product.entity.SkillGood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @projectName: EShop
 * @package: org.feather.eshop.product.service
 * @className: SkillGoodService
 * @author: feather
 * @description: TODO
 * @since: 2023-06-03 21:49
 * @version: 1.0
 */
@Slf4j
@Component
public class SkillGoodService {

    @Autowired
    private RedisTemplate redisTemplate;
    public static final String SKILL_GOODS_PHONE = "SKILL_GOODS_PHONE";
    public static final String SKILL_GOODS_QUEUE = "SKILL_GOODS_QUEUE";

    @Autowired
    private SkillGoodRepository skillGoodRepository;

    /**
     * 每五秒执行一次 将需要参与秒杀的商品列表加载到内存
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void prepareGood() {
        log.info("开始加载商品");
        //获取所有已经在内存当中的商品ID列表
        Set<Long> set = redisTemplate.boundHashOps(SKILL_GOODS_PHONE).keys();
        List<Long> ids = new ArrayList<>();
        for (Long id : set) {
            ids.add(id);
        }
        List<SkillGood> list = null;
        //只查询出不在内存当中的商品信息，并加载到内存
        if (CollectionUtils.isEmpty(ids)) {
            list = skillGoodRepository.findSkillAll();
        } else {
            list = skillGoodRepository.findSkill(ids);
        }
        if (!CollectionUtils.isEmpty(list)) {
            for (SkillGood skillGood : list) {
                redisTemplate.boundHashOps(SKILL_GOODS_PHONE).put(skillGood.getId(), skillGood);
                redisTemplate.boundListOps(SKILL_GOODS_QUEUE+skillGood.getId()).leftPushAll(convertoArry(skillGood.getStockCount(),skillGood.getId()));
            }
        }
        // 查看当前缓存中所有的商品信息
        Set keys = redisTemplate.boundHashOps(SKILL_GOODS_PHONE).keys();
        for (Object s : keys) {
            SkillGood skillGood = (SkillGood) redisTemplate.boundHashOps(SKILL_GOODS_PHONE).get(s);
            System.out.println(skillGood.getName() + " 库存剩余：" + skillGood.getStockCount());
        }
    }

    private Long[] convertoArry(Integer stockCount, Long id) {
        Long[] idslong=new Long[stockCount];
        for(int i=0;i<stockCount;i++){
            idslong[i]=id;
        }
        return idslong;
    }

    // 提供查询商品信息的方法
    public SkillGood queryProduct(Long productId) {
        return (SkillGood) redisTemplate.boundHashOps(SKILL_GOODS_PHONE).get(productId);
    }
    // 更新商品信息
    public void update(SkillGood skillGood) {
        skillGoodRepository.save(skillGood);
    }
}