package com.rajesh.customermanagementservice.dao;

import org.springframework.data.repository.CrudRepository;

import com.rajesh.customermanagementservice.model.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
