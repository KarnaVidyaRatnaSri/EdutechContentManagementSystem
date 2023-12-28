package com.example.TechnicalBlog.repository;

import com.example.TechnicalBlog.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    
    // Add custom queries if needed
    
    Admin findByAdminNameAndAdminIdAndAdminPasswordAndAdminRole(String adminName , String adminId, String adminPassword, String adminRole);
}
