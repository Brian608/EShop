package org.feather.eshop.skill.service;

import lombok.extern.slf4j.Slf4j;
import org.feather.eshop.skill.dao.SkillOrderRepository;
import org.feather.eshop.skill.entity.SkillEntity;
import org.feather.eshop.skill.entity.SkillGood;
import org.feather.eshop.skill.entity.SkillOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;

import static org.feather.eshop.skill.service.SkillGoodService.SKILL_GOODS_ONLY;
import static org.feather.eshop.skill.service.SkillGoodService.SKILL_GOODS_QUEUE;

/**
 * @projectName: EShop
 * @package: org.feather.eshop.skill.service
 * @className: MutilThreadOrder
 * @author: feather
 * @description: TODO
 * @since: 2023-06-04 11:00
 * @version: 1.0
 */
@Slf4j
@Component
public class MutilThreadOrder {
    @Autowired
    private ProductService productService;
    @Autowired
    private SkillOrderRepository skillOrderRepository;
    @Autowired
    private RedisTemplate redisTemplate;

    @Async
    public void createOrder() throws Exception {
        log.info("开始异步抢单");
        SkillEntity skillEntity = (SkillEntity) redisTemplate.boundListOps(SkillGoodService.SKILL_GOODS_LIST).rightPop();
        if (skillEntity == null) {
            return;
        }
        Long productId = skillEntity.getProductId();
        String userId = skillEntity.getUserId();
        SkillGood skillGood = productService.getGoodById(productId);
        if (skillGood == null) {
            throw new Exception("商品已经被抢光拉");
        }
        Long stockId = (Long) redisTemplate.boundListOps(SKILL_GOODS_QUEUE + productId).rightPop();
        if (stockId == null) {
            System.out.println("该商品已被秒杀完毕");
            redisTemplate.boundHashOps(SKILL_GOODS_ONLY).delete(userId);
            redisTemplate.boundHashOps(SkillGoodService.SKILL_GOODS_PHONE).delete(skillGood.getId());
            skillGood.setStockCount(0);
            productService.update(skillGood);
            return;
        }
        SkillOrder skillOrder = new SkillOrder();
        skillOrder.setMoney(skillGood.getCostPrice());
        skillOrder.setPayTime(new Date());
        skillOrder.setStatus("0");
        skillOrder.setUserId(userId);
        skillOrder.setCreateTime(new Date());
        skillOrder.setSkillId(productId);
        skillOrderRepository.save(skillOrder);
      log.info("结束异步抢单");
    }
}