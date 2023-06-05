package org.feather.eshop.ad.service;
import lombok.extern.slf4j.Slf4j;
import org.feather.eshop.ad.entity.AdEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/**
 * @projectName: EShop
 * @package: org.feather.eshop.ad.service
 * @className: ADService
 * @author: feather
 * @description: TODO
 * @since: 2023-06-05 21:46
 * @version: 1.0
 */
@Slf4j
@Service
public class ADService {
    @Autowired
    private RedisTemplate redisTemplate;
    public static final String AD_LIST = "AD_LIST";

    public List<AdEntity> getADList() {
        List<AdEntity> list = redisTemplate.boundHashOps(AD_LIST).values();
        return list;
    }

    public void modify(AdEntity adEntity){
        redisTemplate.boundHashOps(AD_LIST).put(adEntity.getId(),adEntity);
    }

    public void delete(Integer id){
        redisTemplate.boundHashOps(AD_LIST).delete(id);
    }
    @Scheduled(cron = "0/2 * * * * ?")
    public void prepareGood() {
        Set keys = redisTemplate.boundHashOps(AD_LIST).keys();
        int i=0;
        for (Object s : keys) {
            i++;
            log.info( " 广告剩余：" + i);
        }
    }
}

