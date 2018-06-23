package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "survey_matches")
public class SurveyMatch extends PersistenceEntity {

	private static final long serialVersionUID = 1L;

	@OneToOne
	private Subject subject;

	@OneToOne(cascade = CascadeType.ALL)
	private Option option;

	public SurveyMatch() {
	}

	public SurveyMatch(Option option, Subject subject) {
		this.option = option;
		this.subject = subject;
	}

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
	
	public Boolean hasSameSubject(SurveyMatch other){
		return this.subject.getName().equals(other.subject.getName());
	}

}
