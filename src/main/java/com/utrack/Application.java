package com.utrack;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

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
		ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		Application p = context.getBean(Application.class);
		p.start();
	}

	public void start() {

		String driverDto = restTemplate.exchange(restAPIUrl, HttpMethod.GET, null, String.class).getBody();
		if (arquivoExiste() && (arquivoParaComparar(driverDto))) {
			System.out.println("igual" + arquivoParaComparar(driverDto));
		}
	}

	public boolean arquivoExiste() {
		return Files.exists(Paths.get("data.json"));
	}

	public boolean arquivoParaComparar(String arquivo) {
		String infos = null;
		try {
			infos = new String(Files.readAllBytes(Paths.get("data.json")), StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DigestUtils.md5Hex(infos).equals(DigestUtils.md5Hex(arquivo));
	}

	public void escreverArquivo(String infos) {
		try {
			FileWriter fileWriter = new FileWriter("data.json");
			fileWriter.write(infos);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
