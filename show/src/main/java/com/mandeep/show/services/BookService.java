package com.mandeep.show.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mandeep.show.models.Book;
import com.mandeep.show.repositories.BookRepository;

@Service
public class BookService {
	
	 private final BookRepository bookRepository;
	    
	    public BookService(BookRepository bookRepository) {
	        this.bookRepository = bookRepository;
	    }
	    // returns all the books
	    public List<Book> allBooks() {
	        return this.bookRepository.findAll();
	    }
	    // creates a book
	    public Book createBook(Book b) {
	        return this.bookRepository.save(b);
	    }
	    // delete a book
	    public void deleteById(Long id) {
	    	this.bookRepository.deleteById(id);
	    }
	    
	    //update a book
	    public Book update(Book b) {
	    	return this.bookRepository.save(b);
	    }
	    
	    // get one book
	    public Book getOne(Long id) {
	    	return this.bookRepository.findById(id).orElse(null);
	    }
		
		}
		
	    


