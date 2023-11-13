package com.hzy.zymall.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hzy.zymall.order.dao")
public class ZymallOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZymallOrderApplication.class, args);
    }

}
