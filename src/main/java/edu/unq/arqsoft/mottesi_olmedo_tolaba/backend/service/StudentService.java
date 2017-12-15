package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.StudentDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.StudentSurvey;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.StudentSurveyDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.SubjectDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.AcademicOffer;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Student;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Subject;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Survey;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.StudentRepository;


@Service
@Transactional
public class StudentService extends GenericService<Student> {
	
	@Autowired
	private StudentRepository repository;

    @Autowired
    private SurveyService surveyService;
    
    @Autowired
    private AcademicOfferService academicOfferService;
    

	public StudentRepository getRepository() {
		return repository;
	}

	public void setRepository(StudentRepository repository) {
		this.repository = repository;
	}

	public StudentService() { }

    private List<SubjectDTO> getApprovedSubjectsDTO(Student student){
		List<SubjectDTO> dtos = new ArrayList<SubjectDTO>();
		for (Subject subject : student.getApprovedSubjects()){
			//dtos.add(this.subjectService.subjectToDTO(subject));
		}
		return dtos;
	}
	
	public StudentDTO StudentToDTO(Student student){
		StudentDTO studentDTO = student.minimumStudentToDTO();
		studentDTO.setApprovedSubjects(getApprovedSubjectsDTO(student));
		return studentDTO;
	}

	@Transactional
    public Boolean verifyCode(String code) {
    	return surveyService.verifyCode(code);
    }

    @Transactional
    public StudentSurveyDTO getSurveyByCode(String code) {
        return surveyService.getSurveyByCode(code);
    }

    @Transactional
	public void completeSurvey(StudentSurvey studentSurvey) {
		Survey currentSurvey = surveyService.getByCode(studentSurvey.getCode());
		AcademicOffer academicOffer = currentSurvey.getAcademicOffer().updateStatistics(currentSurvey, studentSurvey.getSurveyMatches());
		academicOfferService.update(academicOffer);
		Survey updatedSurvey = currentSurvey.update(studentSurvey);
		surveyService.update(updatedSurvey);
	}
}