package com.naresh.introduction.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Type-safe binding for the "app.*" properties in application.properties.
 * Record-based @ConfigurationProperties (production-recommended, immutable).
 *
 * refer:
 *   app.name       -> name()
 *   app.version    -> version()
 *   app.contact.*  -> contact() (nested)
 *   app.features.* -> features() (nested)
 */
@ConfigurationProperties(prefix = "app")
public record AppProperties(
        String name,
        String version,
        Contact contact,
        Features features) {

    public record Contact(String email) {}

    public record Features(boolean autoApprove) {}
}