package com.rajesh.accountmgmtservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AccountrManagentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountrManagentServiceApplication.class, args);
	}

}
