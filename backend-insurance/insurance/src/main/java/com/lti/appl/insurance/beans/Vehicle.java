package com.lti.appl.insurance.beans;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="VEHICLE")
public class Vehicle {
	
	@Id
	@Column(name="VEHICLE_ID")
	@GeneratedValue(generator="vehicle_id_seq")
	@SequenceGenerator(name = "vehicle_id_seq", sequenceName = "vehicle_id_seq", allocationSize = 1)
	private int id;
	
	@Column(name="VEHICLE_TYPE")
	private String vehicleType;
	
	@Column(name="VEHICLE_MODEL")
	private String vehicleModel;
	
	@Column(name="MANUFACTURER")
	private String manufacturer;
	
	@Column(name="PURCHASE_DATE")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MMM-yyyy")
	private LocalDate purchaseDate;
	
	@Column(name="DRIVING_LISCENSE")
	private String drivingLiscense;
	
	@Column(name="RC_No")
	private String rcNo;
	
	@Column(name="ENGINE_NO")
	private String engineNo;
	
	@Column(name="CHASSIS_NO")
	private String chassisNo;
	
	@Column(name="ENGINE_TYPE")
	private String engineType;
	
	
	@Column(name="RENEW_DATE")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MMM-yyyy")
	private LocalDate renewDate;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="CUSTOMER_ID", nullable=false)
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Vehicle() {
		super();
	}
	
	

	public Vehicle(int id, String vehicleType, String vehicleModel, String manufacturer, LocalDate purchaseDate,
			String drivingLiscense, String rcNo, String engineNo, String chassisNo, String engineType,
			LocalDate renewDate, Customer customer) {
		super();
		this.id = id;
		this.vehicleType = vehicleType;
		this.vehicleModel = vehicleModel;
		this.manufacturer = manufacturer;
		this.purchaseDate = purchaseDate;
		this.drivingLiscense = drivingLiscense;
		this.rcNo = rcNo;
		this.engineNo = engineNo;
		this.chassisNo = chassisNo;
		this.engineType = engineType;
		this.renewDate = renewDate;
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getDrivingLiscense() {
		return drivingLiscense;
	}

	public void setDrivingLiscense(String drivingLiscense) {
		this.drivingLiscense = drivingLiscense;
	}

	public String getRcNo() {
		return rcNo;
	}

	public void setRcNo(String rcNo) {
		this.rcNo = rcNo;
	}

	public String getEngineNo() {
		return engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	public String getChassisNo() {
		return chassisNo;
	}

	public void setChassisNo(String chassisNo) {
		this.chassisNo = chassisNo;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public LocalDate getRenewDate() {
		return renewDate;
	}

	public void setRenewDate(LocalDate renewDate) {
		this.renewDate = renewDate;
	}
	
	@Override
	public String toString() {
		return "Vehicle [Id=" + id + ", vehicleType=" + vehicleType + ", vehicleModel=" + vehicleModel
				+ ", manufacturer=" + manufacturer + ", purchaseDate=" + purchaseDate + ", drivingLiscense="
				+ drivingLiscense + ", rcNo=" + rcNo + ", engineNo=" + engineNo + ", chassisNo=" + chassisNo
				+ ", engineType=" + engineType + ", renewDate=" + renewDate + ", customer=" + customer + "]";
	}

}

