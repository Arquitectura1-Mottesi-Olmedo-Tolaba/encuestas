package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto;

import java.io.Serializable;
import java.util.List;

public class StudentDTO implements Serializable{
	
	private Long id;
    private String name;
    private List<String> approvedSubjects;

    public StudentDTO(){}
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getApprovedSubjects() {
		return approvedSubjects;
	}

	public void setApprovedSubjects(List<String> approvedSubjects) {
		this.approvedSubjects = approvedSubjects;
	}
}
