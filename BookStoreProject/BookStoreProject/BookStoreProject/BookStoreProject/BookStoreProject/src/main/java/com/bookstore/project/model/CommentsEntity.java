package com.bookstore.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMMENTS")
public class CommentsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", columnDefinition = "INTEGER")
	private Integer id;
	
	@Column(name = "WORDS", columnDefinition = "VARCHAR", length = 200)
	private String words;

	
	public CommentsEntity() {
		super();
	}

	public CommentsEntity(Integer id, String words) {
		super();
		this.id = id;
		this.words = words;
	}

	
	/**
	 * Getters and Setters method
	 */
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

	
	/**
	 * HashCode method
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((words == null) ? 0 : words.hashCode());
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
		CommentsEntity other = (CommentsEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (words == null) {
			if (other.words != null)
				return false;
		} else if (!words.equals(other.words))
			return false;
		return true;
	}

	
	/**
	 * To String method
	 */
	
	@Override
	public String toString() {
		return "Comments [id=" + id + ", words=" + words + "]";
	} 
	
}
