package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto;

import java.io.Serializable;

public class DegreeStudentDTO implements Serializable{

	private static final long serialVersionUID = 6477268411333321005L;
	public Long id;
	public StudentDTO student;
	public DegreeDTO degree;
	
	public DegreeStudentDTO() {
	}
	
	public DegreeStudentDTO(Long id ,StudentDTO sDTO, DegreeDTO dDTO) {
		this.id = id;
		this.student =sDTO;
		this.degree = dDTO;
	}

	
}
