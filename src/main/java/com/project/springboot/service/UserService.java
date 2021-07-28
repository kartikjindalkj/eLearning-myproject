package com.project.springboot.service;

import java.util.List;

import com.project.springboot.model.User;

public interface UserService {
	List<User> getAllUsers();
	void saveUser(User user);
	User getUserbyId(int id);
	void deleteUserbyID(int id);
}
