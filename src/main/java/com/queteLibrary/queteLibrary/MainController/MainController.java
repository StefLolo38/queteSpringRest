package com.queteLibrary.queteLibrary.MainController;


import com.queteLibrary.queteLibrary.entity.Book;
import com.queteLibrary.queteLibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;



@RestController
public class MainController {
    @Autowired
    BookRepository repository;
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @GetMapping("/books/{id}")
    public Book showBook(@PathVariable long id){
        return repository.findById((long) id).get();
    }

    @PostMapping("/books/search")
    public List<Book> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return repository.findByTitleContainingOrDescriptionContaining(searchTerm, searchTerm);
    }
    @PostMapping("/books")
    public Book create(@RequestBody Book book){
        return repository.save(book);
    }

    @PutMapping("/books/{id}")
    public Book update(@PathVariable long id, @RequestBody Book book){
        // getting blog
        Book bookToUpdate = repository.findById(id).get();
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setDescription(book.getDescription());
        return repository.save(bookToUpdate);
    }
    @DeleteMapping("books/{id}")
    public boolean delete(@PathVariable long id){
        repository.deleteById(id);
        return true;
    }

}

