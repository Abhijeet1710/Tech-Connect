package com.hcl.doconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.doconnect.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

	User findByUsernameAndPassword(String username, String password);

	List<User> findAllByRole(String role);

	User findByUsername(String username);
	
	User findById(int id);

}
