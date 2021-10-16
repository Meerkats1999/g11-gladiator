package com.lti.appl.insurance.dao;

import java.util.List;
import com.lti.appl.insurance.beans.Vehicle;
import com.lti.appl.insurance.exceptions.CustomExceptions;

public interface VehicleDao {
	
	public abstract List<Vehicle> getVehicleList();
	public abstract int addVehicle(Vehicle v);
	public abstract Vehicle searchVehicleById(int vehicleId) throws CustomExceptions;

}