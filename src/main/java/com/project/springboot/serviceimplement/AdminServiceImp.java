package com.project.springboot.serviceimplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springboot.model.Admin;
import com.project.springboot.repository.AdminRepository;
import com.project.springboot.service.AdminService;

@Service
public class AdminServiceImp implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public List<Admin> getAllAdmins() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}

	@Override
	public void saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		this.adminRepository.save(admin);
	}

	@Override
	public Admin getAdminbyId(int id) {
		// TODO Auto-generated method stub
		Optional<Admin> optional=adminRepository.findById(id);
		Admin admin=null;
		if(optional.isPresent()) {
			admin=optional.get();
		}
		else {
			throw new RuntimeException("Admin Not Available for id:"+id);
		}
		return admin;
	}

	@Override
	public void deleteAdminbyId(int id) {
		// TODO Auto-generated method stub
		this.adminRepository.deleteById(id);
	}

}
