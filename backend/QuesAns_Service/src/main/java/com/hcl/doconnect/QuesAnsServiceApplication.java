package com.hcl.doconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class QuesAnsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuesAnsServiceApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		
		System.out.println("I am Inside RestTemplate");
		
		return new RestTemplate();
	}

}
