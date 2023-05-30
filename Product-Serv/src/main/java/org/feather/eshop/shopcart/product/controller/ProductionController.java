package org.feather.eshop.shopcart.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: EShop
 * @package: org.feather.eshop.product.controller
 * @className: ProductionController
 * @author: feather
 * @description: TODO
 * @since: 2023-05-30 15:27
 * @version: 1.0
 */

@RestController
public class ProductionController {

    @GetMapping("/product/{productId}")
    public String getProduct(@PathVariable Integer productId){
        return  "mac";
    }

}
