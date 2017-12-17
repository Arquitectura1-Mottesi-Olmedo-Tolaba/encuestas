package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.AcademicOffer;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.AcademicOfferRepository;

@Transactional
@Service
public class AcademicOfferService extends GenericService<AcademicOffer> {

	@Autowired
	private AcademicOfferRepository repository;

	public AcademicOfferService() {
	}

	public AcademicOfferService(AcademicOfferRepository repo) {
		this.setRepository(repo);
	}

	public AcademicOfferRepository getRepository() {
		return repository;
	}

	public void setRepository(AcademicOfferRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public AcademicOffer update(AcademicOffer newBrand) {
		return super.update(newBrand);
	}

	@Transactional
	public AcademicOffer save(AcademicOffer model) {
		return super.save(model);
	}

	@Transactional
	public AcademicOffer getCurrentAcademicOfferFor(Long idDegree) {
		return this.getRepository().getCurrentAcademicOfferFor(idDegree);
	}

}
