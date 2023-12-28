package com.example.TechnicalBlog.service;

import com.example.TechnicalBlog.model.Admin;
import com.example.TechnicalBlog.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private final AdminRepository adminRepository;
    
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    public Admin login(String adminName , String adminId, String adminPassword, String adminRole ) {
        return adminRepository.findByAdminNameAndAdminIdAndAdminPasswordAndAdminRole(adminName , adminId, adminPassword, adminRole);
    }
    
}

