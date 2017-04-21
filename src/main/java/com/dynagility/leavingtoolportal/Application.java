package com.dynagility.leavingtoolportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.dynagility.leavingtoolportal.security.SecurityUtil;

@SpringBootApplication
// @EnableAutoConfiguration
@EnableScheduling
// @ComponentScan({ "com.dynagility.leavingtoolportal.schedules" })
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}