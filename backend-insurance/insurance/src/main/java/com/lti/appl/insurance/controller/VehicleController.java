package com.lti.appl.insurance.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lti.appl.insurance.beans.Vehicle;
import com.lti.appl.insurance.exceptions.CustomExceptions;
import com.lti.appl.insurance.services.VehicleServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("vehicle")
public class VehicleController {

	@Autowired
	VehicleServiceImpl vehicleService;

	// http://localhost:8020/vehicle/details
	@GetMapping("/details")
	public List<Vehicle> getVehicleList() {
		return vehicleService.getVehicleList();
	}

	// http://localhost:8020/vehicle/addVehicle
	@PostMapping("/addVehicle")
	public void addVehicle(@RequestBody Vehicle v) {
		vehicleService.addVehicle(v);
	}
	
	// http://localhost:8020/vehicle/{vehicleId}
	@GetMapping("/{vehicleId}")
	public Vehicle searchVehicleById(@PathVariable("vehicleId") int vehicleid) throws CustomExceptions {
		return vehicleService.searchVehicleById(vehicleid);
	}
	
}
