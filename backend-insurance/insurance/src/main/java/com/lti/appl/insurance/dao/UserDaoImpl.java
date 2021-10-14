package com.lti.appl.insurance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.appl.insurance.beans.User;
import com.lti.appl.insurance.exceptions.CustomExceptions;

@Repository
public class UserDaoImpl implements UserDao{

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void register(User user) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("debug: user dao");
		User addUser = user;
		em.persist(addUser);
		
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		System.out.println("debug msg: inside user dao");
		String sql = "Select user from User user";
		Query qry = em.createQuery(sql);
		List<User> userList = qry.getResultList();

		return userList;
	}

	@Override
	public User searchUserbyId(int userId) throws CustomExceptions {
		// TODO Auto-generated method stub
		String sql = "Select user from User user where user.userId=:newuserId";
		Query qry = em.createQuery(sql);
		qry.setParameter("newuserId", userId);

		User searchUser;
		try {
			searchUser = (User) qry.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new CustomExceptions("Record Not Found");
			
		}
		return searchUser;
	}

	@Override
	@Transactional
	public void updateUser(int userId, User user) throws CustomExceptions {
		// TODO Auto-generated method stub
		String sql = "Update User user set user.emailId=:newEmailId, user.password=:newPassword, user.customer=:newCustomer where user.userId=:newUserId";
		Query qry = em.createQuery(sql);
		qry.setParameter("newUserId", userId);
		qry.setParameter("newEmailId", user.getEmailId());
		qry.setParameter("newPassword", user.getPassword());
		qry.setParameter("newCustomer", user.getCustomer());
		
		qry.executeUpdate();
	}
	
	
}
