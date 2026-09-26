package com.naresh.introduction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * Entry point of the Spring Boot application.
 *
 * <p>@SpringBootApplication combines:
 * <ul>
 *   <li>@Configuration - marks this class as a configuration class</li>
 *   <li>@EnableAutoConfiguration - auto-configures beans from classpath starters</li>
 *   <li>@ComponentScan - scans com.naresh.introduction (and sub-packages) for beans</li>
 * </ul>
 *
 * <p>@ConfigurationPropertiesScan discovers @ConfigurationProperties beans
 * (AppProperties) automatically.
 */
@SpringBootApplication
@ConfigurationPropertiesScan
public class SpringBootIntroductionApplication {

    public static void main(String[] args) {
        // Bootstraps the embedded Tomcat + Spring context and runs the app
        SpringApplication.run(SpringBootIntroductionApplication.class, args);
    }
}