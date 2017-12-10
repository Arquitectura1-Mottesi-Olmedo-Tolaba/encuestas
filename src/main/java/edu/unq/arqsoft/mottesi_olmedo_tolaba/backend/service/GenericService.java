package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.SurveyDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Survey;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.GenericRepository;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.pagination.PageRequest;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.pagination.PageRequestBuilder;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.pagination.PageResponse;


public abstract class GenericService<T> {
	
	public abstract GenericRepository<T> getRepository();
	
	@Transactional
	public T save(T entity) {
		this.getRepository().save(entity);
		return entity;
	}
	
	@Transactional
	public T update(T entity) {
		this.getRepository().update(entity);
		return entity;
	}
	
	@Transactional
	public T find(Long id) {
		return this.getRepository().findById(id);
	}
	
	@Transactional
	public void delete(T entity) {
		this.getRepository().delete(entity);
	}
	
	
	@Transactional
	public List<T> findAll() {
		return this.getRepository().findAll();
	}
	
	@Transactional
	public void delete(Long id) {
		this.getRepository().deleteById(id);
	}

	@Transactional
	public PageResponse<T> findByPage(Integer pageNumber, Integer pageSize) {
		PageRequest<T> pageRequest = new PageRequestBuilder<T>(getRepository().getDomainClass())
				.setPageSize(pageSize)
				.setPageNumber(pageNumber)
				.build();
		return getRepository().findByPage(pageRequest);
	}


}
