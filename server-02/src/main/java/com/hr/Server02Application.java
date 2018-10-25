package com.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource(value = {"classpath:spring/job.xml"})
@SpringBootApplication
public class Server02Application {

	public static void main(String[] args) {
		SpringApplication.run(Server02Application.class, args);
	}
}
