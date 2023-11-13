package com.hzy.zymall.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.hzy.zymall.member.feign") // 开启远程调用
@MapperScan("com.hzy.zymall.member.dao")
@EnableDiscoveryClient // 开启服务注册发现 (高版本不用写)
public class ZymallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZymallMemberApplication.class, args);
    }

}
