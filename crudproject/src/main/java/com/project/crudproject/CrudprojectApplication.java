package com.project.crudproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudprojectApplication.class, args);
	}

	//for creating a command line application
	@Bean //CommandLineRunner is from springboot framework, so it will run after the beans have loaded
	public CommandLineRunner commandLineRunner(String[] args){
		 return runner ->{
			 System.out.println("Hello World");
		 };
	}


}
