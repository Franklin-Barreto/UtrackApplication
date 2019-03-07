package com.utrack.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.utrack.repository.DriverRepository;

@Configuration
@ComponentScan(basePackages = { "com.utrack.service" })
@EnableJpaRepositories(basePackageClasses = DriverRepository.class, enableDefaultTransactions = false)
public class AppConfig {

}
