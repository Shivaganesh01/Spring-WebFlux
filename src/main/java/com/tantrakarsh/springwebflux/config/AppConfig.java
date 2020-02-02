package com.tantrakarsh.springwebflux.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class AppConfig {
    @Bean
    public static PropertyPlaceholderConfigurer gePropertySourcesPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocation(new ClassPathResource("application.properties"));
        propertyPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
        return propertyPlaceholderConfigurer;
    }
}
