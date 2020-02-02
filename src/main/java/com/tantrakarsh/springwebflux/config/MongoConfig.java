package com.tantrakarsh.springwebflux.config;

import com.mongodb.ConnectionString;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.tantrakarsh.springwebflux.repository")
public class MongoConfig extends AbstractReactiveMongoConfiguration {

    @Value("${port}")
    private int port;

    @Value("${dbname}")
    private String dbName;


    @Override
    public MongoClient reactiveMongoClient() {
        return MongoClients.create();
//        return MongoClients.create("mongodb://localhost"+":"+port);
    }

    @Override
    protected String getDatabaseName() {
        return dbName;
    }

    @Override
    public ReactiveMongoOperations reactiveMongoTemplate() throws Exception {
        return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
    }
}
