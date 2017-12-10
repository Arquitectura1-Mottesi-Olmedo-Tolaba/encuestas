package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto;

import java.io.Serializable;

public class OptionDTO implements Serializable{
	
	private String id;
    private String description;

    public OptionDTO(){}
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
