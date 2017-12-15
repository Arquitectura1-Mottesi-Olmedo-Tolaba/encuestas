package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto;

import java.util.List;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Statistic;

public class AcademicOfferStatistics {

	private List<StatisticDTO> offers;
	private String day;
	private String name;
	private StudentInformation studentInformation;

	public AcademicOfferStatistics(List<StatisticDTO> offers, String day, String name,
			StudentInformation studentInformation) {
		super();
		this.offers = offers;
		this.day = day;
		this.name = name;
		this.studentInformation = studentInformation;
	}

	public List<StatisticDTO> getOffers() {
		return offers;
	}

	public void setOffers(List<StatisticDTO> offers) {
		this.offers = offers;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StudentInformation getStudentInformation() {
		return studentInformation;
	}

	public void setStudentInformation(StudentInformation studentInformation) {
		this.studentInformation = studentInformation;
	}

}
