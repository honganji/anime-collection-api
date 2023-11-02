package com.example.animecollectionapiv2;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnimeCollectionApiV2Application {

	public static void main(String[] args) {
//		Dotenv dotenv = Dotenv.configure().load();
//
//		// Access the values in your application.properties
//		System.setProperty("spring.datasource.url", dotenv.get("AIVEN_DB_URL"));
//		System.setProperty("spring.datasource.username", dotenv.get("AIVEN_USER_NAME"));
//		System.setProperty("spring.datasource.password", dotenv.get("AIVEN_PASSWORD"));

		SpringApplication.run(AnimeCollectionApiV2Application.class, args);
	}

}
