package org.feather.eshop.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @projectName: EShop
 * @package: org.feather.eshop.ad
 * @className: AdApplication
 * @author: feather
 * @description: TODO
 * @since: 2023-06-05 21:17
 * @version: 1.0
 */
@SpringBootApplication
public class AdApplication {

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(
            RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        //采用普通的key 为 字符串
        template.setKeySerializer(new StringRedisSerializer());
        return template;
    }

    public static void main(String[] args) {
        SpringApplication.run(AdApplication.class);
    }

}
