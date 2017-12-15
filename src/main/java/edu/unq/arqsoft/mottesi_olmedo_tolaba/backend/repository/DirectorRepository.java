package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Director;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.UserCredential;

@Repository
public class DirectorRepository extends HibernateGenericDAO<Director> implements GenericRepository<Director> {

	private static final long serialVersionUID = -4425722631916607857L;

	@Override
	public Class<Director> getDomainClass() {
		return Director.class;
	}
	
	public Director findDirector(UserCredential credential){
		String hql = "SELECT director FROM Director as director" +
                " inner join director.credential as credential" +
                " where credential.email = :email and credential.password = :password";
        Query query = this.getSessionFactory().getCurrentSession().createQuery(hql)
                .setParameter("email", credential.getEmail())
                .setParameter("password", credential.getPassword());
        return (Director) query.uniqueResult();
	}

}
