package com.project.springboot.service;

import java.util.List;

import com.project.springboot.model.Admin;

public interface AdminService {

	List<Admin> getAllAdmins();
	void saveAdmin(Admin admin);
	Admin getAdminbyId(int id);
	void deleteAdminbyId(int id);
}
