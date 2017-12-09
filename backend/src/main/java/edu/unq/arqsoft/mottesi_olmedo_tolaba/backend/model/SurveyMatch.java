package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.SurveyMatchDTO;

@Entity
@Table(name = "survey_matches")
public class SurveyMatch extends PersistenceEntity {

	private static final long serialVersionUID = 1L;

	@OneToOne
	private Subject subject;
	
	@OneToOne
	private Option option;
		
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Option getOption() {
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SurveyMatch() {
    }
	
	public SurveyMatch(Option option, Subject subject) {
		this.option = option;
		this.subject = subject;
    }
	
	public SurveyMatchDTO toSurveyMatchDTO() {
		SurveyMatchDTO dto = new SurveyMatchDTO();
		dto.option = this.option.toOptionDTO();
		dto.subject = this.subject.toSubjectDTO();
		return dto;
    }
}
