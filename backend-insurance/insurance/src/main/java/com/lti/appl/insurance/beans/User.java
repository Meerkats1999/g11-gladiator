package com.lti.appl.insurance.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue(generator="user_id_seq")
	@SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "PASSWORD")
	private String password;

//	@Column(name = "OTP")
//	private String otp;

	@Column(name = "ROLE")
	private String role;

	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;

	public User() {
		super();
	}

	public User(String emailId, String password, String role, Customer customer) {
		super();
		this.emailId = emailId;
		this.password = password;
//		this.otp = otp;
		this.role = role;
		this.customer = customer;
	}

	public User(int userId, String emailId, String password, String role, Customer customer) {
		super();
		this.userId = userId;
		this.emailId = emailId;
		this.password = password;
//		this.otp = otp;
		this.role = role;
		this.customer = customer;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public String getOtp() {
//		return otp;
//	}
//
//	public void setOtp(String otp) {
//		this.otp = otp;
//	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", emailId=" + emailId + ", password=" + password + ", role=" + role
				+ ", customer=" + customer + "]";
	}

}
