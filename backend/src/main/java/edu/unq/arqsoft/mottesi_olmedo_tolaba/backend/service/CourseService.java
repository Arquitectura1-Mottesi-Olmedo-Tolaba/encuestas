package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.CourseDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.TimeLineDTO;
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
	
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private TimelineService timelineService;
	
	@Autowired
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
	
	public TimelineService getTimelineService() {
		return timelineService;
	}

	public void setTimelineService(TimelineService timelineService) {
		this.timelineService = timelineService;
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
	public Course newCourseWithSubjectAndProfessor( Long idProfessor, List<Timeline> timelines) {
		Professor professor = this.getProfessorService().find(idProfessor);
		
		Course newCourse = new Course(professor, timelines);
		return this.save(newCourse);
	}

	@Transactional
	public Course updateCourse(Long idCourse,  Long idProfessor, List<Timeline> timelines) {
		Course courseToUpdate = this.getRepository().findById(idCourse);
		Professor professor = this.getProfessorService().find(idProfessor);
		courseToUpdate.setProfessor(professor);
		courseToUpdate.setTimelines(timelines);
		return this.update(courseToUpdate);
	}

	public CourseDTO courseToDTO(Course course){
    	CourseDTO courseDTO = new CourseDTO();
    	courseDTO.setName(course.getName());
    	courseDTO.setProfessor(this.getProfessorService().ProfessorToDTO(course.getProfessor()));
    	courseDTO.setTimelines(this.getTimelineService().timeLinesToDTO(course.getTimelines()));
    	return courseDTO;
    }
	
	public List<CourseDTO> coursesToDTO(List<Course> courses){
		List<CourseDTO> coursesDTO = new ArrayList<CourseDTO>();
		for(Course each : courses) {
			coursesDTO.add(courseToDTO(each));
		}
		return coursesDTO;
	}
}
