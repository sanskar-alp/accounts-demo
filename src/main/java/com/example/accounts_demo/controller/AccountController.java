package com.example.accounts_demo.controller;

import com.example.accounts_demo.config.AccountTypes;
import com.example.accounts_demo.config.SharedConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
@RefreshScope
public class AccountController {

    @Value("${app.name:DEFAULT-ERROR}")
    private String applicationName;

    @Value("${app.environment:DEFAULT-ERROR}")
    private String environment;

    private final SharedConfig sharedConfig;
    private final AccountTypes accountTypes;

    public AccountController(SharedConfig sharedConfig, AccountTypes accountTypes) {
        this.sharedConfig = sharedConfig;
        this.accountTypes = accountTypes;
    }

    @GetMapping("/config")
    public String getAccountServiceConfig() {
        return "Fetched config for app name: "+applicationName+" | Environment: "+environment;
    }

    @GetMapping("/config/shared")
    public String getAccountServiceSharedConfig() {
        return "Fetched shared config for app name is:  "+applicationName+" | Environment: "+environment+ " | Rebate rate is: "+sharedConfig.getRebateRate()+
                " | Minimum age is : "+sharedConfig.getMinimumAge();
    }

    @GetMapping("/account-types")
    public List<String> getAccountTypesConfig() {
        return accountTypes.getTypesOfAccounts();
    }

}
