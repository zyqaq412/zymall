package com.hzy.zymall.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.hzy.zymall.order.dao")
@EnableDiscoveryClient // 开启服务注册发现 (高版本不用写)
public class ZymallOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZymallOrderApplication.class, args);
    }

}
