package com.ram.jenkins;
//package com.ram.jenkins;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//	
//	
//	@Bean
//	public Docket restApi(){
//		return new Docket(DocumentationType.SWAGGER_2)
//		.select()
//		.apis(RequestHandlerSelectors.basePackage("com.ram.jenkins"))
//		.paths(PathSelectors.any())
//		.build()
//		.apiInfo(apiInfo());
//
//	}
//
//	public ApiInfo apiInfo() {
//		return new ApiInfo(
//					"Spring Boot Jenkins REST API", 
//					"Spring Boot Jenkins REST API for Application", 
//					"1.0",
//					"Terms of service", 
//					 new Contact(
//							 "Ram", 
//							 "http://www.ram.com/", 
//							 "ram@gmail.com"
//					),
//					"Apache License Version 2.0",
//					"https://www.apache.org/licenses/LICENSE-2.0"
//				);
//	}
//	
//	//URL  to see documentation
//	//http://localhost:port-num/swagger2-demo-app/v2/api-docs
//	//http://localhost:9090/swagger2-demo-app/swagger-ui.html
//
//}
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfig {

  @Value("${jenkins.openapi.dev-url}")
  private String devUrl;

  @Value("${jenkins.openapi.prod-url}")
  private String prodUrl;

  @Bean
  public OpenAPI myOpenAPI() {
    Server devServer = new Server();
    devServer.setUrl(devUrl);
    devServer.setDescription("DEV");

    Server prodServer = new Server();
    prodServer.setUrl(prodUrl);
    prodServer.setDescription("PROD");

    Contact contact = new Contact();
    contact.setEmail("ram@gmail.com");
    contact.setName("Spring-Boot-Jenkins");
    contact.setUrl("https://github.com/moretolearn");

    License mitLicense = new License().name("Git Hub").url("https://github.com/moretolearn");

    Info info = new Info()
        .title("Spring-Boot-Jenkins")
        .version("1.0")
        .contact(contact)
        .description("This API exposes endpoints to manage jenkins.").termsOfService("https://github.com/moretolearn")
        .license(mitLicense);

    return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
  }
  
  // To see the docs
  //http://localhost:8080
  //http://localhost:8080/v3/api-docs
}