package com.gmail.volodymyrdotsenko.routing.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {LiquibaseAutoConfiguration.class})
@ComponentScan(basePackages = "com.gmail.volodymyrdotsenko.routing")
@EntityScan(basePackages = {"com.gmail.volodymyrdotsenko.routing.backend.domain"})
@EnableJpaRepositories(basePackages = "com.gmail.volodymyrdotsenko.routing.backend.repositories")
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
}
