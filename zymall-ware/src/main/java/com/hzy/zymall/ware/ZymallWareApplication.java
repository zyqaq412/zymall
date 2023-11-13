package com.hzy.zymall.ware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.hzy.zymall.ware.dao")
@EnableDiscoveryClient // 开启服务注册发现 (高版本不用写)
public class ZymallWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZymallWareApplication.class, args);
    }

}
