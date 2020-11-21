package com.ram.jenkins;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(value = "Swagger2JenkinsController", description = "This REST Api related to jenkins Message!!!!")
@RestController
public class JenkinsController {

	@GetMapping("/jenkins")
	public String getJenkins() {
		return "welcome to jenkis spring boot project";
	}
	
	@GetMapping("/jenkins-json")
	public List<Customer> getJenkinsJson() {
		List<Customer> asList = Arrays.asList(new Customer(1l,"ram",60000d),new Customer(1l,"ram",60000d),new Customer(1l,"ram",60000d),new Customer(1l,"ram",60000d),new Customer(1l,"ram",60000d));
		return asList;
	}

}
