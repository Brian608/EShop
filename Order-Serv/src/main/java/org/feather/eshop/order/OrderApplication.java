package org.feather.eshop.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @projectName: EShop
 * @package: org.feather.eshop.order
 * @className: OrderApplication
 * @author: feather
 * @description: TODO
 * @since: 2023-05-30 15:16
 * @version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderApplication {

    @Bean
    @LoadBalanced
    public RestTemplate create(){
        return  new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class);
    }

}
