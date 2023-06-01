package org.feather.eshop.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/order/create")
    public String createOrder(Integer productId,Integer userId){
       return restTemplate.getForObject("http://Stock-Serv/stock/reduce/"+productId,String.class);
    }

    @GetMapping("/getHost")
    public String getHost(){
        List<ServiceInstance> instanceList = discoveryClient.getInstances("Order-Serv");
        StringBuilder result= new StringBuilder();
        for (ServiceInstance instance : instanceList) {
            result.append("  ").append(instance.getHost());
        }
        return result.toString();
    }

}
