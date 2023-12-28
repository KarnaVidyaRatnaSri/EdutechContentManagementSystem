package com.example.TechnicalBlog.repository;

import com.example.TechnicalBlog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);
    void deleteByPostId(Long postId);
    // Add more query methods as needed
}
