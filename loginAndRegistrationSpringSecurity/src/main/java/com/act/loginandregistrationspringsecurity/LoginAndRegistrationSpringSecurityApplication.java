package com.act.loginandregistrationspringsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class  LoginAndRegistrationSpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginAndRegistrationSpringSecurityApplication.class, args);
    }

}
