package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Degree;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.DegreeStudent;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Student;

@Repository
@SuppressWarnings("unchecked")
public class DegreeStudentRepository extends HibernateGenericDAO<DegreeStudent> implements GenericRepository<DegreeStudent> {

	private static final long serialVersionUID = -4425722631916607857L;

	private List<DegreeStudent> degrees;
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public DegreeStudentRepository() {
		this.setDegrees(new LinkedList<DegreeStudent>());
	}

	@Override
	public Class<DegreeStudent> getDomainClass() {
		return DegreeStudent.class;
	}

	public List<DegreeStudent> getDegrees() {
		return degrees;
	}

	public void setDegrees(List<DegreeStudent> degrees) {
		this.degrees = degrees;
	}

	public Integer studentsForDegree(Long idDegree) {
		//TODO: 
		String query = "SELECT count(degreeStudent) FROM " + persistentClass.getName() + " degreeStudent "
				+ "WHERE degreeStudent.degree.id = ? ";
		return ((Long) this.getHibernateTemplate().find(query, idDegree).get(0)).intValue();
		
	}

	public List<Student> searchStudentForDegree(Long idDegree) {
		String query = "SELECT student FROM " + persistentClass.getName() 
			+ " degreeStudent JOIN  "
			+ "Student student ON student.id = degreeStudent.student.id "
			+ "WHERE degreeStudent.degree.id = ? ";
		return (List<Student>) this.getHibernateTemplate().find(query, idDegree);
	}


}
