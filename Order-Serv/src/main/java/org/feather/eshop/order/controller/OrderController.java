package org.feather.eshop.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @projectName: EShop
 * @package: org.feather.eshop.order.controller
 * @className: OrderController
 * @author: feather
 * @description: TODO
 * @since: 2023-05-30 15:20
 * @version: 1.0
 */
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/order/create")
    public String createOrder(Integer productId,Integer userId){
       return restTemplate.getForObject("http://Stock-Serv/stock/reduce/"+productId,String.class);
    }

}
