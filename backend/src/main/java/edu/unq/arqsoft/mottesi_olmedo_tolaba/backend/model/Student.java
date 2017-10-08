package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student extends PersistenceEntity {

	private static final long serialVersionUID = 5345964965231083586L;
	
	private Integer studentID;
    private String name;
    private String lastName;
    private String email;

    public Student(String name, String lastName, Integer studentID, String email) {
        this.name = name;
        this.lastName = lastName;
        this.studentID = studentID;
        this.email = email;
    }

    public Student() {
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
}
