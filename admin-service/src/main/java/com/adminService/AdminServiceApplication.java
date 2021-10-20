package com.adminService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.bind.annotation.CrossOrigin;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@CrossOrigin
public class AdminServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(AdminServiceApplication.class, args);
		System.out.println("Admin application started.....");
	}

}
