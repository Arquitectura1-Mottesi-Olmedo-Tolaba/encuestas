package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "courses")
public class Course extends PersistenceEntity {

	private static final long serialVersionUID = 5337220231552141046L;

	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	private Professor professor;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_course")
	@IndexColumn(name = "length")
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
