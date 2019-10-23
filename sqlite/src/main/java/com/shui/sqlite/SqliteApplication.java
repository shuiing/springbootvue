package com.shui.sqlite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SqliteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqliteApplication.class, args);
	}

}
