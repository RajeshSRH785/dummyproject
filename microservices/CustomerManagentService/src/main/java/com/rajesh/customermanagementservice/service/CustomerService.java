package com.rajesh.customermanagementservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajesh.customermanagementservice.dao.CustomerRepository;
import com.rajesh.customermanagementservice.model.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	
	public String upsert(Customer customer) {
		customerRepository.save(customer);
		
		return "Done Successfully";
	}

	public Customer getCustomerById(int id) {
		Optional<Customer> findById = customerRepository.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	public List<Customer> getAllCustomer() {
		return (List<Customer>) customerRepository.findAll();
	}


	public String deleteCustomer(int id) {
		if (customerRepository.existsById(id)) {
			customerRepository.deleteById(id);
			return "Deleted Successfully";
		}
		else {
			return "No Record Found";
		}
		

	}

}
