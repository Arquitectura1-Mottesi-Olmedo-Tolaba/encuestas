package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "periods")
public class Period extends PersistenceEntity {

    private Integer year;
    private Integer quarter;
    
    @OneToOne(mappedBy = "academicOffer", cascade = CascadeType.ALL, 
            fetch = FetchType.LAZY, optional = false)
    private AcademicOffer academicOffer;

    public Period() {
    }

    public Period(Integer year, Integer quarter) {
        this.year = year;
        this.quarter = quarter;
    }

    public Period(Integer year, Integer quarter, AcademicOffer offer) {
        this.year = year;
        this.quarter = quarter;
        this.academicOffer = offer;
    }
    
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }
}
