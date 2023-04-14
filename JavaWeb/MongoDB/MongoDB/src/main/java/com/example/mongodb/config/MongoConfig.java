package com.example.mongodb.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.concurrent.TimeUnit;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "mygrocerylist";
    }

    @Override
    @Bean
    public MongoClient mongoClient() {
        MongoClientSettings.Builder builder = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString("mongodb+srv://root:2002zengyuan@cluster0.yew5ol9.mongodb.net"))
                .applyToSocketSettings(socketSettings -> socketSettings
                        .connectTimeout(10000, TimeUnit.MINUTES)
                        .readTimeout(10000, TimeUnit.MINUTES));
        return MongoClients.create(builder.build());
    }
}