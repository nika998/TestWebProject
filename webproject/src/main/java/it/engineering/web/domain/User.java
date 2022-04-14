package it.engineering.web.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;



/**
 * The persistent class for the user database table.
 * 
 */
@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private String firstname;

	private String lastname;

	private String password;

	@Id
	private String username;

	public User() {
	}
	
	

	public User(String firstname, String lastname, String password, String username) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.username = username;
	}



	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public User clone() {
		return new User(firstname, lastname, null, username);
	}



	@Override
	public int hashCode() {
		return Objects.hash(password, username);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
	
	
	

}