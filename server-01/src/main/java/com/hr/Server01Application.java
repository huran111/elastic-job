package com.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.util.concurrent.CompletionService;

@SpringBootApplication
@ImportResource(value = {"classpath:spring/job.xml"})
public class Server01Application {
	public static void main(String[] args) {
		SpringApplication.run(Server01Application.class, args);
	}
}
