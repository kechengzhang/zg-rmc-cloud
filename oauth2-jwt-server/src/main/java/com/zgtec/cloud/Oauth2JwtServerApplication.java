package com.zgtec.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Oauth2JwtServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2JwtServerApplication.class, args);
    }

}
