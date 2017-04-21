package com.dynagility.leavingtoolportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.dynagility.leavingtoolportal.security.SecurityUtil;

@SpringBootApplication
@EnableScheduling
@ComponentScan("com")
public class Application {

    @Bean
    SecurityUtil createInstance() {
        return new SecurityUtil();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}