package com.hzy.gateway.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Collections;

/**
 * @title: CorsWebFilter
 * @Author zxwyhzy
 * @Date: 2023/11/14 18:11
 * @Version 1.0
 */
@Configuration
public class CorsConfig {
    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(Collections.singletonList("*")); // 允许所有来源
        corsConfig.setMaxAge(3600L); // 预检请求的有效期，单位秒
        corsConfig.addAllowedMethod("*"); // 请求方法
        corsConfig.addAllowedHeader("*"); // 允许所有请求头
        corsConfig.addAllowedOrigin("*"); //请求来源
        corsConfig.setAllowCredentials(true);// 允许携带cookie

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig); // 匹配所有路径
        return new CorsWebFilter(source);
    }
}
