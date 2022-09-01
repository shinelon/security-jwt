package com.shinelon.securityjwt.config;


import com.alibaba.fastjson2.JSON;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

/**
 * @ClassName JwtHandler
 * @Author shinelon
 * @Date 10:27 2022/9/1
 * @Version 1.0
 **/
@Component
@Slf4j
public class JwtHandler {
    @Value("${auth.jwt.key}")
    private String jwtKey;


    public Optional<Claims> parseToken(String token) {
        return parseToken(token, jwtKey);
    }

    public Optional<Claims> parseToken(String token, String key) {
        Claims claims = null;
        try {
            JwtParser jwtParser = Jwts.parser().setSigningKey(key.getBytes(StandardCharsets.UTF_8));
            claims = jwtParser.parseClaimsJws(token).getBody();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return Optional.ofNullable(claims);
    }

    public String generateToken(User user) {
        long currentTime = System.currentTimeMillis();
        Collection<GrantedAuthority> authorities = user.getAuthorities();
        return Jwts.builder().signWith(SignatureAlgorithm.HS256, jwtKey.getBytes(StandardCharsets.UTF_8))
                .setIssuer("issuer")
                .setAudience("aut")
                .setId(user.getUsername())
                .setIssuedAt(new Date(currentTime))
                .setExpiration(new Date(currentTime + 1000 * 3600 * 8))
                .setSubject(JSON.toJSONString(authorities))
                .compact();

    }

    public String generateToken(String key) {
        long currentTime = System.currentTimeMillis();
        return Jwts.builder().signWith(SignatureAlgorithm.HS256, key.getBytes(StandardCharsets.UTF_8))
                .setIssuer("issuer")
                .setAudience("aut")
                .setId("id")
                .setIssuedAt(new Date(currentTime))
                .setExpiration(new Date(currentTime + 1000 * 3600 * 8))
                .setSubject("sub")
                .compact();

    }

}
