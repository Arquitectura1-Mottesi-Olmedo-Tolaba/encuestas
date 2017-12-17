package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "students")
public class Student extends PersistenceEntity {

	private static final long serialVersionUID = 5345964965231083586L;

	private Integer studentID;
	private String name;
	private String lastName;
	private String email;

	@OneToMany()
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Subject> approvedSubjects;

	public List<Subject> getApprovedSubjects() {
		return approvedSubjects;
	}

	public void setApprovedSubjects(List<Subject> approvedSubjects) {
		this.approvedSubjects = approvedSubjects;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Student(String name, String lastName, Integer studentID, String email, List<Subject> approvedSubjects) {
		this.name = name;
		this.lastName = lastName;
		this.studentID = studentID;
		this.email = email;
		this.approvedSubjects = approvedSubjects;
	}

	public Student() {
		this.approvedSubjects = new LinkedList<Subject>();
	}

	public Integer getStudentID() {
		return studentID;
	}

	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void addAprovedSubject(Subject subject) {
		this.approvedSubjects.add(subject);
	}

}
