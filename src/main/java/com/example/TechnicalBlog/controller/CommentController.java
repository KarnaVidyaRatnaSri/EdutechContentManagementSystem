package com.example.TechnicalBlog.controller;

import com.example.TechnicalBlog.model.Comment;
import com.example.TechnicalBlog.model.Post;
import com.example.TechnicalBlog.service.CommentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/comments")
@CrossOrigin(origins = "http://localhost:3000")
public class CommentController {

    @Autowired
    private CommentService commentService;

  
    @GetMapping("/{commentId}")
    public Comment getCommentById(@PathVariable Long commentId) {
        return commentService.getCommentById(commentId);
    }

   @GetMapping("/post/{postId}")
    public List<Comment> getCommentsByPostId(@PathVariable Long postId) {
    return commentService.getCommentsByPostId(postId);
}
    
   // Add a comment to a specific post
    @PostMapping("/post")
       public ResponseEntity<Comment> addComment(@RequestBody Comment requestComment) {

    try {
        Comment newComment = new Comment();
        newComment.setCommentContent(requestComment.getCommentContent());
        newComment.setReaderId(requestComment.getReaderId());

        // Assuming 'Post' is embedded in 'Comment' class
        Post post = new Post();
        post.setId(requestComment.getPost().getId());
        newComment.setPost(post);

        Comment addedComment = commentService.addComment(newComment);

        // Return the added comment with a 201 Created status
        return new ResponseEntity<>(addedComment, HttpStatus.CREATED);
    } catch (Exception e) {
       
        e.printStackTrace();
        // Return an error response with a 500 Internal Server Error status
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
// Delete comments associated with a specific post
@DeleteMapping("/del/{postId}")
public ResponseEntity<String> deleteCommentsByPostId(@PathVariable Long postId) {
    try {
        commentService.deleteCommentsByPostId(postId);
        return new ResponseEntity<>("Comments deleted successfully", HttpStatus.NO_CONTENT);
    } catch (Exception e) {
        e.printStackTrace(); // Log the exception or handle it appropriately
        return new ResponseEntity<>("Failed to delete comments", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

 // @PutMapping("/update/{commentId}")
    // public Comment updateComment(@PathVariable Long commentId, @RequestBody Comment updatedComment) {
    //     Comment existingComment = commentService.getCommentById(commentId);

    //     if (existingComment != null) {
    //         existingComment.setCommentContent(updatedComment.getCommentContent());
    //         // Assuming 'Post' is embedded in 'Comment' class
    //         existingComment.getPost().setId(updatedComment.getPost().getId());

    //         return commentService.updateComment(existingComment);
    //     } else {
    //         // Handle the case where the comment with the given ID is not found
    //         return null; // You might want to return an appropriate response
    //     }
    // } 

}
