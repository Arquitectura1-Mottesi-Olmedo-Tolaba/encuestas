package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "degrees")
public class Degree extends PersistenceEntity {

	private static final long serialVersionUID = 6591632026675920348L;

	private String name;
        
    @OneToMany(mappedBy="degree", cascade=CascadeType.ALL, 
    	fetch=FetchType.EAGER)
	@Fetch(FetchMode.JOIN)
	@LazyCollection(LazyCollectionOption.FALSE)    
    private List<Subject> subjects = new LinkedList<Subject>();
    
    @OneToMany(mappedBy="degree", cascade=CascadeType.ALL, 
        	fetch=FetchType.EAGER)
    	@Fetch(FetchMode.JOIN)
    	@LazyCollection(LazyCollectionOption.FALSE) 
    private List<AcademicOffer> academicOffers = new LinkedList<AcademicOffer>();

    public Degree(String name, List<Subject> subjects, List<AcademicOffer> academicOffers) {
        this.name = name;
        this.subjects = subjects;
        this.academicOffers = academicOffers;
    }

    public Degree() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<AcademicOffer> getAcademicOffers() {
        return academicOffers;
    }

    public void setAcademicOffers(List<AcademicOffer> academicOffers) {
        this.academicOffers = academicOffers;
    }
}
