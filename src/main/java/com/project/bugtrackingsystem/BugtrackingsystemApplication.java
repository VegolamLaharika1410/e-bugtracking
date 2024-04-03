package com.project.bugtrackingsystem;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BugtrackingsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugtrackingsystemApplication.class, args);
		System.out.println("The Bug Tracking Application is Started now.");
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
