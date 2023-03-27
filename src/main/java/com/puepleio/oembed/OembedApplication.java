package com.puepleio.oembed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients //for feign client
@SpringBootApplication
public class OembedApplication {

	public static void main(String[] args) {
		SpringApplication.run(OembedApplication.class, args);
	}

}
