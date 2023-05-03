package com.rajesh.customermanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomerManagentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerManagentServiceApplication.class, args);
	}

}
