package com.example.accounts_demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/account")
public class ConfigTestController {

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${pg-host}")
    private String pgHost;

    @Value("${app.name}")
    private String appName;

    @GetMapping("/config-test")
    public String testConfig() {
        return String.format(
                "App: %s\nDB URL: %s\nPG Host: %s",
                appName, datasourceUrl, pgHost
        );
    }
}