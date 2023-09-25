package com.prospect.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
public class ProspectManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProspectManagerApplication.class, args);
	}

}
