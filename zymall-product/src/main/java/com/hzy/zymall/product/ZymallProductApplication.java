package com.hzy.zymall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hzy.zymall.product.dao")
public class ZymallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZymallProductApplication.class, args);
    }

}
