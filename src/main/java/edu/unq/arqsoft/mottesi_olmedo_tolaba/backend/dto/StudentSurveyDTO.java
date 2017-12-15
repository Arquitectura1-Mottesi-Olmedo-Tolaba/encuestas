package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto;

import java.io.Serializable;
import java.util.List;

import com.google.gson.Gson;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Period;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Student;

public class StudentSurveyDTO implements Serializable{

    private String name;
    private String endDate;
    private Period period;
    private Student student;
    private List<StudentOfferDTO> offers;

    public StudentSurveyDTO(){}

    public StudentSurveyDTO(String name, String endDate, Period period, Student student, List<StudentOfferDTO> offers) {
        this.name = name;
        this.endDate = endDate;
        this.period = period;
        this.student = student;
        this.offers = offers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<StudentOfferDTO> getOffers() {
        return offers;
    }

    public void setOffers(List<StudentOfferDTO> offers) {
        this.offers = offers;
    }
}
