package com.hzy.zymall.ware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hzy.zymall.ware.dao")
public class ZymallWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZymallWareApplication.class, args);
    }

}
