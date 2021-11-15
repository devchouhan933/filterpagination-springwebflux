package com.reactivespring.fileterpagination;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class SpringbootWebfluxWebclientExample3Application {
	@Bean
	public WebClient webclientConfiguration() {
		return WebClient.builder().baseUrl("https://jsonmock.hackerrank.com/api/transactions")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_EVENT_STREAM_VALUE).build();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebfluxWebclientExample3Application.class, args);
	}

}
