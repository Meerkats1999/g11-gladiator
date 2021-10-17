package com.lti.appl.insurance.controller;

import java.security.Policy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.appl.insurance.beans.Claim;
import com.lti.appl.insurance.dto.ClaimDto;
import com.lti.appl.insurance.exceptions.InsuranceServiceException;
import com.lti.appl.insurance.services.ClaimService;
import com.lti.appl.insurance.status.Status;
import com.lti.appl.insurance.status.Status.StatusType;

@RestController
@CrossOrigin
public class ClaimController {
	
	@Autowired
	ClaimService claimService;
	
	
	@GetMapping(path="/addClaimInsurance", consumes="application/json",produces="application/json")
	public Status submitClaimDetails(@RequestBody ClaimDto claimDto)
	{
		try {
			Claim claim=new Claim();
			claim.setClaimDate(claimDto.getDate());
			claim.setStatus(claimDto.getStatus());
			claim.setClaimAmount(claimDto.getAmount());
			claim.setReason(claimDto.getReason());
			
			
			Customer customer=claimService.findByCustomerId(claimDto.getCustomerId());
			claim.setCustomer(customer);
			
			
			Policy policy=claimService.findByPolicyId(claimDto.getPolicyId());
			claim.setPolicy(policy);
			
			
			claimService.saveAndUpdate(claim);
			
			Status status=new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Claim details submitted successfully!!");
			return status;
		}
		catch(InsuranceServiceException e) {
			Status status=new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
	}

}
