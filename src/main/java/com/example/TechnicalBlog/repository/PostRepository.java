package com.example.TechnicalBlog.repository;

import com.example.TechnicalBlog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByAuthorId(String authorId);
    
}
