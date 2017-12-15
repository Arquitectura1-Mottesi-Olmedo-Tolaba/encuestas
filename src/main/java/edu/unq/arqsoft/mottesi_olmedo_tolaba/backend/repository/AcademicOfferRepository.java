package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.AcademicOffer;

@Repository
public class AcademicOfferRepository extends HibernateGenericDAO<AcademicOffer> implements GenericRepository<AcademicOffer> {

	private static final long serialVersionUID = -4425722631916607857L;

	private List<AcademicOffer> academicOffers;
	
	public AcademicOfferRepository() {
		this.setAcademicOffers(new LinkedList<AcademicOffer>());
	}

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

	public AcademicOffer getCurrentAcademicOfferFor(Long idDegree) {
		String hql = "SELECT academicOffer FROM Degree as degree" +
                " inner join degree.academicOffers as academicOffer" +
                " where degree.id = :idDegree and academicOffer.active = :active";
        Query query = this.getSessionFactory().getCurrentSession().createQuery(hql)
                .setParameter("idDegree", idDegree)
                .setParameter("active", true);
        return (AcademicOffer) query.uniqueResult();
	}

}
