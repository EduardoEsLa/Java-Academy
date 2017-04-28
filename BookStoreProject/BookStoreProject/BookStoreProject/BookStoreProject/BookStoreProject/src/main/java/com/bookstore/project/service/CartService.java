package com.bookstore.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.bookstore.project.model.BookEntity;
import com.bookstore.project.model.CartEntity;
import com.bookstore.project.repository.CartRepository;


/**
 * Service class for the CartRepository
 * @author eduardo.espinoza
 */
@Service
public class CartService {

	
	@Autowired
	private CartRepository cartRepository;
	
	
	/**
	 * Method to set info into CartEntity
	 * @author eduardo.espinoza
	 * @param cartEntity
	 */
	public void setInfo(final BookEntity bookEntity){
		final CartEntity cartEntity = new CartEntity();
  		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		cartEntity.setUsername(user);
		cartEntity.setBook_id(bookEntity);
		cartRepository.insertBookCart(cartEntity);
		System.out.println("[SERV] Book saved in the cart successfully");
	}
	
		
	/**
	 * Method to get all cart info
	 * @author eduardo.espinoza
	 * @return list of books
	 */
	public List<CartEntity> getAllInfo(){
		List<CartEntity> cartList = cartRepository.getCartInfo();
		return cartList;
	}
	
}
