package com.example.demo;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;


@SpringBootApplication
@ComponentScan(basePackages="com.example.demo.*")
//@EntityScan(basePackageClasses = {SpringBootTicketApplication.class, Jsr310JpaConverters.class})
public class SpringBootTicketApplication extends SpringBootServletInitializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootTicketApplication.class);

	
	
	public static void main(String[] args) throws Exception{
		SpringApplication.run(SpringBootTicketApplication.class, args);
		
		LOGGER.info("START SPRING BOOT TICKET APPLICATION TEST!");
	}
	
	
		@Bean
	    public CommandLineRunner run(ApplicationContext appContext) {
	        return args -> {

	            System.out.println("START APPLICATION!");

	        };
	    
		
	}
}





