package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.ProfessorDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Professor;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.ProfessorRepository;


@Transactional
@Service
public class ProfessorService extends GenericService<Professor> {

	@Autowired
	private ProfessorRepository repository;
	
	public ProfessorService() {}
	
	public ProfessorService(ProfessorRepository repo) {
		this.setRepository(repo);
	}

	public ProfessorRepository getRepository() {
		return repository;
	}

	public void setRepository(ProfessorRepository repository) {
		this.repository = repository;
	}
	
	@Transactional
	public Professor update(Professor model) {
		return super.update(model);
	}
	
	@Transactional
	public Professor save(Professor model) {
		return super.save(model);
	}
	
	public Professor newProfessor(String name) {
		Professor newProfessor = new Professor(name);
		return this.save(newProfessor);
	}

	public ProfessorDTO ProfessorToDTO(Professor professor) {
		ProfessorDTO professorDTO = new ProfessorDTO();
		professorDTO.setId(professor.getId());
		professorDTO.setName(professor.getName());
		return professorDTO;
	}
}
