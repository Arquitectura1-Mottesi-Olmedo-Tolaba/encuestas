package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository;

import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unchecked")
public class BrandRepository /*extends HibernateGenericDAO<Brand> implements GenericRepository<Brand> */{
/*
	private static final long serialVersionUID = -4425722631916607857L;

	private List<Brand> brands;
	
	public BrandRepository() {
		this.setBrands(new LinkedList<Brand>());
	}
	
	@Transactional
	public Brand findByName(String brand) {
		String query = "SELECT brand FROM " + this.persistentClass.getName() + " brand WHERE brand.name = '" + brand + "'";
		List<Brand> brands = (List<Brand>) this.getHibernateTemplate().find(query);
		return brands.isEmpty() ? null : brands.get(0);
	}

	@Override
	public Class<Brand> getDomainClass() {
		return Brand.class;
	}

	public List<Brand> getBrands() {
		return brands;
	}

	public void setBrands(List<Brand> brands) {
		this.brands = brands;
	}
*/
}
