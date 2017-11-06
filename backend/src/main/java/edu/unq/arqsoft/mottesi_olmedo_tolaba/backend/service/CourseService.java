package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Course;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Period;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Professor;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Subject;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Timeline;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.CourseRepository;


@Transactional
@Service
public class CourseService extends GenericService<Course> {

	@Autowired
	private CourseRepository repository;
	private ProfessorService professorService;
	private SubjectService subjectService;
	
	public SubjectService getSubjectService() {
		return subjectService;
	}

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

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
	
	public ProfessorService getProfessorService() {
		return professorService;
	}

	public void setProfessorService(ProfessorService profesorService) {
		this.professorService = profesorService;
	}
	
	@Transactional
	public Course update(Course newBrand) {
		return super.update(newBrand);
	}
	
	@Transactional
	public Course save(Course model) {
		return super.save(model);
	}
	
	@Transactional
	public Course newCourseWithSubjectAndProfessor(Long idSubject, Long idProfessor, List<Timeline> timelines) {
		Professor professor = this.getProfessorService().find(idProfessor);
		Subject subject = this.getSubjectService().find(idSubject);
		Course newCourse = new Course(professor, subject, timelines);
		return this.save(newCourse);
	}

	@Transactional
	public Course updateCourse(Long idCourse, Long idSubject, Long idProfessor, List<Timeline> timelines) {
		Course courseToUpdate = this.getRepository().findById(idCourse);
		Professor professor = this.getProfessorService().find(idProfessor);
		Subject subject = this.getSubjectService().find(idSubject);
		courseToUpdate.setProfessor(professor);
		courseToUpdate.setSubject(subject);
		courseToUpdate.setTimelines(timelines);
		return this.update(courseToUpdate);
	}
}
