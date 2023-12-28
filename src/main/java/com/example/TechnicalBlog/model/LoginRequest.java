package com.example.TechnicalBlog.model;

public class LoginRequest {
    private String adminName;
    private String adminId;
    private String adminPassword;
    private String adminRole;
    private String authorName;
    private String authorId;
    private String authorPassword;
    private String readerName;
    private String readerId;
    private String readerPassword;
   
     public LoginRequest() {
    }
    // getters and setters

    public String getAdminName() {
        return adminName;
    }

    public String getAdminId() {
        return adminId;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public String getAdminRole() {
        return adminRole;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getAuthorPassword() {
        return authorPassword;
    }


    public String getReaderName() {
        return readerName;
    }

    public String getReaderId() {
        return readerId;
    }

    public String getReaderPassword() {
        return readerPassword;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public void setAdminRole(String adminRole) {
        this.adminRole = adminRole;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public void setAuthorPassword(String authorPassword) {
        this.authorPassword = authorPassword;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public void setReaderPassword(String readerPassword) {
        this.readerPassword = readerPassword;
    }
   

    
}

