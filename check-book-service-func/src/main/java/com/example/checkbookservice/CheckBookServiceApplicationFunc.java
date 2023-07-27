package com.example.checkbookservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class CheckBookServiceApplicationFunc {
    public static void main(String[] args) {
        SpringApplication.run(CheckBookServiceApplicationFunc.class, args);
    }
}
