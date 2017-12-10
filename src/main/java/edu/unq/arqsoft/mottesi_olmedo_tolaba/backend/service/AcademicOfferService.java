package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.AcademicOfferDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.AcademicOffer;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Period;
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
	
	public AcademicOfferDTO getFirstAcademicOfferDTO(){
		AcademicOffer academicOffer = this.find((long) 1);
		return this.AcademicOfferToDTO(academicOffer);
	}
	
	public AcademicOfferDTO AcademicOfferToDTO(AcademicOffer academicOffer) {
		AcademicOfferDTO academicOfferDTO = new AcademicOfferDTO();
		academicOfferDTO.setId(academicOffer.getId());
		academicOfferDTO.setName(academicOffer.getName());
		academicOfferDTO.setEndDate(academicOffer.getEndDate());
		academicOfferDTO.setActive(academicOffer.isActive());
		academicOfferDTO.setPeriod(periodService.periodToDTO(academicOffer.getPeriod()));
		academicOfferDTO.setOffers(offerService.getOffersDTO(academicOffer.getOffers()));
		return academicOfferDTO;
	}
	
	public AcademicOfferDTO AcademicOfferToDTOForStudent(Long idAcademicOffer, Long idStudent){
		AcademicOffer academicOffer = this.getRepository().findById(idAcademicOffer);
		Student student = studentService.find(idStudent);
		AcademicOfferDTO academicOfferDTO = this.AcademicOfferToDTO(academicOffer);
		academicOfferDTO.setStudent(studentService.StudentToDTO(student));
		return academicOfferDTO;
	}

}
