package com.server.fbs_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FbsServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FbsServerApplication.class, args);
	}

}
