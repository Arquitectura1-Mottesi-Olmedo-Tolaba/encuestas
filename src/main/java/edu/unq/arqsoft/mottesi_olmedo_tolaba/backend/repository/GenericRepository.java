package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository;

import java.io.Serializable;
import java.util.List;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Survey;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.pagination.PageRequest;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.pagination.PageResponse;

public interface GenericRepository<T> {

	void save(T entity);

	void delete(T entity);

	void update(T entity);

	T findById(Serializable id);

	List<T> findAll();

	void deleteById(Serializable id);

	int count();

	List<T> findByExample(T exampleObject);

	PageResponse<T> findByPage(PageRequest<T> pageRequest);
	
	Class<T> getDomainClass();

	
}
