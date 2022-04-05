package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AdminRepository;
import com.app.pojos.Admin;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService{
	@Autowired
	private AdminRepository adminRepo;
	
	
	@Override
	public String signUpAdmin(Admin adm) {
		adminRepo.save(adm);
		return "Admin Signup successfully";
	}
	@Override
	public Admin authenticateAdmin(String email, String password) {
		
		return adminRepo.findByAdminEmailAndAdminPassword(email, password)
		.orElseThrow(() -> new RuntimeException("Invalid Credentials!!!!!"));

	}

}
