package com.ProyectoAula.PQRS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PqrsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PqrsApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer configuracionCORS() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**")
						.allowedOrigins("http://localhost:5173");
			}
		};
	}
}
