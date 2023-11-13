package com.hzy.zymall.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hzy.zymall.member.dao")
public class ZymallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZymallMemberApplication.class, args);
    }

}
