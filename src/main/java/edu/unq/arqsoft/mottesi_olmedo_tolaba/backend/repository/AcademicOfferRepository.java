package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.AcademicOffer;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Period;

@Repository
@SuppressWarnings("unchecked")
public class AcademicOfferRepository extends HibernateGenericDAO<AcademicOffer> implements GenericRepository<AcademicOffer> {

	private static final long serialVersionUID = -4425722631916607857L;

	private List<AcademicOffer> academicOffers;
	
	public AcademicOfferRepository() {
		this.setAcademicOffers(new LinkedList<AcademicOffer>());
	}
	
	/*
	@Transactional
	public AcademicOffer findByPeriod(Period period) {
		String query = "SELECT academicOffer FROM " + this.persistentClass.getName() + " academicOffer JOIN Period p ON accademicOffer.period WHERE period.id = '" + period.getId() + "'";
		List<AcademicOffer> academicOffers = (List<AcademicOffer>) this.getHibernateTemplate().find(query);
		return academicOffers.isEmpty() ? null : academicOffers.get(0);
	}
	*/

	@Override
	public Class<AcademicOffer> getDomainClass() {
		return AcademicOffer.class;
	}

	public List<AcademicOffer> getAcademicOffers() {
		return academicOffers;
	}

	public void setAcademicOffers(List<AcademicOffer> academicOffers) {
		this.academicOffers = academicOffers;
	}

}
