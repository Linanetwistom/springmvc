package com.store.webstore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.store.webstore.mapper")
public class WebstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebstoreApplication.class, args);
	}

}
