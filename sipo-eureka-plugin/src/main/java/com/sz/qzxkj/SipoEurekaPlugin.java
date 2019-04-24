package com.sz.qzxkj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SipoEurekaPlugin {

	public static void main(String[] args) {

		SpringApplication.run(SipoEurekaPlugin.class, args);
	}

}
