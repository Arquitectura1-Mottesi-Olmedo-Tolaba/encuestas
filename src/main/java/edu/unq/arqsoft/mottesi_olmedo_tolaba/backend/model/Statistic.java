package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "statistics")
public class Statistic extends PersistenceEntity {

	private static final long serialVersionUID = 4669585377676269862L;

	@OneToOne(cascade = CascadeType.ALL)
	private Subject subject;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_statistic")
	@IndexColumn(name = "length")
	private List<OptionCounter> optionsCounter;

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<OptionCounter> getOptionsCounter() {
		return optionsCounter;
	}

	public void setOptionsCounter(List<OptionCounter> optionsCounter) {
		this.optionsCounter = optionsCounter;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Statistic() {
	}

	public Statistic(Subject subject, List<OptionCounter> optionsCounter) {
		this.subject = subject;
		this.optionsCounter = optionsCounter;
	}

}
