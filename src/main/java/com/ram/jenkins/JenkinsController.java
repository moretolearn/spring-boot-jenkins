package com.ram.jenkins;

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

}
