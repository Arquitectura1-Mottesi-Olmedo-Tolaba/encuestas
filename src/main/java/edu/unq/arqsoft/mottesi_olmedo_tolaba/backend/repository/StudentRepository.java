package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Student;

@Repository
@SuppressWarnings("unchecked")
public class StudentRepository extends HibernateGenericDAO<Student> implements GenericRepository<Student> {

	private static final long serialVersionUID = -4425722631916607857L;

	private List<Student> students;
	
	public StudentRepository() {
		this.setStudents(new LinkedList<Student>());
	}
	
	@Override
	public Class<Student> getDomainClass() {
		return Student.class;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
