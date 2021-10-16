package com.lti.appl.insurance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lti.appl.insurance.beans.Vehicle;
import com.lti.appl.insurance.dao.VehicleDao;
import com.lti.appl.insurance.exceptions.CustomExceptions;

@Service("vehicleService")
public class VehicleServiceImpl implements VehicleService{

		@Autowired
		VehicleDao dao;
		
		public VehicleDao getDao() {
			return dao;
		}

		public void setDao(VehicleDao dao) {
			this.dao = dao;
		}

		@Override
		public List<Vehicle> getVehicleList() {
			// TODO Auto-generated method stub
			List<Vehicle> vehicleList = dao.getVehicleList();
			return vehicleList;
		}

		@Override
		public int addVehicle(Vehicle v) {
			// TODO Auto-generated method stub
			return dao.addVehicle(v);
		}
		
		@Override
		public Vehicle searchVehicleById(int vehicleId) throws CustomExceptions {
			// TODO Auto-generated method stub
			return dao.searchVehicleById(vehicleId);
		}

}
