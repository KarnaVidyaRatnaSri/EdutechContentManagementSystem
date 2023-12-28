package com.example.TechnicalBlog.service;

import com.example.TechnicalBlog.model.Author;
import com.example.TechnicalBlog.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private final AuthorRepository authorRepository;
    
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public Author login(String authorName , String authorId, String authorPassword  ) {
        return authorRepository.findByAuthorNameAndAuthorIdAndAuthorPassword(authorName,authorId, authorPassword);
    }
    public boolean deleteAuthorById(Long id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);

        if (optionalAuthor.isPresent()) {
            authorRepository.deleteById(id);
            return true; // Deletion successful
        } else {
            return false; // Author with given ID not found
        }
    }
}
