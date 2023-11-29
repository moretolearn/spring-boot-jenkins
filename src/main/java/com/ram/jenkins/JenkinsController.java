package com.ram.jenkins;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

import javax.xml.datatype.DatatypeFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Swagger2JenkinsController", description = "This REST Api related to jenkins Message!!!!")
@RestController
public class JenkinsController {

	@Autowired
	Environment environment;
	
	@Autowired
	BuildProperties buildProperties;

	@GetMapping("/jenkins")
	public String getJenkins() {
		return "welcome to jenkis spring boot project";
	}

	@Operation(summary = "Customer Data", description = "Get All Customers List")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "successfully get a customers list"),
			@ApiResponse(responseCode = "409", description = "No Customer") })
	@GetMapping("/jenkins-json")
	public List<Customer> getJenkinsJson() {
		List<Customer> asList = Arrays.asList(new Customer(1l, "ram", 60000d), new Customer(2l, "mohan", 60000d),
				new Customer(3l, "reddy", 60000d), new Customer(4l, "yanumula", 60000d),
				new Customer(5l, "bhagi", 60000d));
		return asList;
	}

	@GetMapping("/appinfo")
	public Map<String, String> getAppInfo() throws UnknownHostException {
		return getAppinfo();
	}

	public Map<String, String> getAppinfo() throws UnknownHostException {
		Map<String, String> getenv = System.getenv();
		Set<Entry<String, String>> entrySet = getenv.entrySet();
		for (Entry<String, String> value : getenv.entrySet()) {
			System.out.println(value.getKey() + " - " + value.getValue());
		}
//		System.out.println("Current JVM version - " + System.getProperty("java.version"));
//        System.out.println("Current JVM version - " + Runtime.version());
//        System.out.println("Your OS name -> " + System.getProperty("os.name"));

//        System.out.println("Your OS version -> " + System.getProperty("os.version"));
//
//        System.out.println("Your OS Architecture -> " + System.getProperty("os.arch"));
//        
//        System.out.println(System.getProperty("java.version")); 
//
//        System.out.println(System.getProperty("java.home")); 
//
//        System.out.println(System.getProperty("user.name"));
//		System.out.println(System.getenv("JAVA_HOME"));
		
		Map<String, String> hashMap = new HashMap<>();
		
		if(Objects.nonNull(buildProperties)) {
			hashMap.put("Artifact", buildProperties.getArtifact());
			hashMap.put("Name", buildProperties.getName());
			hashMap.put("Version", buildProperties.getVersion());
			hashMap.put("Build Time", buildProperties.getTime().toString());
		}

		if (Objects.nonNull(environment)) {
			if (Objects.nonNull(environment.getActiveProfiles()) && environment.getActiveProfiles().length != 0) {
				hashMap.put("Profile", environment.getActiveProfiles()[0]);
			}
		}

		hashMap.put("AppName", "Jenkins CI CD");
		hashMap.put("Java Version", System.getProperty("java.version"));
		hashMap.put("OS Name", System.getProperty("os.name"));
		hashMap.put("OS Version", System.getProperty("os.version"));
		hashMap.put("OS Arch", System.getProperty("os.arch"));
		hashMap.put("User Name", System.getProperty("user.name"));
		hashMap.put("Host Name", System.getenv("COMPUTERNAME"));
		hashMap.put("IP Address", Inet4Address.getLocalHost().getHostAddress());
		hashMap.put("Time Zone", System.getProperty("user.timezone"));
		hashMap.put("Timestamp", getCurrentTime());
		hashMap.put("Prod Name", InetAddress.getLocalHost().getHostName());
		hashMap.put("Host", InetAddress.getLoopbackAddress().getHostName());
		return hashMap;
	}
	
	String getCurrentTime(){
		String cutrrentTime = "";
		try {
			cutrrentTime = DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar)GregorianCalendar.getInstance()).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cutrrentTime;
	}

}
