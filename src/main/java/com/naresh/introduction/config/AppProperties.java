package com.naresh.introduction.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/** Binds the app.* properties from application.properties. */
@ConfigurationProperties(prefix = "app")
public record AppProperties(
        String name,
        String version,
        Contact contact,
        Features features) {

    public record Contact(String email) {}

    public record Features(boolean autoApprove) {}
}