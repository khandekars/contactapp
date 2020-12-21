package com.example.contactapp;

import com.example.contactapp.contacts.Contact;
import com.example.contactapp.contacts.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ContactApplication {

	private static final Logger log = LoggerFactory.getLogger(ContactApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ContactApplication.class, args);
	}

	@Bean
	CommandLineRunner test(ContactRepository repository) {
		return args -> {
			repository.save(new Contact("Shirish", "Khandekar", "sk@email.com"));
			repository.save(new Contact("", "Khandekar1", "sk1@email.com"));
			//repository.save(new Contact("Shirish", "Khandekar", "sk@email.com"));

			repository.findAll().forEach(contact -> log.info(contact.toString()));
			log.info("findByEmail");
			log.info("--------------");
			repository.findByEmail("sk2@email.com").forEach(contact -> log.info(contact.toString()));
		};
	}
}
