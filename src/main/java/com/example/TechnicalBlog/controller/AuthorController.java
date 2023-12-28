package com.example.TechnicalBlog.controller;

import com.example.TechnicalBlog.model.Author;
import com.example.TechnicalBlog.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000" )
public class AuthorController {

    @Autowired
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/author/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }
    @PostMapping("/authorsinsert")
    public Author createAuthor(@RequestBody Author author) {
        return authorService.saveAuthor(author);
    }
    @DeleteMapping("/author/{id}")
    public String deleteAuthorById(@PathVariable Long id) {
        boolean deleted = authorService.deleteAuthorById(id);

        if (deleted) {
            return "Author with ID " + id + " deleted successfully.";
        } else {
            return "Author with ID " + id + " not found or unable to delete.";
        }
    }
    // Add additional methods for updating, deleting, etc.
}
