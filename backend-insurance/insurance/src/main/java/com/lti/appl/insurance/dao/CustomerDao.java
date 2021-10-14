package com.lti.appl.insurance.dao;

import java.util.List;

import com.lti.appl.insurance.beans.Customer;
import com.lti.appl.insurance.exceptions.CustomExceptions;

public interface CustomerDao {

	public void register(Customer customer) throws Exception;
	public List<Customer> getCustomerList();
	public Customer searchCustomerbyId(int customerId) throws CustomExceptions;
	public void updateCustomer(int customerId, Customer customer) throws CustomExceptions;
	
}
