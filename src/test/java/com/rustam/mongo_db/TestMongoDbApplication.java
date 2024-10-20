package com.rustam.mongo_db;

import org.springframework.boot.SpringApplication;

public class TestMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.from(MongoDbApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
