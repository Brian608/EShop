package org.feather.eshop.ad.controller;

import org.feather.eshop.ad.entity.AdEntity;
import org.feather.eshop.ad.service.ADService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @projectName: EShop
 * @package: org.feather.eshop.ad.controller
 * @className: ADController
 * @author: feather
 * @description: TODO
 * @since: 2023-06-05 21:49
 * @version: 1.0
 */
@RestController
public class ADController {
    @Autowired
    private ADService adService;

    @GetMapping("/ad/getADList")
    public List<AdEntity>  getADList(){
        return adService.getADList();
    }

}
