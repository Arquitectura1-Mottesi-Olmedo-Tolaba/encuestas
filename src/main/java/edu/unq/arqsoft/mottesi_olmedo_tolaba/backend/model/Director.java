package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "directors")
public class Director extends PersistenceEntity {

	private static final long serialVersionUID = 6591632026675920348L;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Degree> degrees;
        
    @OneToOne(cascade=CascadeType.ALL)
	private UserCredential credential;

    public Director() {        
    }

	public Director(List<Degree> degrees, UserCredential credential) {
		super();
		this.degrees = degrees;
		this.credential = credential;
	}

	public List<Degree> getDegrees() {
		return degrees;
	}

	public void setDegrees(List<Degree> degrees) {
		this.degrees = degrees;
	}

	public UserCredential getCredential() {
		return credential;
	}

	public void setCredential(UserCredential credential) {
		this.credential = credential;
	}
    
    
    
    
}
