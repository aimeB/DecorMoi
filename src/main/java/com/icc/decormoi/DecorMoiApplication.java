package com.icc.decormoi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.icc.decormoi.domaine.Fiancaille;

@SpringBootApplication
@ComponentScan(basePackages = {"com.icc.decormoi.entities"})
public class DecorMoiApplication implements CommandLineRunner {

	@Autowired
	//private ClientRepository clientRepository;
	public static void main(String[] args) {
		SpringApplication.run(DecorMoiApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Client c1 = clientRepository.save(new Client("ak", "bell", "avenue des sept bonnier", 04653, "aime.badibanga.sms@gmail.com", new Date()));
		//Client c2 = clientRepository.save(new Client("jim", "bill", "avenue des corrolaires", 04611, "jim.billy@gmail.com", new Date()));
		}
	
}