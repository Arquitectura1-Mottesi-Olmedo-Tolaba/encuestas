package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Course;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Period;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.CourseRepository;


@Transactional
@Service
public class CourseService extends GenericService<Course> {

	@Autowired
	private CourseRepository repository;
	
	public CourseService() {}
	
	public CourseService(CourseRepository repo) {
		this.setRepository(repo);
	}

	public CourseRepository getRepository() {
		return repository;
	}

	public void setRepository(CourseRepository repository) {
		this.repository = repository;
	}
	
	@Transactional
	public Course update(Course newBrand) {
		return super.update(newBrand);
	}
	
	@Transactional
	public Course save(Course model) {
		return super.save(model);
	}
	

}
