package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users_profiles")
public class UserProfile extends PersistenceEntity {

	private static final long serialVersionUID = -5227774846544481307L;

	// Instance Variables
	@ManyToOne(cascade=CascadeType.MERGE)
	private UserCredential user;

	@OneToOne(cascade=CascadeType.ALL)
	private UserData userData;


	// Constructors
	public UserProfile() {
	}
	
	public UserProfile(UserCredential userCredential, UserData userData) {
		this.user = userCredential;
		this.setUserData(userData);
	}

	// Getters and Setters
	public UserCredential getUser() {
		return user;
	}
	
	public void setUser(UserCredential user) {
		this.user = user;
	}


	public UserData getUserData() {
		return userData;
	}

	public void setUserData(UserData userData) {
		this.userData = userData;
	}

}
