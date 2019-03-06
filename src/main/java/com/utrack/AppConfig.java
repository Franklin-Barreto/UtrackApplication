package com.utrack;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.utrack.config.JPAConfig;

@Configuration
public class AppConfig {

	@Bean
	public JPAConfig jpaConfig() {
		return new JPAConfig();
	}
	
	
}
