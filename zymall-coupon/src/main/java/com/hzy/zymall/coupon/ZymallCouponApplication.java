package com.hzy.zymall.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.hzy.zymall.coupon.dao")
@EnableDiscoveryClient // 开启服务注册发现 (高版本不用写)
public class ZymallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZymallCouponApplication.class, args);
    }

}
