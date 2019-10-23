package com.shui.sqlite;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@MapperScan(basePackages = "com.shui.sqlite.mapper")
@SpringBootApplication
@EnableConfigurationProperties
public class SqliteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqliteApplication.class, args);
	}

}
