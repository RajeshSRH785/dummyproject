package com.rajesh.customermanagementservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.rajesh.customermanagementservice.model.Customer;
import com.rajesh.customermanagementservice.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/customer")
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
		String status = customerService.upsert(customer);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
		Customer customer = customerService.getCustomerById(id);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> getAllCustomer(@RequestBody Customer customer) {
		List<Customer> allCustomers = customerService.getAllCustomer();
		return new ResponseEntity<>(allCustomers, HttpStatus.OK);
	}

	@PutMapping("/customer")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) {
		String status = customerService.upsert(customer);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@DeleteMapping("/customer/{id}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable Integer id) {
		String status = customerService.deleteCustomer(id);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

}
