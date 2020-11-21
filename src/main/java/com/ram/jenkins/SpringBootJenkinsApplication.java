package com.ram.jenkins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootJenkinsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJenkinsApplication.class, args);
	}
	
	@GetMapping("/jenkins")
	public String getJenkins() {
		return "welcome to jenkis spring boot project";
	}

}
