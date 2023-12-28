package com.example.TechnicalBlog.service;

import com.example.TechnicalBlog.model.Reader;
import com.example.TechnicalBlog.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReaderService {
    @Autowired
     private final ReaderRepository readerRepository;
     
    public ReaderService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    public Reader saveReader(Reader reader) {
        return readerRepository.save(reader);
    }

    public Reader getReaderById(Long id) {
        return readerRepository.findById(id).orElse(null);
    }

    public Reader login(String readerName , String readerId, String readerPassword) {
        return readerRepository.findByReaderNameAndReaderIdAndReaderPassword(readerName , readerId, readerPassword);
    }
     public boolean deleteReaderById(Long id) {
        Optional<Reader> optionalReader= readerRepository.findById(id);

        if (optionalReader.isPresent()) {
            readerRepository.deleteById(id);
            return true; // Deletion successful
        } else {
            return false; // Author with given ID not found
        }
    }
}
