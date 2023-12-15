package com.act.login_regis_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class LoginRegisSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginRegisSpringApplication.class, args);
    }

}
