package com.example.accounts_demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/account")
public class ConfigTestController {

    @Value("${spring.datasource.url:DEFAULT_ERROR}")
    private String pgdatasourceUrl;

    @Value("${pg-host:DEFAULT_ERROR}")
    private String pgHost;

    @Value("${app.name:DEFAULT_ERROR}")
    private String appName;

    @Value("${spring.data.mongodb.host:DEFAULT_ERROR}")
    private String mongoDbHost;

    @Value("${spring.data.mongodb.port:DEFAULT_ERROR}")
    private String mongoDbPort;

    @Value("${spring.data.mongodb.authentication-database:DEFAULT_ERROR}")
    private String mongoDbAuthDb;

    @Value("${spring.data.mongodb.uri:DEFAULT_ERROR}")
    private String mongoDbUri;

    @Value("${externalApiKey:DEFAULT_ERROR}")
    private String externalApiKey;

    @Value("${path:DEFAULT_ERROR}")
    private String path;

    @GetMapping("/config-test")
    public String testConfig() {
        return String.format(
                "App: %s\nDB URL: %s\nPG Host: %s\nMongo DB Host: %s\nMongo DB port: %s\nMongo DB authDb: %s\nMongo DB uri: %s\nExternal API Key: %s\nAPI Endpoint: %s",
                appName, pgdatasourceUrl, pgHost, mongoDbHost, mongoDbPort, mongoDbAuthDb,mongoDbUri,externalApiKey,path
        );
    }
}