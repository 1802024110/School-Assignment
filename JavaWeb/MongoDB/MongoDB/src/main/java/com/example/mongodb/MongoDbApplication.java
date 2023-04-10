package com.example.mongodb;

import com.example.mongodb.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class MongoDbApplication {

    @Autowired
    ItemRepository groceryItemRepo;

    public static void main(String[] args) {
        SpringApplication.run(MongoDbApplication.class, args);
    }

}
