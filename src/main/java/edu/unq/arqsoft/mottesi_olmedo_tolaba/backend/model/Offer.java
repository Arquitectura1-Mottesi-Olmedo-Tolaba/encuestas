package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "offers")
public class Offer extends PersistenceEntity {

	private static final long serialVersionUID = 2083933485862809486L;

	@OneToOne(cascade = CascadeType.ALL)
	private Subject subject;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_subject")
	@org.hibernate.annotations.IndexColumn(name = "length", base=3)
	private List<Course> courses;

	public Offer() {
	}

	public Offer(Subject subject, List<Course> courses) {
		this.subject = subject;
		this.courses = courses;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}
