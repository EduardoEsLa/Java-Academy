package com.bookstore.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "CART")
public class CartEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CART_ID", columnDefinition = "INTEGER")
	private Integer cart_id;

	@Column(name = "PRICE", columnDefinition = "INTEGER")
	private Integer price;
	
	@OneToOne(optional = false)
	private BookEntity book_id;
	
	@Column(name = "USERNAME", columnDefinition = "VARCHAR", length = 20)
	private String username;
	
	
	public CartEntity() {
		super();
	}

	public CartEntity(Integer cart_id, Integer price, BookEntity book_id, String username) {
		super();
		this.cart_id = cart_id;
		this.price = price;
		this.book_id = book_id;
		this.username = username;
	}


	/**
	 * Getters and Setters method
	 */
	
	public Integer getCart_id() {
		return cart_id;
	}


	public void setCart_id(Integer cart_id) {
		this.cart_id = cart_id;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public BookEntity getBook_id() {
		return book_id;
	}


	public void setBook_id(BookEntity book_id) {
		this.book_id = book_id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	/**
	 * HashCode method
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book_id == null) ? 0 : book_id.hashCode());
		result = prime * result + ((cart_id == null) ? 0 : cart_id.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}


	/**
	 * Equals method
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartEntity other = (CartEntity) obj;
		if (book_id == null) {
			if (other.book_id != null)
				return false;
		} else if (!book_id.equals(other.book_id))
			return false;
		if (cart_id == null) {
			if (other.cart_id != null)
				return false;
		} else if (!cart_id.equals(other.cart_id))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}


	/**
	 * To String method
	 */
	
	@Override
	public String toString() {
		return "CartEntity [cart_id=" + cart_id + ", price=" + price + ", book_id=" + book_id + ", username=" + username
				+ "]";
	}

}
