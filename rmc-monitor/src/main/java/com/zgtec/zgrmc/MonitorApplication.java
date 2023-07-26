package com.zgtec.zgrmc;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zkc
 * @description
 * @Date 2023/4/18 21:57 星期二
 * @Version 1.0
 */
@EnableDiscoveryClient
@EnableAdminServer
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MonitorApplication {
    public static void main(String[] args) {
        SpringApplication.run(MonitorApplication.class,args);
    }
}
