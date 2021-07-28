package com.project.springboot.serviceimplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springboot.model.User;
import com.project.springboot.repository.UserRepository;
import com.project.springboot.service.UserService;

@Service
public class UserServiceImp implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		this.userRepository.save(user);
	}
	@Override
	public User getUserbyId(int id) {
		// TODO Auto-generated method stub
		Optional<User> optional=userRepository.findById(id);
		User user=null;
		if(optional.isPresent()) {
			user=optional.get();
		}
		else {
			throw new RuntimeException("User Not Found for id:"+id);
		}
		return user;
	}
	
	
	@Override
	public void deleteUserbyID(int id) {
		// TODO Auto-generated method stub
		this.userRepository.deleteById(id);
	}
	
	
}
