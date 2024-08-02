package br.com.igrejas.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"br.com.igrejas"})
@EntityScan("br.com.igrejas.domain.model")
@EnableJpaRepositories("br.com.igrejas.infrastructure.repository")
public class RecepcaoIgrejaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecepcaoIgrejaApplication.class, args);
	}

}
