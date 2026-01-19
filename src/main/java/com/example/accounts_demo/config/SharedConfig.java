package com.example.accounts_demo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "shared.config")
@RefreshScope
public class SharedConfig {
    private Integer rebateRate;
    private Integer minimumAge;
}