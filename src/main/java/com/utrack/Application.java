package com.utrack;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.utrack.dto.Response;
import com.utrack.service.DriverService;

@Configuration
@PropertySource({ "classpath:application.properties" })
public class Application {

	@Value("${restapi.url}")
	private String restAPIUrl;

	private RestTemplate restTemplate = new RestTemplate();

	@Value("${restapi.time}")
	private int time;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.utrack.config");
		DriverService driverService = context.getBean(DriverService.class);
		driverService.findById(1);
	}

	public void start() {
		Response driverDto = restTemplate.getForObject(restAPIUrl, Response.class);
		System.out.println(driverDto.getResults().size());
	}

	@Bean
	public RestTemplate customRestTemplate() {
		HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		httpRequestFactory.setConnectionRequestTimeout(time);
		httpRequestFactory.setConnectTimeout(3);
		httpRequestFactory.setReadTimeout(3);

		return new RestTemplate(httpRequestFactory);
	}
}
