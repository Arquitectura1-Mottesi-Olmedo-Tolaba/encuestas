package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.DegreeDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.SubjectDTO;

@Entity
@Table(name = "degrees")
public class Degree extends PersistenceEntity {

	private static final long serialVersionUID = 6591632026675920348L;

	private String name;
        
    @OneToMany(cascade=CascadeType.ALL)
    private List<Subject> subjects;
    
    @OneToMany(cascade=CascadeType.ALL)
    private List<AcademicOffer> academicOffers;

    public Degree(String name, List<Subject> subjects, List<AcademicOffer> academicOffers) {
        this.name = name;
        this.subjects = subjects;
        this.academicOffers = academicOffers;
    }

    public Degree() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<AcademicOffer> getAcademicOffers() {
        return academicOffers;
    }

    public void setAcademicOffers(List<AcademicOffer> academicOffers) {
        this.academicOffers = academicOffers;
    }

	public DegreeDTO toDTO() {
		// TODO Auto-generated method stub
		
		List<SubjectDTO> subjectsDTO = new ArrayList<SubjectDTO>();
		for(Subject subject : this.subjects ){
			subjectsDTO.add(subject.toSubjectDTO());
		}
		
		return null; //new DegreeDTO(this.id,this.name,subjectsDTO);
	}

	public void addAcademicOffer(AcademicOffer academicOffer) {
		this.academicOffers.add(academicOffer);		
	}
}
