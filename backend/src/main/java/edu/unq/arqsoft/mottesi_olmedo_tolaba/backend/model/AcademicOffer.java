package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.List;

@Entity
@Table(name = "academic_offers")
public class AcademicOffer extends PersistenceEntity {

	private static final long serialVersionUID = 358926861833214321L;
	
	
	private List<Course> courses;
	

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "period_id")
    private Period period;
    
    @ManyToOne(cascade=CascadeType.MERGE)
	@JsonBackReference
	private Degree degree;


	public AcademicOffer() {
    }

    public AcademicOffer(List<Course> courses, Period period, Degree degree) {
        this.courses = courses;
        this.period = period;
        this.degree = degree;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
