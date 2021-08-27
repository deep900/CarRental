package com.pwc.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootApp {

	public static void main(String[] args) {		
		System.out.println("Starting the car rental application");
		SpringApplication.run(SpringBootApp.class);
	}
}
