package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Subject;

@Repository
@SuppressWarnings("unchecked")
public class SubjectRepository extends HibernateGenericDAO<Subject> implements GenericRepository<Subject> {

	private static final long serialVersionUID = -4425722631916607857L;

	private List<Subject> subjects;
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SubjectRepository() {
		this.setSubjects(new LinkedList<Subject>());
	}

	@Override
	public Class<Subject> getDomainClass() {
		return Subject.class;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> Subjects) {
		this.subjects = subjects;
	}


}
