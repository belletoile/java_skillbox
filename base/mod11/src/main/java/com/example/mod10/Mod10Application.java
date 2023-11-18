package com.example.mod10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan("com.example.mod10.*")
@EntityScan("com.example.mod10.models")
@EnableJpaRepositories()
public class Mod10Application {

	public static void main(String[] args) {
		SpringApplication.run(Mod10Application.class, args);
	}

}
