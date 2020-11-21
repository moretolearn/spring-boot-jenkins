package com.ram.jenkins;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	
	@Bean
	public Docket restApi(){
		return new Docket(DocumentationType.SWAGGER_2)
		.select()
		.apis(RequestHandlerSelectors.basePackage("com.ram.jenkins"))
		.paths(PathSelectors.any())
		.build()
		.apiInfo(apiInfo());

	}

	public ApiInfo apiInfo() {
		return new ApiInfo(
					"Spring Boot Jenkins REST API", 
					"Spring Boot Jenkins REST API for Application", 
					"1.0",
					"Terms of service", 
					 new Contact(
							 "Ram", 
							 "http://www.ram.com/", 
							 "ram@gmail.com"
					),
					"Apache License Version 2.0",
					"https://www.apache.org/licenses/LICENSE-2.0"
				);
	}
	
	//URL  to see documentation
	//http://localhost:port-num/swagger2-demo-app/v2/api-docs
	//http://localhost:9090/swagger2-demo-app/swagger-ui.html

}
