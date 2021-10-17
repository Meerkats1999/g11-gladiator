package com.lti.appl.insurance.services;

import com.lti.appl.insurance.beans.Claim;
import com.lti.appl.insurance.exceptions.InsuranceServiceException;


public interface ClaimService {
	
	void saveAndUpdate(Claim claim) throws InsuranceServiceException;
	

	Customer findByCustomerId(int id);

	Policy findByPolicyId(int id);
}
