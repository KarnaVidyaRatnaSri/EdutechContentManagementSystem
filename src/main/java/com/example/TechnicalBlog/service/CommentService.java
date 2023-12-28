package com.example.TechnicalBlog.service;

import com.example.TechnicalBlog.model.Comment;
import com.example.TechnicalBlog.repository.CommentRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment getCommentById(Long commentId) {
        Optional<Comment> optionalComment = commentRepository.findById(commentId);
        return optionalComment.orElse(null);
    }

    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }
    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }
    
    @Transactional  // Add this annotation
    public void deleteCommentsByPostId(Long postId) {
        commentRepository.deleteByPostId(postId);
    }
    
    // public Comment updateComment(Comment comment) {
    //     return commentRepository.save(comment);
    // }
}