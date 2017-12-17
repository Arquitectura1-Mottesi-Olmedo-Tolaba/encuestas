package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.StudentSurvey;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.StudentSurveyDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.AcademicOffer;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Student;
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