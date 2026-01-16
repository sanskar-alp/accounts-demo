package com.example.accounts_demo.config;


import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;
import java.util.List;

@Setter
@Configuration
@ConfigurationProperties(prefix = "account")
public class AccountTypes {
    private List<String> types;

    public List<String> getTypesOfAccounts() {
        if (!CollectionUtils.isEmpty(types)) {
            return types;
        }
        return null;
    }
}