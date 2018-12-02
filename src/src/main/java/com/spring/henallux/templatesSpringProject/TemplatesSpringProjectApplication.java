package com.spring.henallux.templatesSpringProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TemplatesSpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemplatesSpringProjectApplication.class, args);
	}
}
