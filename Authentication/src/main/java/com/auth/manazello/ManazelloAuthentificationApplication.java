package com.auth.manazello;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;
import org.modelmapper.ModelMapper;


@SpringBootApplication
@OpenAPIDefinition
@EnableEurekaClient
@CrossOrigin(origins = "*")
public class ManazelloAuthentificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManazelloAuthentificationApplication.class, args);
	}
	@Bean
	public RestTemplate resTemplate()
	{
		return new RestTemplate();
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
