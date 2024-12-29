package com.hcl.doconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.doconnect.to.UserTO;
import com.hcl.doconnect.entity.User;
import com.hcl.doconnect.service.IUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000/")
public class UserController {
	
	@Autowired
	IUserService iUserService;
	
	@PostMapping("/add")
	public String AddUser(@RequestBody UserTO user)
	{
		
		String addStatus = iUserService.addUser(user);
		
		return addStatus;
		
	}
	
	@PutMapping("/update")
	public String updateUser(@RequestBody User user)
	{
		
		String updateStatus = iUserService.updateUser(user);
		
		return updateStatus;
	}
	
	@DeleteMapping("/delete/{userId}")
	public String deleteUser(@PathVariable int userId)
	{
		String deleteStatus = iUserService.deleteUser(userId);
		
		return deleteStatus;
	}

	@GetMapping("/getAllUsers")
	public List<User> getAllUsers()
	{
		List<User> users = iUserService.findAllUsers();
		
		return users;
	}
	
	@GetMapping("/findUser/{username}/{password}")
	public User findUser(@PathVariable String username, @PathVariable String password)
	{
		User user = iUserService.findUser(username, password);
		
		return user;				
		
	}
	
	@GetMapping("/findById/{id}")
	public User findUserById(@PathVariable int id)
	{
		User user = iUserService.findUserById(id);
		
		return user;
	}
	
	@GetMapping("/findAllStudents")
	public List<User> findAllStudents()
	{
		List<User> users = iUserService.findAllStudents();
		
		return users;
	}
}
