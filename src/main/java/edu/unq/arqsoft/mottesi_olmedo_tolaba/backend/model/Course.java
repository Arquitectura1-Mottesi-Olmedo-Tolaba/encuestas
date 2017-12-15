package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;


import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.CourseDTO;

import java.util.List;

@Entity
@Table(name = "courses")
public class Course extends PersistenceEntity {

	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
    private Professor professor;
        
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) //cascade = CascadeType.MERGE, orphanRemoval = true
    private List<Timeline> timelines;
    
    private Integer quantity;

    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Course() {
    }

    public Course(String name, Professor professor, List<Timeline> timelines, Integer quantity) {
        this.name = name;
        this.professor = professor;
        this.timelines = timelines;
        this.quantity = quantity;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Timeline> getTimelines() {
        return timelines;
    }

    public void setTimelines(List<Timeline> timelines) {
        this.timelines = timelines;
    }

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
