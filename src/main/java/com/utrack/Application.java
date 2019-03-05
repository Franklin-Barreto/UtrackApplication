package com.utrack;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.utrack.dto.DriverDTO;
import com.utrack.dto.Response;

@Configuration
@PropertySource({ "classpath:application.properties" })
public class Application {

	@Value("${restapi.url}")
	private String restAPIUrl;

	private RestTemplate restTemplate = new RestTemplate();

	/*
	 * public ResponseEntity<String> getInfos() { List<LinkedHashMap<String,
	 * Object>> usersMap = restTemplate.getForObject(restAPIUrl, List.class); return
	 * usersMap; }
	 */

	@Value("${restapi.time}")
	private int time;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		Application p = context.getBean(Application.class);
		p.start();
	}

	public void start() {
		Response driverDto = restTemplate.getForObject(restAPIUrl, Response.class);
		System.out.println(driverDto.getResults().size());
		for (DriverDTO driverDTO2 : driverDto.getResults()) {
			System.out.println("TESTE"+driverDTO2.getFirstName());
		}
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
