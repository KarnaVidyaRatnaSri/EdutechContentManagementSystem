package com.example.TechnicalBlog.model;

import jakarta.persistence.*;

import java.util.Date;



@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name = "author_id") // Use a simple column to store authorId
    private String authorId;

    private Date createdAt;

    public Post() {
    }

    // Modify the constructor to take String for authorId
    public Post(Long id, String title, String content, String authorId, Date createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthorId() {
        return authorId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Keep method name and parameter type as String
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Post [id=" + id + ", title=" + title + ", content=" + content + ", authorId=" + authorId + ", createdAt="
                + createdAt + "]";
    }
}
