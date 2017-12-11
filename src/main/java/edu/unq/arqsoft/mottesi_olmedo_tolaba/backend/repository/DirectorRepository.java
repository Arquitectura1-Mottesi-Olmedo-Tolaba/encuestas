package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Degree;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Director;

@Repository
@SuppressWarnings("unchecked")
public class DirectorRepository extends HibernateGenericDAO<Director> implements GenericRepository<Director> {

	private static final long serialVersionUID = -4425722631916607857L;

	private List<Director> directores;
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public DirectorRepository() {
		this.setDegrees(new LinkedList<Director>());
	}

	@Override
	public Class<Director> getDomainClass() {
		return Director.class;
	}

	public List<Director> getDegrees() {
		return directores;
	}

	public void setDegrees(List<Director> directores) {
		this.directores = directores;
	}


}
