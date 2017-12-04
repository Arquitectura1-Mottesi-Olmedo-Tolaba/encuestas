package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;


import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "options")
public class Option extends PersistenceEntity {

	private String description;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Option() {
    }
}
