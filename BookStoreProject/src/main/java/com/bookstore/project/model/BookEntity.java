package com.bookstore.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
public class BookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", columnDefinition = "INTEGER")
	private Integer id;
	
	@Column(name = "TITLE", columnDefinition = "VARCHAR", length = 50)
	private String title;
	
	@Column(name = "CATEGORY", columnDefinition = "VARCHAR", length = 20)
	private String category;
	
	@Column(name = "EDITION", columnDefinition = "INTEGER")
	private Integer edition;
	
	@Column(name = "AUTHOR", columnDefinition = "VARCHAR", length = 20)
	private String author;
	
	@Column(name = "PUBLISHER", columnDefinition = "VARCHAR", length = 20)
	private String publisher;
	
	@Column(name = "YEAR", columnDefinition = "INTEGER")
	private Integer year;
	
	@Column(name = "ISBN", columnDefinition = "INTEGER")
	private Integer isbn;
	
	@Column(name = "PRICE", columnDefinition = "INTEGER")
	private Integer price;

	
	public BookEntity() {
		super();
	}

	public BookEntity(Integer id, String title, String category, Integer edition, String author,
			String publisher, Integer year, Integer iSBN, Integer price) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.edition = edition;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
		this.isbn = iSBN;
		this.price = price;
	}

	
	/**
	 * Getters and Setters methods
	 */
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getEdition() {
		return edition;
	}

	public void setEdition(Integer edition) {
		this.edition = edition;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	
	/**
	 * HashCode method
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((edition == null) ? 0 : edition.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		BookEntity other = (BookEntity) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (edition == null) {
			if (other.edition != null)
				return false;
		} else if (!edition.equals(other.edition))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}


	/**
	 * To String method
	 */
	
	@Override
	public String toString() {
		return "BookEntity [id=" + id + ", title=" + title + ", category=" + category + ", edition=" + edition
				+ ", author=" + author + ", publisher=" + publisher + ", year=" + year + ", isbn=" + isbn + ", price="
				+ price + "]";	
	}

}
