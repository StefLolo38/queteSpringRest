package com.queteLibrary.queteLibrary.repository;

import com.queteLibrary.queteLibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitleContainingOrDescriptionContaining(String searchTerm, String searchTerm1);
}
