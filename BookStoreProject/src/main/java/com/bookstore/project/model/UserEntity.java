package com.bookstore.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class UserEntity {

	@Id	
	@Column(name = "USERNAME", columnDefinition = "VARCHAR", length = 20)
	private String username;

	@Column(name = "PASSWORD", columnDefinition = "VARCHAR", length = 20)
	private String password;

	@Column(name = "ENABLED", columnDefinition = "BOOLEAN")
	private boolean enabled;

	
	public UserEntity() {
		super();
	}

	public UserEntity(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	
	/**
	 * Getter and Setters methods
	 */
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	/**
	 * HashCode method
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		UserEntity other = (UserEntity) obj;

		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
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
		return "UserEntity [username=" + username + ", password=" + password + "]";
	}

}
