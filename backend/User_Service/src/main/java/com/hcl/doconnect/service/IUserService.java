package com.hcl.doconnect.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.doconnect.entity.User;
import com.hcl.doconnect.to.UserTO;

@Service
public interface IUserService {

	String addUser(UserTO user);

	String updateUser(User user);

	List<User> findAllUsers();

	String deleteUser(int userId);

	User findUser(String username, String password);

	List<String> getAdminUsersMail();

	User findUserById(int id);

	List<User> findAllStudents();

}
