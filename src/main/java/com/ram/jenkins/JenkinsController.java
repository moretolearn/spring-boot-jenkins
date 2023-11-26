package com.ram.jenkins;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name  = "Swagger2JenkinsController", description  = "This REST Api related to jenkins Message!!!!")
@RestController
public class JenkinsController {

	@GetMapping("/jenkins")
	public String getJenkins() {
		return "welcome to jenkis spring boot project";
	}
	
	@Operation(
            summary = "Customer Data",
            description = "Get All Customers List")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successfully get a customers list"),
            @ApiResponse(responseCode = "409", description = "No Customer")
    })
	@GetMapping("/jenkins-json")
	public List<Customer> getJenkinsJson() {
		List<Customer> asList = Arrays.asList(new Customer(1l,"ram",60000d),new Customer(2l,"mohan",60000d),new Customer(3l,"reddy",60000d),new Customer(4l,"yanumula",60000d),new Customer(5l,"bhagi",60000d));
		return asList;
	}

}
