package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.SurveyDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.SurveyMatchDTO;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "surveys")
public class Survey extends PersistenceEntity {

	private static final long serialVersionUID = 9159344780394535641L;
	
	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<SurveyMatch> surveyMatches = new LinkedList<SurveyMatch>();
	
	private String code;
	
	private Boolean wasAnswered;
	
	private String message;
	
	@OneToOne
	private Student student;
	
	@OneToOne
	private AcademicOffer academicOffer;
	

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public AcademicOffer getAcademicOffer() {
		return academicOffer;
	}

	public void setAcademicOffer(AcademicOffer academicOffer) {
		this.academicOffer = academicOffer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Survey() {
    }
	
	public Survey(Student student, AcademicOffer academicOffer) {
		this.student = student;
		this.academicOffer = academicOffer;
		this.code = UUID.randomUUID().toString();
		this.wasAnswered = false;
		this.surveyMatches = new ArrayList<>();
	}

	public SurveyDTO toSurveyDTO() {
		SurveyDTO dto = new SurveyDTO();
		List<SurveyMatchDTO> surveyMatchesDTO = new LinkedList<SurveyMatchDTO>();
		for (SurveyMatch surveyMatch : surveyMatches){
			surveyMatchesDTO.add(surveyMatch.toSurveyMatchDTO());
		}
		dto.surveyMatches = surveyMatchesDTO;
		return dto;
    } 
	

	public List<SurveyMatch> getSurveyMatches() {
		return surveyMatches;
	}

	public void setSurveyMatches(List<SurveyMatch> surveyMatches) {
		this.surveyMatches = surveyMatches;
	}
	
	public void addSurveyMatch(SurveyMatch surveyMatch){
		this.surveyMatches.add(surveyMatch);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getWasAnswered() {
		return wasAnswered;
	}

	public void setWasAnswered(Boolean wasAnswered) {
		this.wasAnswered = wasAnswered;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
