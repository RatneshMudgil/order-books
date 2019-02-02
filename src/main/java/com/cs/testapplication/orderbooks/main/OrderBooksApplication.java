package com.cs.testapplication.orderbooks.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.cs.testapplication.orderbooks.entity")
@EnableJpaRepositories("com.cs.testapplication.orderbooks.repository")

public class OrderBooksApplication {

	private static final String PID_FILE_NAME = "application.pid";
	
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(OrderBooksApplication.class);
		springApplication.addListeners(new ApplicationPidFileWriter(PID_FILE_NAME));
		springApplication.run(args);
	}
}