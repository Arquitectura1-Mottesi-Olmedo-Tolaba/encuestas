package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.List;

@Entity
@Table(name = "academic_offers")
public class AcademicOffer extends PersistenceEntity {

	private static final long serialVersionUID = 358926861833214321L;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Offer> offers;

	@OneToOne
    private Period period;
	
	private String name;

	public AcademicOffer() {
    }
	
    public AcademicOffer(String name, List<Offer> offers, Period period) {
        this.offers = offers;
        this.period = period;
        this.setName(name);
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
