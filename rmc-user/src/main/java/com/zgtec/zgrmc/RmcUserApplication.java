package com.zgtec.zgrmc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zkc
 * @description
 * @Date 2023/4/7 13:38 星期五
 * @Version 1.0
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class RmcUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(RmcUserApplication.class,args);
    }
}
