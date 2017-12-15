package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.utils.StringValidator;

@Entity
@Table(name="users")
@JsonIgnoreProperties(ignoreUnknown=true)
public class UserCredential extends PersistenceEntity {

	private static final long serialVersionUID = -5002653969322746767L;

	private String email;
	private String password;

	
	public UserCredential() {
		super();
	}

    public UserCredential(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSameUser(UserCredential otherUser){
		return this.getEmail().equals(otherUser.getEmail());
	}
	
	public Boolean isWellFormed() {
		return StringValidator.isValidString(email) && StringValidator.isValidString(password);
	}

}
