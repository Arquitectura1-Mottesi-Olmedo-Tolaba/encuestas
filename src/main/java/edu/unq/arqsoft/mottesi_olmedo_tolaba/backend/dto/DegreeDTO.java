package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Degree;

public class DegreeDTO {

	private String name;
	private Long id;

	public DegreeDTO() {
	}

	public DegreeDTO(String name, Long id) {
		this.name = name;
		this.id = id;
	}

	public DegreeDTO(Degree degree){
		this(degree.getName(), degree.getId());
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
