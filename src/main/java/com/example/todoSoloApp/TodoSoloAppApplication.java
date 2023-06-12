package com.example.todoSoloApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TodoSoloAppApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TodoSoloAppApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(TodoSoloAppApplication.class);
	}

}
