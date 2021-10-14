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

import com.lti.appl.insurance.beans.Customer;
import com.lti.appl.insurance.beans.User;
import com.lti.appl.insurance.exceptions.CustomExceptions;
import com.lti.appl.insurance.services.UserServiceImpl;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;

	// http://localhost:8082/user/add
	@PostMapping("/add")
	public void insertNewEmployee(@RequestBody User user) {
		System.out.println(user);
		try {
			userService.register(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		}
	}
	
	// http://localhost:8082/user/all
	@GetMapping("/all")
	public List<User> allEmployeeList() {
		return userService.getUserList();
	}
	
	// http://localhost:8082/user/{userId}
	@GetMapping("/{userId}")
	public User searchCustomerbyId(@PathVariable ("userId") int userId) {
		try {
			return userService.searchUserbyId(userId);
		} catch (CustomExceptions e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		}
		return null;
	}
	
	// http://localhost:8082/user/{userId}/edit
	@PostMapping("/{userId}/edit")
	public void updateEmployeeById(@PathVariable("userId") int userId, @RequestBody User user) {
		try {
			userService.updateUser(userId, user);
		} catch (CustomExceptions e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
}
