package com.bookstore.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.project.model.BookEntity;
import com.bookstore.project.model.CartEntity;
import com.bookstore.project.service.BookService;
import com.bookstore.project.service.CartService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private BookService bookService;

	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public ModelAndView showHome() {
		ModelAndView model = new ModelAndView();
		final List<CartEntity> cartInf = cartService.getAllInfo();
		System.out.println("[CONT] All the books in the cart");
		model.setViewName("cart");
		model.addObject("cartInf", cartInf);
		return model;
	}
	
	
	@RequestMapping(value = "/addtocart/{id}", method = RequestMethod.POST)
	public ModelAndView addToCart(@PathVariable Integer id) {
		BookEntity book = bookService.getBookById(id);
		cartService.setInfo(book);
		System.out.println("[CONT] Book saved in the cart");
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:../home");
		return model;
	}
	
}
