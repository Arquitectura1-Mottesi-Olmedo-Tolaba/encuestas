package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Offer;

@Repository
@SuppressWarnings("unchecked")
public class OfferRepository extends HibernateGenericDAO<Offer> implements GenericRepository<Offer> {

	private static final long serialVersionUID = -4425722631916607857L;

	private List<Offer> offers;
	
	public OfferRepository() {
		this.setOffers(new LinkedList<Offer>());
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
	public Class<Offer> getDomainClass() {
		return Offer.class;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

}
