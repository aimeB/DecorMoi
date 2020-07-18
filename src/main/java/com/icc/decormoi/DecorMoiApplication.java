package com.icc.decormoi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.icc.decormoi.dao.ClientRepository;

@SpringBootApplication
@ComponentScan(basePackages = {"com.icc.decormoi.entities"})
public class DecorMoiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DecorMoiApplication.class, args);
		
		
		
	}

}
