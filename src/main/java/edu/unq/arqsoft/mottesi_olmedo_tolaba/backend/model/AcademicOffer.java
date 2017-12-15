package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
@Table(name = "academic_offers")
public class AcademicOffer extends PersistenceEntity {

	private static final long serialVersionUID = 358926861833214321L;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "id_academic_offer")
	@IndexColumn(name = "length")
	private List<Offer> offers;

	@OneToOne(cascade = CascadeType.ALL)
    private Period period;
	
	private String endDate;
	
	private boolean active;

    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "id_academic_offer")
	@IndexColumn(name = "length")
	private List<Statistic> statistics;

	public AcademicOffer() {
    }

    public AcademicOffer(List<Offer> offers, Period period, String endDate, boolean active, List<Statistic> statistics) {
        this.offers = offers;
        this.period = period;
        this.endDate = endDate;
        this.active = active;
        this.statistics = statistics;
    }

    public AcademicOffer(List<Offer> offers, Period period, String endDate, boolean active) {
        this.offers = offers;
        this.period = period;
        this.endDate = endDate;
        this.active = active;
        this.statistics = this.offers.stream()
                .map(offer -> new Statistic(offer.getSubject(), this.createOptionCounter(offer)))
                .collect(Collectors.toList());
    }

    private List<OptionCounter> createOptionCounter(Offer offer) {
        List<OptionCounter> options = new ArrayList<OptionCounter>(Arrays.asList(
                new OptionCounter("Todavia no la voy a cursar",0),
                new OptionCounter("Ya la curse", 0),
                new OptionCounter("Quisiera pero...", 0)
        ));
        offer.getCourses().forEach(course -> options.add(new OptionCounter(course.getName(), course.getQuantity(), 0)));
        return options;
    }

    public List<Statistic> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<Statistic> statistics) {
        this.statistics = statistics;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }
    
    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public AcademicOffer updateStatistics(Survey currentSurvey, List<SurveyMatch> surveyMatches) {
		this.undoStatistics(currentSurvey);
		this.doStatistics(surveyMatches);
		return this;
	}

	private void doStatistics(List<SurveyMatch> surveyMatches) {
		this.statistics.forEach(statistic -> {
			SurveyMatch currentSurveyMatch = surveyMatches.stream()
				.filter(surveyMatch -> surveyMatch.getSubject().getName().equals(statistic.getSubject().getName()))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("No se encontro subject"));
			OptionCounter currentOptionCounter = statistic.getOptionsCounter().stream()
				.filter(optionCounter -> optionCounter.getDescription().equals(currentSurveyMatch.getOption().getDescription()))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("No se encontro opcion"));
			currentOptionCounter.increase();
		});		
	}

	private void undoStatistics(Survey currentSurvey) {
		if(currentSurvey.getWasAnswered()){
			this.runUndoStatistics(currentSurvey);
		}		
	}

	private void runUndoStatistics(Survey currentSurvey) {
		this.statistics.forEach(statistic -> {
			SurveyMatch currentSurveyMatch = currentSurvey.getSurveyMatches().stream()
					.filter(surveyMatch -> surveyMatch.getSubject().getName().equals(statistic.getSubject().getName()))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("No se encontro subject"));
			OptionCounter currentOptionCounter = statistic.getOptionsCounter().stream()
				.filter(optionCounter -> optionCounter.getDescription().equals(currentSurveyMatch.getOption().getDescription()))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("No se encontro opcion"));
			currentOptionCounter.decrease();
		});		
	}
	
	
}
