package com.uvg.conneto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.uvg.conneto")
@EnableJpaRepositories(basePackages = "com.uvg.conneto.repositories")
@EntityScan(basePackages = "com.uvg.conneto.models")
public class ConnetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConnetoApplication.class, args);
	}
}