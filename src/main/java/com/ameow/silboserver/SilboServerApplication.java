package com.ameow.silboserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "com.ameow.silboserver.mapper")
@EnableTransactionManagement
public class SilboServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SilboServerApplication.class, args);
    }

}
