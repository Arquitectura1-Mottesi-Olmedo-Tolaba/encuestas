package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.OfferDTO;
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
	
	@Autowired
	private OptionService optionService;
	
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
	
	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public OptionService getOptionService() {
		return optionService;
	}

	public void setOptionService(OptionService optionService) {
		this.optionService = optionService;
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
	
	public OfferDTO offerToDTO(Offer offer){
		OfferDTO offerDTO = new OfferDTO();
		offerDTO.setId(offer.getId());
		offerDTO.setCourses(this.getCourseService().coursesToDTO(offer.getCourses()));
		offerDTO.setOptions(this.getOptionService().optionsToDTO(offer.getOptions()));
		offerDTO.setSelectedOption(this.getOptionService().optionToDTO(offer.getSelectedOption()));
		return offerDTO;
	}
	
	public List<OfferDTO> getOffersDTO(List<Offer> offers){
		List<OfferDTO> offersDTO = new ArrayList<OfferDTO>();
		for(Offer each : offers) {
			offersDTO.add(offerToDTO(each));
		}
		return offersDTO;
	}
}
