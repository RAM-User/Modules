package com.mySpringBoot.mySpringApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@ConfigurationProperties
@Configuration
@PropertySource("配置路径")
@Profile("dev")
public class Properties {

    public void property() {
        System.getProperties();
        SpringApplication springApplication = new SpringApplication();
        springApplication.setAdditionalProfiles();
    }


}
