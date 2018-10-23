package com.justplay1994.github.baseframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class BaseFrameworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseFrameworkApplication.class, args);
	}
}
