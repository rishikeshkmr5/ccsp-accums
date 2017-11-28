package com.hcsc.ccsp.accums;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@ComponentScan({ "com.hcsc.ccsp.accums" })
@EnableSwagger2
public class AccumsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccumsApplication.class, args);
    }
}