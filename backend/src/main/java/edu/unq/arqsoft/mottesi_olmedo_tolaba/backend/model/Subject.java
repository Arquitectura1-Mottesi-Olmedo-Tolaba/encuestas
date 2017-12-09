package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.SubjectDTO;

@Entity
@Table(name = "subjects")
public class Subject extends PersistenceEntity {

	private static final long serialVersionUID = -5546561326119736237L;

	private String name;

    public Subject() {
    }
    
	public SubjectDTO toSubjectDTO(){
		SubjectDTO dto = new SubjectDTO();
		dto.setId(this.id);
		dto.setName(this.name);
		return dto;
	}
	
	public Subject fromSubjectDTO(SubjectDTO dto){
		Subject subject = new Subject();
		subject.setName(dto.getName());
		return subject;
	}

    public Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

