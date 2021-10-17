package com.lti.appl.insurance.beans;


import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.lti.projectgladiator.ltinsure.beans.Customer;

@Entity
@Table(name="CLAIM_HISTORY")
public class Claim {
	
	@Id
	@SequenceGenerator(name="claim_id_seq",sequenceName="claim_id_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="claim_id_seq")
	@Column(name="CLAIM_ID")
	private int claimId;
	
	@Column(name="CLAIM_DATE")
	private LocalDate claimDate;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="CLAIM_AMOUNT")
	private double claimAmount;
	
	@Column(name="REASON")
	private String reason;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="POLICY_ID")
	private Policy policy;

	public Claim() {
		super();
		
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Claim(int claimId, LocalDate claimDate, String status, float claimAmount, String reason, Policy policy) {
		super();
		this.claimId = claimId;
		this.claimDate = claimDate;
		this.status = status;
		this.claimAmount = claimAmount;
		this.reason = reason;
		this.policy = policy;
	}

	public int getClaimId() {
		return claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	public LocalDate getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(LocalDate claimDate) {
		this.claimDate = claimDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	@Override
	public String toString() {
		return "Claim [claimId=" + claimId + ", claimDate=" + claimDate + ", status=" + status + ", claimAmount="
				+ claimAmount + ", reason=" + reason + ", policy=" + policy + "]";
	}
	
	

}
