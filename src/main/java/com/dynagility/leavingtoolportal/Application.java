package com.dynagility.leavingtoolportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dynagility.leavingtoolportal.security.SecurityUtil;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {

    @Bean
    SecurityUtil createInstance() {
        return new SecurityUtil();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
