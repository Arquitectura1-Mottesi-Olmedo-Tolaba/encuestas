package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "academic_offers")
public class AcademicOffer extends PersistenceEntity {

    private List<Course> courses;
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
}
