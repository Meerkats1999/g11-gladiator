package com.lti.appl.insurance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.appl.insurance.beans.Customer;
import com.lti.appl.insurance.dao.CustomerDao;
import com.lti.appl.insurance.exceptions.CustomExceptions;

@Service(".customerService")
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao dao;
	
	@Override
	public void register(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		dao.register(customer);
		
	}

	@Override
	public List<Customer> getCustomerList() {
		// TODO Auto-generated method stub
		
		return dao.getCustomerList();
	}

	@Override
	public Customer searchCustomerbyId(int customerId) throws CustomExceptions {
		// TODO Auto-generated method stub
		return dao.searchCustomerbyId(customerId);
	}

	@Override
	public void updateCustomer(int customerId, Customer customer) throws CustomExceptions {
		// TODO Auto-generated method stub
		dao.updateCustomer(customerId, customer);
	}
	
}
