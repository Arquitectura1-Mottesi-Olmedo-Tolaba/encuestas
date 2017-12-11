package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "academic_offers")
public class AcademicOffer extends PersistenceEntity {

	private static final long serialVersionUID = 358926861833214321L;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Offer> offers = new LinkedList<Offer>();

	@OneToOne
    private Period period;
	
	private String endDate;
	
	private boolean active;

	public AcademicOffer() {
    }
	
    public AcademicOffer(String name, List<Offer> offers, Period period) {
        this.offers = offers;
        this.period = period;
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
}
