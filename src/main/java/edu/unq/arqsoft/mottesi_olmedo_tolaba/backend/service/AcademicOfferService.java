package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.StudentSurveyDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.exceptions.EntityNotExistingException;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.AcademicOffer;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Student;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.AcademicOfferRepository;


@Transactional
@Service
public class AcademicOfferService extends GenericService<AcademicOffer> {

	@Autowired
	private AcademicOfferRepository repository;
	
	@Autowired
	private PeriodService periodService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private OfferService offerService;
	
	public AcademicOfferService() {}
	

	public AcademicOfferService(AcademicOfferRepository repo) {
		this.setRepository(repo);
	}

	public AcademicOfferRepository getRepository() {
		return repository;
	}

	public void setRepository(AcademicOfferRepository repository) {
		this.repository = repository;
	}

	/*
	@Transactional
	public AcademicOffer findByPeriod(Period period) {
		return this.getRepository().findByPeriod(period);
	}
	*/
	
	@Transactional
	public AcademicOffer update(AcademicOffer newBrand) {
		return super.update(newBrand);
	}
	
	@Transactional
	public AcademicOffer save(AcademicOffer model) {
		return super.save(model);
	}
	
	public StudentSurveyDTO getAcademicOfferDTOById(Long id){
		AcademicOffer academicOffer = this.find(id);
		if (academicOffer == null){
			throw new EntityNotExistingException("No existe esa oferta academica");
		}
		
		return this.AcademicOfferToDTO(academicOffer);
	}
	
	public StudentSurveyDTO AcademicOfferToDTO(AcademicOffer academicOffer) {
		StudentSurveyDTO academicOfferDTO = new StudentSurveyDTO();
		academicOfferDTO.setId(academicOffer.getId());
		academicOfferDTO.setEndDate(academicOffer.getEndDate());
		academicOfferDTO.setActive(academicOffer.isActive());
		academicOfferDTO.setPeriod(periodService.periodToDTO(academicOffer.getPeriod()));
		
		//Ver como ponderar elecciones pasadas...
		academicOfferDTO.setOffers(offerService.getOffersDTO(academicOffer.getOffers()));
		return academicOfferDTO;
	}
	
	public StudentSurveyDTO AcademicOfferToDTOForStudent(Long idAcademicOffer, Long idStudent){
		
		AcademicOffer academicOffer = this.getRepository().findById(idAcademicOffer);
		Student student = studentService.find(idStudent);
		StudentSurveyDTO academicOfferDTO = this.AcademicOfferToDTO(academicOffer);
		academicOfferDTO.setStudent(studentService.StudentToDTO(student));
		return academicOfferDTO;
	}

}
