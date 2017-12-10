package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.StudentDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Student;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.StudentRepository;


@Service
@Transactional
public class StudentService extends GenericService<Student> {
	
	@Autowired
	private StudentRepository repository;
	
	@Autowired
	private SubjectService subjectService;
	
	public StudentRepository getRepository() {
		return repository;
	}
	
	public SubjectService getSubjectService() {
		return subjectService;
	}

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	public void setRepository(StudentRepository repository) {
		this.repository = repository;
	}

	public StudentService() { }

	public Student findByStudentId(Integer studentId) {
		return this.repository.findByStudentId(studentId);
	}

	public Student newStudent(String name, String lastName, Integer studentID, String email) {
		Student newStudent = new Student(name, lastName, studentID, email);
		return this.save(newStudent);
	}
	
	public Student updateStudent(Long idStudent, String name, String lastName, Integer studentID, String email) {
		Student studentToUpdate = this.getRepository().findById(idStudent);
		studentToUpdate.setName(name);
		studentToUpdate.setLastName(lastName);
		studentToUpdate.setStudentID(studentID);
		studentToUpdate.setEmail(email);
		return this.update(studentToUpdate);
	}
	
	public StudentDTO StudentToDTO(Student student) {
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(student.getId());
		studentDTO.setName(student.getName());
		//studentDTO.setApprovedSubjects(this.getSubjectService().subjectsToDTO());
		return studentDTO;
	}
}