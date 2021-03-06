package com.mandeep.update.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mandeep.update.models.Book;
import com.mandeep.update.services.BookService;

@Controller
public class bookcontroller {
	private BookService service;
	public bookcontroller(BookService service) {
		this.service = service;
    }
	
	 @RequestMapping("/books")
	 public String index(Model model) {
		List<Book> books = service.allBooks();
	    model.addAttribute("books", books);
	        return "index.jsp";
	    }
	 @RequestMapping("/books/new")
	    public String newBook(@ModelAttribute("book") Book book) {
	        return "new.jsp";
	    }

	    @RequestMapping(value="/books", method=RequestMethod.POST)
	    public String create(@Validated @ModelAttribute("book") Book book, BindingResult result) {
	        if (result.hasErrors()) {
	            return "new.jsp";
	        } else {
	           service.createBook(book);
	            return "redirect:/books";
	        }
	    }

	    @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
	    public String destroy(@PathVariable("id") Long id) {
	        service.deleteById(id);
	        return "redirect:/books";
	    }
	    

	    @PutMapping("/books/edit/{id}")
	    public String editBook(@PathVariable("id") Long id, Model model) {
	        Book book = service.getOne(id);
	        if (book != null){
	            model.addAttribute("book", book);
	            return "editbook.jsp";
	        }
	        else{
	            return "redirect:/books";
	        }
	    }

	    @PostMapping("/books/edit/{id}")
	    public String updateBook(@PathVariable("id") Long id, @Validated @ModelAttribute("book") Book book, BindingResult result) {
	        if (result.hasErrors()) {
	            return "editbook.jsp";
	        }
	        this.service.createBook(book);
	            return "redirect:/books";
	    }

}
