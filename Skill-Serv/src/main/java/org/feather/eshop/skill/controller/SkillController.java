package org.feather.eshop.skill.controller;

import org.feather.eshop.skill.service.SkillGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: EShop
 * @package: org.feather.eshop.skill.controller
 * @className: SkillController
 * @author: feather
 * @description: TODO
 * @since: 2023-06-04 17:00
 * @version: 1.0
 */

@RestController
public class SkillController {

    @Autowired
    private SkillGoodService skillGoodService;

    @GetMapping("/skill")
    public String add(Long productId,String userId) {
        try{
            skillGoodService.add(productId,userId);
            return "抢单成功";
        }catch (Exception e){
            return e.getMessage();
        }
    }
}