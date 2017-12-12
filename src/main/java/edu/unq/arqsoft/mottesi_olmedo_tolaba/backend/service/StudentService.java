package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.StudentDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.SubjectDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Student;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Subject;
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
		Student newStudent = new Student();
		newStudent.setEmail(email);
		newStudent.setName(name);
		newStudent.setLastName(lastName);
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
	
	
	private List<SubjectDTO> getApprovedSubjectsDTO(Student student){
		List<SubjectDTO> dtos = new ArrayList<SubjectDTO>();
		for (Subject subject : student.getApprovedSubjects()){
			dtos.add(this.subjectService.subjectToDTO(subject));
		}
		return dtos;
	}
	
	public StudentDTO StudentToDTO(Student student){
		StudentDTO studentDTO = student.minimumStudentToDTO();
		studentDTO.setApprovedSubjects(getApprovedSubjectsDTO(student));
		return studentDTO;
	}
}