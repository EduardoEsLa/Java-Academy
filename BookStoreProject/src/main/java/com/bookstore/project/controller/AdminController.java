package com.bookstore.project.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.project.model.BookEntity;
import com.bookstore.project.service.BookService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {

	@Autowired 
	private BookService bookService;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView showHome() {
		ModelAndView model = new ModelAndView();
		System.out.println("[CONT] Showing all books");
		final List<BookEntity> books = bookService.getAllBooks(); 
		BookEntity book = new BookEntity();
		model.setViewName("admin");	
		model.addObject("book", book);
		model.addObject("books", books);
		return model;
	}
	
	
	@RequestMapping(value = "/addbook", method = RequestMethod.POST)
	public ModelAndView createBook(@ModelAttribute("book") BookEntity book) {
		bookService.registerNewBook(book);
		System.out.println("[CONT] Book created");
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:admin");
		return model;
	}
	
	
	@RequestMapping(value = "/removebook/{id}", method = RequestMethod.POST)
	public ModelAndView removeBook(@PathVariable Integer id) {
		bookService.removeBook(id);
		System.out.println("[CONT] Book removed");
		ModelAndView model = new ModelAndView(); 
		model.setViewName("redirect:../admin");
		return model;
	}
	
	
	@RequestMapping(value = "/updatebook/{id}", method = RequestMethod.POST)
	public ModelAndView updateBook(@ModelAttribute("book") BookEntity book, @PathVariable Integer id) {
		book.setId(id);
		bookService.updatingBook(book);
		System.out.println("[CONT] Book updated");
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:../admin");
		return model;
	}
	
	
	@RequestMapping(value = "/book/{id}", method = RequestMethod.POST)
	public @ResponseBody BookEntity getBook(@PathVariable Integer id) {
		final BookEntity book = bookService.getBookById(id);
		System.out.println("[CONT] Found book by Id");
		return book;
	}
}