package com.ht.springcloudserver8082;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Springcloudserver8082Application {

	public static void main(String[] args) {
		SpringApplication.run(Springcloudserver8082Application.class, args);
	}

}
