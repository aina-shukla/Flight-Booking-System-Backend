package com.bookingInfoService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2

public class BookingInfoServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(BookingInfoServiceApplication.class, args);
		System.out.println("Booking Information application started.....");
	}
	
	@Bean
	public Docket swaggerConfig(){
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.paths(PathSelectors.ant("/bookingservice/**"))
			// .paths(RequestHandlerSelectors.basePackage("com.demo"))
			.build()
			.apiInfo(metadata())
			;
	}
	
	private ApiInfo metadata(){
		return new ApiInfoBuilder()
			.title("This is booking service")
			.description("Booking service description")
			.version("1.2.8")
			.license("www.booking_service.url")
			.contact(new Contact("booking", "booking-service.page", "booking-service@gmail.com"))
			.build();
	}

}
