package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Student;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.StudentRepository;


@Service
@Transactional
public class StudentService extends GenericService<Student> {
	
	@Autowired
	private StudentRepository repository;

	public StudentRepository getRepository() {
		return repository;
	}

	public void setRepository(StudentRepository repository) {
		this.repository = repository;
	}

	public StudentService() { }

    

}