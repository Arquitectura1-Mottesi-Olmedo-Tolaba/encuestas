package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto;

import java.io.Serializable;
import java.util.List;

public class AcademicOfferDTO implements Serializable{
	
	private Long id;
    private String name;
    private PeriodDTO period;
    private StudentDTO student;
    private List<OfferDTO> offers;

    public AcademicOfferDTO(){}
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PeriodDTO getPeriod() {
		return period;
	}

	public void setPeriod(PeriodDTO period) {
		this.period = period;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

	public List<OfferDTO> getOffers() {
		return offers;
	}

	public void setOffers(List<OfferDTO> offers) {
		this.offers = offers;
	}
}
