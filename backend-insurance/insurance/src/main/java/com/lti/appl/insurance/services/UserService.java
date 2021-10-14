package com.lti.appl.insurance.services;

import java.util.List;

import com.lti.appl.insurance.beans.User;
import com.lti.appl.insurance.exceptions.CustomExceptions;

public interface UserService {
	
	void register(User user) throws Exception;
	public List<User> getUserList();
	public User searchUserbyId(int userId) throws CustomExceptions;
	public void updateUser(int userId, User user) throws CustomExceptions;
	
}
