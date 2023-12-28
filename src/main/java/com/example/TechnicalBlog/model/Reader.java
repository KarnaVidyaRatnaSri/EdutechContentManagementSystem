package com.example.TechnicalBlog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "readers")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String readerName;
    private String readerId;
    private String readerPassword;
    private String readerGender;
    //constructors
    public Reader() {
    }
    public Reader(Long id, String readerName, String readerId, String readerPassword ,String readerGender) {
        this.id = id;
        this.readerName = readerName;
        this.readerId = readerId;
        this.readerPassword = readerPassword;
        this.readerGender = readerGender;
    }
    //Getters and setters
    public Long getId() {
        return id;
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
    public String getReaderGender() {
        return readerGender;
    }

    public void setId(Long id) {
        this.id = id;
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
    public void setReaderGender(String readerGender) {
        this.readerGender = readerGender;
    }
    //toString() method
    @Override
    public String toString() {
        return "Reader [id=" + id + ", readerName=" + readerName + ", readerId=" + readerId + ", readerPassword="
                + readerPassword + ", readerGender=" + readerGender + "]";
    }
    

    
}
