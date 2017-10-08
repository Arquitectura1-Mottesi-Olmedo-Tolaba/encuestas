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
	private List<Course> courses;

	@OneToOne
    private Period period;

	public AcademicOffer() {
    }

    public AcademicOffer(List<Course> courses, Period period) {
        this.courses = courses;
        this.period = period;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
