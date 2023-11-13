package com.hzy.zymall.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hzy.zymall.coupon.dao")
public class ZymallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZymallCouponApplication.class, args);
    }

}
