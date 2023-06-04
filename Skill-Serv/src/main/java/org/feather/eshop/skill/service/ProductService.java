package org.feather.eshop.skill.service;

import lombok.extern.slf4j.Slf4j;
import org.feather.eshop.skill.entity.SkillGood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @projectName: EShop
 * @package: org.feather.eshop.skill.service
 * @className: ProductService
 * @author: feather
 * @description: TODO
 * @since: 2023-06-04 10:57
 * @version: 1.0
 */

@Slf4j
@Service
public class ProductService {

    @Autowired
    private RestTemplate restTemplate;

    public SkillGood getGoodById(Long productId) {
        return restTemplate.getForObject("http://Product-Serv/product/" + productId, SkillGood.class);
    }

    public void update(SkillGood skillGood) {
        ResponseEntity<String> result= restTemplate.postForEntity("http://Product-Serv/product/",skillGood,String.class);
        log.info(result.getBody());
    }
}

