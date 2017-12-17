package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto;

import java.io.Serializable;
import java.util.List;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Period;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Student;

public class StudentSurveyDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private Period period;
	private Student student;
	private List<StudentOfferDTO> offers;
	private String message;

	public StudentSurveyDTO() {
	}

	public StudentSurveyDTO(String name, Period period, Student student, List<StudentOfferDTO> offers, String message) {
		this.name = name;
		this.period = period;
		this.student = student;
		this.offers = offers;
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<StudentOfferDTO> getOffers() {
		return offers;
	}

	public void setOffers(List<StudentOfferDTO> offers) {
		this.offers = offers;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
