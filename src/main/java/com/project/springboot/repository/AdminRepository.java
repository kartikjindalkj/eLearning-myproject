package com.project.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springboot.model.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer>{

	
}
