package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "periods")
public class Period extends PersistenceEntity {

	private static final long serialVersionUID = 7472787803902479176L;
	private Integer year;
	private Integer quarter;

	public Period() {
	}

	public Period(Integer year, Integer quarter) {
		this.year = year;
		this.quarter = quarter;
	}

	public Period(Integer year, Integer quarter, AcademicOffer offer) {
		this.year = year;
		this.quarter = quarter;
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
