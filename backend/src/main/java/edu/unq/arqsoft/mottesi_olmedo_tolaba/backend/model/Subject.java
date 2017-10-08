package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
@Table(name = "subjects")
public class Subject extends PersistenceEntity {

	private static final long serialVersionUID = -5546561326119736237L;

	private String name;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(cascade=CascadeType.MERGE)
	@JsonBackReference
	private Degree degree;
    
    public Subject(String name) {
        this.name = name;
    }
    
    public Subject(String name, Degree degree, Course course) {
        this.name = name;
        this.degree = degree;
        this.course = course;
    }

    public Subject() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

