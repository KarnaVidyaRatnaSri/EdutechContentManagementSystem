package com.example.TechnicalBlog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String readerId;

    private String commentContent;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post; // Change the type to the actual entity type

    public Comment() {
    }

    public Comment(Long id, String commentContent, Post post,String readerId) {
        this.id = id;
        this.commentContent = commentContent;
        this.post = post;
        this.readerId=readerId;
    }

    public Long getId() {
        return id;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public Post getPost() {
        return post;
    }
      public String getReaderId() {
        return readerId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCommentContent(String string) {
        this.commentContent = string;
    }

    public void setPost(Post post) {
        this.post = post;
    }

   
    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    @Override
    public String toString() {
        return "Comment [id=" + id + ", readerId=" + readerId + ", commentContent=" + commentContent + ", post=" + post
                + "]";
    }
    

}
