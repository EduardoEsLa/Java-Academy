package com.bookstore.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.project.model.BookEntity;
import com.bookstore.project.model.CommentsEntity;
import com.bookstore.project.service.BookService;
import com.bookstore.project.service.CommentsService;

@Controller
public class HomeController {

	@Autowired 
	private BookService bookService;
	
	@Autowired
	private CommentsService commentsService;

	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public ModelAndView showHome() {
		System.out.println("[CONT] Showing all books");
		final List<BookEntity> books =  bookService.getAllBooks();
		ModelAndView model = new ModelAndView();
		model.setViewName("home");
		model.addObject("books", books);
		return model;
	}

	@RequestMapping(value = "/comments", method = RequestMethod.GET)
	public ModelAndView showComments() {
		System.out.println("[CONT] Showing all comments");
		final List<CommentsEntity> comments = commentsService.viewComment();  
		ModelAndView model = new ModelAndView();
		model.setViewName("comments");
		model.addObject("comments", comments);
		return model;
	}
	
}
