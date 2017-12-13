package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto;

import java.io.Serializable;
import java.util.List;

public class CourseDTO implements Serializable{
	
	private Long id;
    private String name;
    private ProfessorDTO professor;
    private List<TimeLineDTO> timelines;
    private Integer quantity;

    public CourseDTO(){}
    
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

	public ProfessorDTO getProfessor() {
		return professor;
	}

	public void setProfessor(ProfessorDTO professor) {
		this.professor = professor;
	}

	public List<TimeLineDTO> getTimelines() {
		return timelines;
	}

	public void setTimelines(List<TimeLineDTO> timelines) {
		this.timelines = timelines;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
