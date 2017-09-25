package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import org.joda.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "timelines")
public class Timeline extends PersistenceEntity {

    private String day;
    private LocalTime start;
    private LocalTime end;

    public Timeline() {
    }

    public Timeline(String day, LocalTime start, LocalTime end) {
        this.day = day;
        this.start = start;
        this.end = end;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }
}
