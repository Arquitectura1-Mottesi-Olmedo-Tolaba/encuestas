package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "directors")
public class Director extends PersistenceEntity {

	private static final long serialVersionUID = 6591632026675920348L;

	@OneToOne(cascade=CascadeType.ALL)
	private Degree degree;
        
    @OneToOne(cascade=CascadeType.ALL)
	private UserCredential user;

    public Director() {        
    }
    
	public Director(Degree degree, UserCredential user) {
		super();
		this.degree = degree;
		this.user = user;
	}



	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public UserCredential getUser() {
		return user;
	}

	public void setUser(UserCredential user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
