package com.lti.appl.insurance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.appl.insurance.beans.Customer;
import com.lti.appl.insurance.beans.User;
import com.lti.appl.insurance.exceptions.CustomExceptions;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void register(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		Customer addCustomer = customer;
		em.persist(addCustomer);

	}

	@Override
	public List<Customer> getCustomerList() {
		// TODO Auto-generated method stub
		System.out.println("debug msg: inside customer dao");
		String sql = "Select customer from Customer customer";
		Query qry = em.createQuery(sql);
		List<Customer> customerList = qry.getResultList();

		return customerList;
	}

	@Override
	public Customer searchCustomerbyId(int customerId) throws CustomExceptions {
		// TODO Auto-generated method stub
		String sql = "Select customer from Customer customer where customer.customerId=:newcustomerId";
		Query qry = em.createQuery(sql);
		qry.setParameter("newcustomerId", customerId);

		Customer searchCustomer;
		try {
			searchCustomer = (Customer) qry.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new CustomExceptions("Record Not Found");

		}
		return searchCustomer;
	}

	@Override
	@Transactional
	public void updateCustomer(int customerId, Customer customer) throws CustomExceptions {
		// TODO Auto-generated method stub
		String sql = "Update Customer customer set customer.customerName=:newCustomerName, customer.emailId=:newEmailId, customer.contactNo=:newContactNo where customer.customerId=:newcustomerId";
		Query qry = em.createQuery(sql);
		qry.setParameter("newcustomerId", customerId);
		qry.setParameter("newCustomerName", customer.getCustomerName());
		qry.setParameter("newEmailId", customer.getEmailId());
		qry.setParameter("newContactNo", customer.getContactNo());
		
		qry.executeUpdate();
	}

}
