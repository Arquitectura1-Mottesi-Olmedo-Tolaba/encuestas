package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.IndexColumn;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.StudentSurvey;

@Entity
@Table(name = "surveys")
public class Survey extends PersistenceEntity {

	private static final long serialVersionUID = 9159344780394535641L;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_survey")
	@IndexColumn(name = "length")
	private List<SurveyMatch> surveyMatches;

	private String code;

	private Boolean wasAnswered;

	private String message;

	@OneToOne
	private Student student;

	@OneToOne
	private AcademicOffer academicOffer;

	public Survey() {}

    public Survey(List<SurveyMatch> surveyMatches, String code, Boolean wasAnswered, String message, Student student, AcademicOffer academicOffer) {
        this();
        this.surveyMatches = surveyMatches;
        this.code = code;
        this.wasAnswered = wasAnswered;
        this.message = message;
        this.student = student;
        this.academicOffer = academicOffer;
    }

	public Survey(Student student, AcademicOffer academicOffer) {
	    this(new ArrayList<>(), generateSurveyCode(), false, "", student, academicOffer);
	}

    private static String generateSurveyCode() {
        return UUID.randomUUID().toString();
    }

    public List<SurveyMatch> getSurveyMatches() {
		return surveyMatches;
	}

	public void setSurveyMatches(List<SurveyMatch> surveyMatches) {
		this.surveyMatches = surveyMatches;
	}

	public void addSurveyMatch(SurveyMatch surveyMatch) {
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

	public Survey update(StudentSurvey studentSurvey) {
		this.updateSurveyMatches(studentSurvey.getSurveyMatches());
		this.setWasAnswered(true);
		this.setMessage(studentSurvey.getMessage());
		return this;
	}

	private void updateSurveyMatches(List<SurveyMatch> surveyMatches) {
		if(this.surveyMatches.isEmpty()){ 
			this.setSurveyMatches(surveyMatches);
			return;
		}
		this.surveyMatches.forEach(currentSurveyMatch -> {
			SurveyMatch updated = surveyMatches.stream()
					.filter(updateSurveyMatch -> 
						updateSurveyMatch.getSubject().getName().equals(currentSurveyMatch.getSubject().getName()))
					.findFirst()
					.orElseThrow(() -> new RuntimeException("No se encontro la materia"));
			currentSurveyMatch.getOption().setDescription(updated.getOption().getDescription());
		});
		
	}

}
