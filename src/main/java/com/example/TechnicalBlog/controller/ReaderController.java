package com.example.TechnicalBlog.controller;

import com.example.TechnicalBlog.model.Reader;
import com.example.TechnicalBlog.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000" )
public class ReaderController {

    
    @Autowired
    private final ReaderService readerService;

    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @GetMapping("/readers")
    public List<Reader> getAllReaders() {
        return readerService.getAllReaders();
    }

    @GetMapping("/reader/{id}")
    public Reader getReaderById(@PathVariable Long id) {
        return readerService.getReaderById(id);
    }

    @PostMapping("/readersinsert")
    public Reader createReader(@RequestBody Reader reader) {
        return readerService.saveReader(reader);
    }
    @DeleteMapping("/reader/{id}")
    public String deleteReaderById(@PathVariable Long id) {
        boolean deleted = readerService.deleteReaderById(id);

        if (deleted) {
            return "Author with ID " + id + " deleted successfully.";
        } else {
            return "Author with ID " + id + " not found or unable to delete.";
        }
    }
    // Add additional methods for updating, deleting, etc.
}
