package org.feather.eshop.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @projectName: EShop
 * @package: org.feather.eshop.stock
 * @className: StockApplication
 * @author: feather
 * @description: TODO
 * @since: 2023-05-30 16:07
 * @version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class StockApplication {
    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class);
    }
}
