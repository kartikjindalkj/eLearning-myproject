package com.project.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springboot.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	

}