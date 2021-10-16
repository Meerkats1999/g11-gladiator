package com.lti.appl.insurance.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
//import com.lti.appl.insurance.beans.Customer;
import com.lti.appl.insurance.beans.Vehicle;
import com.lti.appl.insurance.exceptions.CustomExceptions;

@Repository
public class VehicleDaoImpl implements VehicleDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public List<Vehicle> getVehicleList() {
		// TODO Auto-generated method stub
		System.out.println("inside dao");
		String sql = "Select v from Vehicle v";
		Query query = em.createQuery(sql);
		List<Vehicle> vehicleList = query.getResultList();
		em.close();
		return vehicleList;
	}

	@Override
	@Transactional
	public int addVehicle(Vehicle v) {
		// TODO Auto-generated method stub
		em.persist(v);
		return v.getId();
	}
	
	@Override
	public Vehicle searchVehicleById(int vehicleId) throws CustomExceptions {
		// TODO Auto-generated method stub
		String sql = "Select v from Vehicle v where v.id=:vehicleId";
		Query qry = em.createQuery(sql);
		qry.setParameter("vehicleId", vehicleId);

		Vehicle searchVehicle;
		try {
			searchVehicle = (Vehicle) qry.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new CustomExceptions("Record Not Found");
			
		}
		return searchVehicle;

	}
	
}
