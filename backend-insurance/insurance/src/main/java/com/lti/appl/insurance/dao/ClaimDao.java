package com.lti.appl.insurance.dao;

import com.lti.appl.insurance.beans.Claim;

public interface ClaimDao {
	
	public void submitAndUpdate(Claim claim);

	Customer findByCustomerId(int id);

	Policy findByPolicyId(int id);

}
