package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Degree;

@Repository
@SuppressWarnings("unchecked")
public class DegreeRepository extends HibernateGenericDAO<Degree> implements GenericRepository<Degree> {

	private static final long serialVersionUID = -4425722631916607857L;

	private List<Degree> degrees;
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public DegreeRepository() {
		this.setDegrees(new LinkedList<Degree>());
	}

	@Override
	public Class<Degree> getDomainClass() {
		return Degree.class;
	}

	public List<Degree> getDegrees() {
		return degrees;
	}

	public void setDegrees(List<Degree> degrees) {
		this.degrees = degrees;
	}


}
