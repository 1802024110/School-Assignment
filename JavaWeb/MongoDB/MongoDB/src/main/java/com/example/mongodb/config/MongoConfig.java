package com.example.mongodb.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class MongoConfig {

    @Bean
    public MongoClientSettings mongoSettings() {
        return MongoClientSettings.builder().
                applyToConnectionPoolSettings(builder -> builder
                        .maxConnectionIdleTime(3600000,TimeUnit.SECONDS)).build();
    }
}
