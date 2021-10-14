package com.lti.appl.insurance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.appl.insurance.beans.User;
import com.lti.appl.insurance.dao.UserDao;
import com.lti.appl.insurance.exceptions.CustomExceptions;

@Service(".userService")
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao dao;
	
	@Override
	public void register(User user) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("debug: user service");
		dao.register(user);
		
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return dao.getUserList();
	}

	@Override
	public User searchUserbyId(int userId) throws CustomExceptions {
		// TODO Auto-generated method stub
		return dao.searchUserbyId(userId);
	}

	@Override
	public void updateUser(int userId, User user) throws CustomExceptions {
		// TODO Auto-generated method stub
		dao.updateUser(userId, user);
		
	}	

}
