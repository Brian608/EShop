package org.feather.eshop.shopcart.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @projectName: EShop
 * @package: org.feather.eshop.product
 * @className: ProductionApplication
 * @author: feather
 * @description: TODO
 * @since: 2023-05-30 15:26
 * @version: 1.0
 */
@EnableScheduling
@SpringBootApplication
public class ProductionApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductionApplication.class);
    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(
            RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        //采用普通的key 为 字符串
        template.setKeySerializer(new StringRedisSerializer());
        return template;
    }

}
