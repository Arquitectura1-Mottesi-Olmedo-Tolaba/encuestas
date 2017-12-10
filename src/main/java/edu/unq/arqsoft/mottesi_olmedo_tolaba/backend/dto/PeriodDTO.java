package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto;

import java.io.Serializable;

public class PeriodDTO implements Serializable{
	
	private Long id;
    private int year;
    private int quarter;

    public PeriodDTO(){}
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getQuarter() {
		return quarter;
	}

	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}

}
