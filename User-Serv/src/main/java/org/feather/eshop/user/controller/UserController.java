package org.feather.eshop.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: EShop
 * @package: org.feather.eshop.user.controller
 * @className: UserController
 * @author: feather
 * @description: TODO
 * @since: 2023-05-30 16:00
 * @version: 1.0
 */
@RestController
public class UserController {

    @GetMapping("/user/{userId}")
    public String getUserName(@PathVariable Integer userId){
        return  "feather";
    }
}
