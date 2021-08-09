package com.example.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories("com.example.clients")
@EntityScan("com.example.clients")
@SpringBootApplication
@ComponentScan({"com.example.clients"})
public class ClientsApplication {

	@Autowired
	public PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(ClientsApplication.class, args);

		System.out.println("Hello World!");
	}
}
