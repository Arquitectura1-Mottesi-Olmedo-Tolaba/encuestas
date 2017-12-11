package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto;

import java.util.List;

public class DegreeDTO {

	public String name;
	public List<SubjectDTO> subjectsDTO;
	public Long id;

	public DegreeDTO() {
	}
	
	public DegreeDTO(Long id,String name, List<SubjectDTO> subjectsDTO) {
		this.id = id;
		this.name = name;
		this.subjectsDTO = subjectsDTO;
	}

}
