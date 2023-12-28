package com.example.TechnicalBlog.controller;

import com.example.TechnicalBlog.model.LoginRequest;
import com.example.TechnicalBlog.model.Admin;
import com.example.TechnicalBlog.model.Author;
import com.example.TechnicalBlog.model.Reader;
import com.example.TechnicalBlog.service.AdminService;
import com.example.TechnicalBlog.service.AuthorService;
import com.example.TechnicalBlog.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:3000" )
public class LoginController {
  
     @Autowired
    private final AdminService adminService;
    private final AuthorService authorService;
    private final ReaderService readerService;

   
    public LoginController(AdminService adminService, AuthorService authorService, ReaderService readerService) {
        this.adminService = adminService;
        this.authorService = authorService;
        this.readerService = readerService;
    }

    @PostMapping("/admin")
    public ResponseEntity<String> adminLogin(@RequestBody LoginRequest loginRequest) {
        String adminName = loginRequest.getAdminName();
        String adminId = loginRequest.getAdminId();
        String adminPassword = loginRequest.getAdminPassword();
        String adminRole = loginRequest.getAdminRole();

        Admin loggedInAdmin = adminService.login(adminName, adminId, adminPassword, adminRole);

        if (loggedInAdmin != null) {
            return ResponseEntity.ok("Admin login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid admin credentials");
        }
    }

    @PostMapping("/author")
    public ResponseEntity<String> authorLogin(@RequestBody LoginRequest loginRequest) {
        String authorName = loginRequest.getAuthorName();
        String authorId = loginRequest.getAuthorId();
        String authorPassword = loginRequest.getAuthorPassword();


        Author loggedInAuthor = authorService.login(authorName, authorId, authorPassword);

        if (loggedInAuthor != null) {
            return ResponseEntity.ok("Author login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid author credentials");
        }
    }

    @PostMapping("/reader")
    public ResponseEntity<String> readerLogin(@RequestBody LoginRequest loginRequest) {
        String readerName = loginRequest.getReaderName();
        String readerId = loginRequest.getReaderId();
        String readerPassword = loginRequest.getReaderPassword();

        Reader loggedInReader = readerService.login(readerName, readerId, readerPassword);

        if (loggedInReader != null) {
            return ResponseEntity.ok("Reader login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid reader credentials");
        }
    }
}
