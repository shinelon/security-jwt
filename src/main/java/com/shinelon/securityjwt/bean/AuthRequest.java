package com.shinelon.securityjwt.bean;

import lombok.Data;

/**
 * @ClassName Bean
 * @Author shinelon
 * @Date 10:59 2022/9/1
 * @Version 1.0
 **/
@Data
public class AuthRequest {
    private String username;
    private String password;
}
