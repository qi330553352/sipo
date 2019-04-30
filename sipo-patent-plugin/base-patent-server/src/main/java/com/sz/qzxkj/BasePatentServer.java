package com.sz.qzxkj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableCaching
@EnableEurekaClient
@SpringBootApplication
public class BasePatentServer {

	public static void main(String[] args) {

		SpringApplication.run(BasePatentServer.class, args);
	}

}
