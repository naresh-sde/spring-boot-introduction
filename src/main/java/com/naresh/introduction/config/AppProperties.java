package com.naresh.introduction.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

/** Binds the app.* properties from application.properties. */
@ConfigurationProperties(prefix = "app")
public record AppProperties(
        @DefaultValue("Customer Management Service") String name,
        @DefaultValue("0.0.0") String version,
        Contact contact,
        Features features) {

    // A missing app.contact / app.features key binds to null, so fall back to empty nested records.
    public AppProperties {
        contact = contact == null ? new Contact("") : contact;
        features = features == null ? new Features(false) : features;
    }

    public record Contact(@DefaultValue("") String email) {}

    public record Features(@DefaultValue("false") boolean autoApprove) {}
}
