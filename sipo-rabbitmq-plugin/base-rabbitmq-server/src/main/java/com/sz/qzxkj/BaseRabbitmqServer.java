package com.sz.qzxkj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BaseRabbitmqServer {

	public static void main(String[] args) {
		SpringApplication.run(BaseRabbitmqServer.class, args);
	}

}
