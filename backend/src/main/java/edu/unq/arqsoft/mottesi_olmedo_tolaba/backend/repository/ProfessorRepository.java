package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Professor;

@Repository
@SuppressWarnings("unchecked")
public class ProfessorRepository extends HibernateGenericDAO<Professor> implements GenericRepository<Professor> {

	private static final long serialVersionUID = -4425722631916607857L;

	private List<Professor> professors;
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ProfessorRepository() {
		this.setProfessors(new LinkedList<Professor>());
	}

	@Override
	public Class<Professor> getDomainClass() {
		return Professor.class;
	}

	public List<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(List<Professor> Professors) {
		this.professors = professors;
	}


}
