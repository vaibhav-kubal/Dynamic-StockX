package com.inventory.assmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration(
//exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@ComponentScan(basePackages = { "com.inventory.assmt.api.*"})
@EntityScan(basePackages = { "com.inventory.assmt.api.entity"})
@EnableJpaRepositories("com.inventory.assmt.api.repository")
public class AssmtApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AssmtApplication.class, args);
	}
	
	

}
