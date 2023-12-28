package com.example.TechnicalBlog.repository;

import com.example.TechnicalBlog.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
    
    // Add custom queries if needed
    
    Reader findByReaderNameAndReaderIdAndReaderPassword(String ReaderName , String readerId, String readerPassword);
}
