package com.cts.admin.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.admin.entity.Admin;
import com.cts.admin.repository.AdminRepository;

@RestController
public class AdminController {

	@Autowired
	AdminRepository repository;

	@PostMapping("/admin/login")
	public boolean authentication(@RequestBody Admin admin) {
		boolean result = false;
		String email = admin.getEmail();
		String password = admin.getPassword();
		Long id = repository.getAdminId(email);
		String dbPassword = repository.getPassword(id);
		if (password.equalsIgnoreCase(dbPassword)) {
			result = true;
		}
		return result;
	}

	@PostMapping("/admin/add")
	public Admin addAdmin(@RequestBody Admin admin) {
		repository.save(admin);
		Admin result = repository.findByEmail(admin.getEmail());
		return result;
	}

	@GetMapping("/admin")
	public String admin() {
		return "Hi Admin";
	}
}
