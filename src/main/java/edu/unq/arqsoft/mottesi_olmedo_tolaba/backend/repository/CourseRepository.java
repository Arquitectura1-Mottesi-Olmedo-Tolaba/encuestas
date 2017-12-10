package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Course;

@Repository
@SuppressWarnings("unchecked")
public class CourseRepository extends HibernateGenericDAO<Course> implements GenericRepository<Course> {

	private static final long serialVersionUID = -4425722631916607857L;

	private List<Course> courses;
	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CourseRepository() {
		this.setCourses(new LinkedList<Course>());
	}

	@Override
	public Class<Course> getDomainClass() {
		return Course.class;
	}


}
