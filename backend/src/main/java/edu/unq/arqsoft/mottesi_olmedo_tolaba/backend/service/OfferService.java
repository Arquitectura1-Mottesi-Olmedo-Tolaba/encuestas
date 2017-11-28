package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Course;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Offer;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Professor;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Subject;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Timeline;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.OfferRepository;


@Transactional
@Service
public class OfferService extends GenericService<Offer> {

	@Autowired
	private OfferRepository repository;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private SubjectService subjectService;
	
	public SubjectService getSubjectService() {
		return subjectService;
	}

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	public OfferService() {}
	
	public OfferService(OfferRepository repo) {
		this.setRepository(repo);
	}

	public OfferRepository getRepository() {
		return repository;
	}

	public void setRepository(OfferRepository repository) {
		this.repository = repository;
	}
	
	public ProfessorService getProfessorService() {
		return professorService;
	}

	public void setProfessorService(ProfessorService profesorService) {
		this.professorService = profesorService;
	}
	
	@Transactional
	public Offer update(Offer offer) {
		return super.update(offer);
	}
	
	@Transactional
	public Offer save(Offer model) {
		return super.save(model);
	}
	
	@Transactional
	public Offer newCourseWithSubjectAndProfessor(Long idSubject, Long idProfessor, List<Timeline> timelines) {
		Professor professor = this.getProfessorService().find(idProfessor);
		Subject subject = this.getSubjectService().find(idSubject);
		
		Course newCourse = new Course(professor, timelines);
		Offer offer = new Offer(subject,Arrays.asList(newCourse));
		return this.save(offer);
	}

	@Transactional
	public Offer updateOffer(Long idOffer, Long idCourse, Long idSubject, Long idProfessor, List<Timeline> timelines) {
		Offer offerToUpdate = this.getRepository().findById(idOffer);
		Course courseToUpdate = courseService.find(idCourse);
		Professor professor = this.getProfessorService().find(idProfessor);
		Subject subject = this.getSubjectService().find(idSubject);
		courseToUpdate.setProfessor(professor);
		offerToUpdate.setSubject(subject);
		courseToUpdate.setTimelines(timelines);
		this.courseService.update(courseToUpdate);
		return this.update(offerToUpdate);
	}
}