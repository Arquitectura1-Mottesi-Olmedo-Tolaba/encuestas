package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;


import javax.persistence.Entity;
import javax.persistence.Table;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.OptionDTO;

@Entity
@Table(name = "options")
public class Option extends PersistenceEntity {

	private static final long serialVersionUID = 4669585377676269862L;
	private String description;
	
	public String getDescription() {
		return description;
	}
	
	public OptionDTO toOptionDTO(){
		OptionDTO dto = new OptionDTO();
		dto.setId(this.getDescription());
		dto.setDescription(this.getDescription());
		return dto;
	}
	
	public static Option fromOptionDTO(OptionDTO dto){
		Option option = new Option();		
		option.setDescription(dto.getDescription());
		return option;
	}
	

	public void setDescription(String description) {
		this.description = description;
	}

	public Option() {
    }
	
	public Option(String description) {
		this.description = description;
    }
}
