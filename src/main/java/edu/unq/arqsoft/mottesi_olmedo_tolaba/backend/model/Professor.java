package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "professors")
public class Professor extends PersistenceEntity {

	private static final long serialVersionUID = -1631424011577336819L;
	private String name;

	public Professor() {
	}

	public Professor(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
