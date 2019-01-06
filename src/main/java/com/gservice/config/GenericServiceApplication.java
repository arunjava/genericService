package com.gservice.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.gservice.entity"})
/*
 * To scan repository package otherwise not working
 */
@EnableJpaRepositories(basePackages = {"com.gservice.repository"})
@ComponentScan(basePackages = {"com.gservice"})
public class GenericServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenericServiceApplication.class, args);
	}
}
