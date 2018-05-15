package com.camunda.na.training;


import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import javax.servlet.Filter;

@SpringBootApplication
@EnableProcessApplication
public class SpringBootProcessApplication {

	@Bean
	public Filter testFilter() {
			return new TestFilter();
	}


	public static void main(String[] args) {
		
		
		SpringApplication.run(SpringBootProcessApplication.class, args);
		
		
		
		
		
		
	}
}