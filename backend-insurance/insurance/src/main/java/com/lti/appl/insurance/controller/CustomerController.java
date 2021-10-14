package com.lti.appl.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.appl.insurance.beans.Customer;
import com.lti.appl.insurance.exceptions.CustomExceptions;
import com.lti.appl.insurance.services.CustomerServiceImpl;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	CustomerServiceImpl customerService;
	
	// http://localhost:8082/customer/add
	@PostMapping("/add")
	public void insertNewCustomer(@RequestBody Customer customer) {
		try {
			customerService.register(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	// http://localhost:8082/customer/all
	@GetMapping("/all")
	public List<Customer> allCustomerList(){
		return customerService.getCustomerList();
	}
	
	// http://localhost:8082/customer/{customerId}
	@GetMapping("/{customerId}")
	public Customer searchEmployeeById(@PathVariable("customerId") int customerId) {
		try {
			return customerService.searchCustomerbyId(customerId);
		} catch (CustomExceptions e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	@PostMapping("/{customerId}/edit")
	public void updateEmployeeById(@PathVariable("customerId") int customerId, @RequestBody Customer customer) {
		try {
			customerService.updateCustomer(customerId, customer);
		} catch (CustomExceptions e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	
}
