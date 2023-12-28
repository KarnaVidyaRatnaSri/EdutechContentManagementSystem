package com.example.TechnicalBlog.repository;

import com.example.TechnicalBlog.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByAuthorNameAndAuthorIdAndAuthorPassword(String authorName, String authorId, String authorPassword);
}
