package com.lti.appl.insurance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.appl.insurance.beans.Claim;
import com.lti.appl.insurance.dao.ClaimDao;
import com.lti.appl.insurance.dao.ClaimDaoImpl;
import com.lti.appl.insurance.exceptions.InsuranceServiceException;

@Service
public class ClaimServiceImpl implements ClaimService {
	
	@Autowired
	ClaimDao claimDao;

	@Override
	public void saveAndUpdate(Claim claim) throws InsuranceServiceException {
		claimDao.submitAndUpdate(claim);
		
	}

	@Override
	public Customer findByCustomerId(int id) {
		// TODO Auto-generated method stub
		return claimDao.findByCustomerId(id);
	}

	@Override
	public Policy findByPolicyId(int id) {
		// TODO Auto-generated method stub
     return claimDao.findByPolicyId(id);
	}
}
