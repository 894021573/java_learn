package com.ht.springcloudserver8081;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Springcloudserver8081Application {

	public static void main(String[] args) {
		SpringApplication.run(Springcloudserver8081Application.class, args);
	}

}
