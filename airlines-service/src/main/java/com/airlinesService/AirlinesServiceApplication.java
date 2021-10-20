package com.airlinesService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@EnableKafka
public class AirlinesServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(AirlinesServiceApplication.class, args);
		System.out.println("Airlines application started.....");
	}
	
	@Bean
	public Docket swaggerConfig(){
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.paths(PathSelectors.ant("/airlinesservice/**"))
			// .paths(RequestHandlerSelectors.basePackage("com.demo"))
			.build()
			.apiInfo(metadata())
			;
	}

	private ApiInfo metadata(){
		return new ApiInfoBuilder()
			.title("This is airlines service")
			.description("Airlines service description")
			.version("1.2.9")
			.license("www.airlines_service.url")
			.contact(new Contact("airlnes", "airlines-service.page", "airlines-service@gmail.com"))
			.build();
	}
}
