package com.adminService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminService.Entity.AdminEntity;
import com.adminService.Repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminReository;
	
	public List<AdminEntity> findAdmin() {
		return adminReository.findAll();
	}

//	public AdminEntity login() {
//		return null;
//	}

}
