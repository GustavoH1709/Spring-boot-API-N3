package com.gustavo.n3_poo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class N3PooApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(N3PooApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}
}
