package com.naresh.introduction.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;
import java.time.ZoneId;

// Declares a bean with @Bean and injects a property value with @Value.
@Configuration
public class DemoBeanConfig {

    @Bean
    public Clock appClock(@Value("${app.time-zone:UTC}") String timeZone) {
        return Clock.system(ZoneId.of(timeZone));
    }
}
