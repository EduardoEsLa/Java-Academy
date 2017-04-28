package com.bookstore.project.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.project.model.CartEntity;

/**
 * Repository for CartLineEntity
 * @author eduardo.espinoza
 */
@Repository
@Transactional
public class CartRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	/**
	 * Method to insert a book into the cart
	 * @author eduardo.espinoza
	 * @param cartEntity
	 */
	public void insertBookCart(final CartEntity cartEntity){
		entityManager.persist(cartEntity);
		entityManager.flush();
		System.out.println("[REPO] Saved book into the cart");
	}
	
	
	/**
	 * Method to get all the info from the cart
	 * @author eduardo.espinoza
	 * @return List of CartEntity
	 */
	public List<CartEntity> getCartInfo(){
		final List<CartEntity> cartInfo = entityManager.createQuery("SELECT cart FROM CartEntity cart", CartEntity.class)
				.getResultList();
		return cartInfo;
				
	}
}