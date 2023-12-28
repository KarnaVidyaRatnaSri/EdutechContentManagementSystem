package com.example.TechnicalBlog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String authorName;
    private String authorId;
    private String authorPassword;
    private String authorBio;
    private String authorGender;
    public Author() {
    }
    public Author(Long id, String authorName, String authorId, String authorPassword, String authorBio , String authorGender) {
        this.id = id;
        this.authorName = authorName;
        this.authorId = authorId;
        this.authorPassword = authorPassword;
        this.authorBio = authorBio;
        this.authorGender =authorGender;
    }
    //Getters and Setters
    public Long getId() {
        return id;
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
    public String getAuthorBio() {
        return authorBio;
    }
    public String getAuthorGender() {
    return authorGender;
    }

    public void setId(Long id) {
        this.id = id;
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
    public void setAuthorBio(String authorBio) {
        this.authorBio = authorBio;
    }
    public void setAuthorGender(String authorGender) {
        this.authorGender = authorGender;
    }
    @Override
    public String toString() {
        return "Author [id=" + id + ", authorName=" + authorName + ", authorId=" + authorId + ", authorPassword="
                + authorPassword + ", authorBio=" + authorBio + ", authorGender=" + authorGender + "]";
    }
    //toString() method

}
    

    

