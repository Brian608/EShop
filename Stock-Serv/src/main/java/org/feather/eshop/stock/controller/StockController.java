package org.feather.eshop.stock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: EShop
 * @package: org.feather.eshop.stock.controller
 * @className: StockController
 * @author: feather
 * @description: TODO
 * @since: 2023-05-30 16:08
 * @version: 1.0
 */
@RestController
public class StockController {

    @GetMapping("/stock/reduce/{productId}")
    public String reduce(@PathVariable Integer productId){
        System.out.println("减库存1个成功");
        return "减库存1个成功";
    }
}
