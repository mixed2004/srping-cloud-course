package com.example.checkbookservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class CheckBookServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CheckBookServiceApplication.class, args);
    }
}
