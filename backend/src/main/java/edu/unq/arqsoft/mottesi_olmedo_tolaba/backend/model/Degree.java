package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "degrees")
public class Degree extends PersistenceEntity {

    private String name;
    private List<Subject> subjects;
    private List<AcademicOffer> academicOffers;

    public Degree(String name, List<Subject> subjects, List<AcademicOffer> academicOffers) {
        this.name = name;
        this.subjects = subjects;
        this.academicOffers = academicOffers;
    }

    public Degree() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<AcademicOffer> getAcademicOffers() {
        return academicOffers;
    }

    public void setAcademicOffers(List<AcademicOffer> academicOffers) {
        this.academicOffers = academicOffers;
    }
}
