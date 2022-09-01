package com.shinelon.securityjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

/**
 * @ClassName IndexController
 * @Author shinelon
 * @Date 14:54 2022/8/31
 * @Version 1.0
 **/
@RestController
public class IndexController {


    @GetMapping("/")
    public String index() {
        return "jwt is start up!";
    }

    @GetMapping("/admin")
    @RolesAllowed("ADMIN")
    public String admin() {
        return "need admin role";
    }

    @GetMapping("/user")
    @RolesAllowed("USER")
    public String user() {
        return "need user role";
    }
}
