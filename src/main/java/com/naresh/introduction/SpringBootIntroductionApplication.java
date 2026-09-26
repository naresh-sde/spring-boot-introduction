package com.naresh.introduction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

// Entry point of the Spring Boot app.
@SpringBootApplication
@ConfigurationPropertiesScan
public class SpringBootIntroductionApplication {

    public static void main(String[] args) {
        // Starts the embedded server and the Spring context.
        SpringApplication.run(SpringBootIntroductionApplication.class, args);
    }
}