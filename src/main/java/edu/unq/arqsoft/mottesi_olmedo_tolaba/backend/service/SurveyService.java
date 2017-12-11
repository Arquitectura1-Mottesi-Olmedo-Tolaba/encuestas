package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.StudentSurveyDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.SurveyDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.SurveyMatchDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.AcademicOffer;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Student;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Survey;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.SurveyMatch;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.SurveyRepository;


@Transactional
@Service
public class SurveyService extends GenericService<Survey> {

	@Autowired
	private SurveyRepository repository;
	
	@Autowired
	private PeriodService periodService;
		
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private OfferService offerService;
	
	@Autowired
	private SurveyMatchService surveyMatchService;
	
	public SurveyService() {}
	
	public SurveyService(SurveyRepository repo) {
		this.setRepository(repo);
	}

	public SurveyRepository getRepository() {
		return repository;
	}

	public void setRepository(SurveyRepository repository) {
		this.repository = repository;
	}
	
	@Transactional
	public Survey update(Survey model) {
		return super.update(model);
	}
	
	@Transactional
	public Survey save(Survey model) {
		return super.save(model);
	}
	
	public Survey newSurvey(List<SurveyMatch> surveyMatches) {
		Survey elem = new Survey();
		elem.setSurveyMatches(surveyMatches);
		return this.save(elem);
	}

	public Survey createSurveyFromDto(SurveyDTO surveyDTO) {
		Survey survey = new Survey();
		for (SurveyMatchDTO smDTO : surveyDTO.surveyMatches){
			SurveyMatch sm = surveyMatchService.createSurveyMatchFromDTO(smDTO);
			survey.addSurveyMatch(sm);
		}		
		return this.save(survey);
	}

	public Survey createSurvey(Student student, AcademicOffer academicOffer) {
		Survey survey = new Survey(student,academicOffer);
		return this.save(survey);
	}
	
	public Survey getByCode(String code) {
		return this.repository.getByCode(code);
	}

	public StudentSurveyDTO getDTO(AcademicOffer academicOffer) {
		StudentSurveyDTO academicOfferDTO = new StudentSurveyDTO();
		academicOfferDTO.setId(academicOffer.getId());
		academicOfferDTO.setEndDate(academicOffer.getEndDate());
		academicOfferDTO.setActive(academicOffer.isActive());
		academicOfferDTO.setPeriod(periodService.periodToDTO(academicOffer.getPeriod()));
		
		//Ver como ponderar elecciones pasadas...
		academicOfferDTO.setOffers(offerService.getOffersDTO(academicOffer.getOffers()));
		return academicOfferDTO;
	}
	
	
	public StudentSurveyDTO makeDTOFrom(String code) {
		Survey survey = getByCode(code);
		StudentSurveyDTO dto = this.getDTO(survey.getAcademicOffer());
		dto.setStudent(studentService.StudentToDTO(survey.getStudent()));
		return dto;
	}
	
}
