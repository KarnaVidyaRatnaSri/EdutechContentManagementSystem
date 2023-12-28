package com.example.TechnicalBlog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String adminName;
    private String adminId;
    private String adminPassword;
    private String adminRole;
    private String adminGender;
    public Admin() {
    }
    public Admin(Long id, String adminName, String adminId, String adminRole, String adminPassword , String adminGender) {
        this.id = id;
        this.adminName = adminName;
        this.adminId = adminId;
        this.adminRole = adminRole;
        this.adminPassword = adminPassword;
        this.adminGender =adminGender;
    }
     // getters and setters
    public Long getId() {
        return id;
    }
    public String getAdminName() {
        return adminName;
    }
    public String getAdminId() {
        return adminId;
    }
    public String getAdminRole() {
        return adminRole;
    }
    public String getAdminPassword() {
        return adminPassword;
    }
    public String getAdminGender() {
        return adminGender;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
    public void setAdminRole(String adminRole) {
        this.adminRole = adminRole;
    }
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
    @Override
    public String toString() {
        return "Admin [id=" + id + ", adminName=" + adminName + ", adminId=" + adminId + ", adminRole=" + adminRole
                + ", adminPassword=" + adminPassword + ", adminGender=" + adminGender + "]";
    }
    
    //toString() 
   
    
    
    
   
    
}
