package com.lti.appl.insurance.dao;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.appl.insurance.beans.Claim;

@Repository
public class ClaimDaoImpl implements ClaimDao {
	
	
	@PersistenceContext
	private EntityManager em=null;

	@Override
	public void submitAndUpdate(Claim claim) {
		em.merge(claim);
		
	}

	@Override
	public Customer findByCustomerId(int id) {
	
		return em.find(Customer.class, id);
	}

	@Override
	public Policy findByPolicyId(int id) {
		
		return em.find(Policy.class, id);
	}
	
	
}
