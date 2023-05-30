package org.feather.eshop.shopcart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: EShop
 * @package: org.feather.eshop.shopcart.controller
 * @className: ShopCartController
 * @author: feather
 * @description: TODO
 * @since: 2023-05-30 16:14
 * @version: 1.0
 */
@RestController
public class ShopCartController {

    @GetMapping("/shopcart/remove")
    public String remove(Integer productId,Integer userId){
        return "移出购物车成功";
    }
}
