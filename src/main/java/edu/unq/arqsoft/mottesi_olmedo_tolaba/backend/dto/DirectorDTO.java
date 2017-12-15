package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Director;

public class DirectorDTO implements Serializable{

	private static final long serialVersionUID = -4655259408872462825L;
	private List<DegreeDTO> degrees;
	
	public DirectorDTO(Director director){	
		this.degrees = director.getDegrees().stream()
				.map(degree -> new DegreeDTO(degree))
				.collect(Collectors.toList());

	}

	public DirectorDTO(List<DegreeDTO> degrees) {
		this.degrees = degrees;
	}

	public List<DegreeDTO> getDegrees() {
		return degrees;
	}

	public void setDegrees(List<DegreeDTO> degrees) {
		this.degrees = degrees;
	}
}
