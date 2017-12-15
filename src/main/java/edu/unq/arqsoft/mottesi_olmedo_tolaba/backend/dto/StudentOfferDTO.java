package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto;

import java.util.List;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Course;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Option;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Subject;

public class StudentOfferDTO {

	private Subject subject;
	private List<Course> courses;
	private Option selectedOption;
	private List<Option> options;

	public StudentOfferDTO() {
	}

	public StudentOfferDTO(Subject subject, List<Course> courses, Option selectedOption, List<Option> options) {
		this.subject = subject;
		this.courses = courses;
		this.selectedOption = selectedOption;
		this.options = options;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Option getSelectedOption() {
		return selectedOption;
	}

	public void setSelectedOption(Option selectedOption) {
		this.selectedOption = selectedOption;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}
