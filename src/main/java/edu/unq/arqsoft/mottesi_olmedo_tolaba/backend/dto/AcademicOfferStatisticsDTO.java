package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto;

import java.util.List;

public class AcademicOfferStatisticsDTO {

	private List<StatisticDTO> offers;
	private String day;
	private String name;
	private StudentInformationDTO studentInformationDTO;

	public AcademicOfferStatisticsDTO(List<StatisticDTO> offers, String day, String name,
                                      StudentInformationDTO studentInformationDTO) {
		super();
		this.offers = offers;
		this.day = day;
		this.name = name;
		this.studentInformationDTO = studentInformationDTO;
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

	public StudentInformationDTO getStudentInformationDTO() {
		return studentInformationDTO;
	}

	public void setStudentInformationDTO(StudentInformationDTO studentInformationDTO) {
		this.studentInformationDTO = studentInformationDTO;
	}

}
