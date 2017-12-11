package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.UserCredential;

public class DirectorDTO implements Serializable{

	private static final long serialVersionUID = -4655259408872462825L;
	public List<DegreeDTO> degrees;
	public UserCredential user;
	
	public DirectorDTO(){	
		this.degrees = new ArrayList<DegreeDTO>();
	}
	
	public DirectorDTO(List<DegreeDTO> degrees, UserCredential user){
		this.degrees = degrees;
		this.user = user;
	}
	
}
