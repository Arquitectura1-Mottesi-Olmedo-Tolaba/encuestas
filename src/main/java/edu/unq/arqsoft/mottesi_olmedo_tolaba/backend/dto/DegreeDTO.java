package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto;

import java.util.List;

public class DegreeDTO {

	public String name;
	public List<SubjectDTO> subjectsDTO;

	public DegreeDTO() {
	}
	
	public DegreeDTO(String name, List<SubjectDTO> subjectsDTO) {
		this.name = name;
		this.subjectsDTO = subjectsDTO;
	}

}
