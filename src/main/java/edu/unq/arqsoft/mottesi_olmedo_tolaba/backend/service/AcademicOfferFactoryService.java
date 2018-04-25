package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.fakeData.FakeData;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Degree;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.DegreeStudent;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Director;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Student;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.StudentSurvey;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.UserCredential;

@Transactional
@Service
public class AcademicOfferFactoryService {

	@Autowired
	private DirectorService directorService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private SurveyService surveyService;

    @Autowired
    private DegreeStudentService degreeStudentService;


	@Transactional
	public void initialize() {
		FakeData fakeData = new FakeData();
		
        // Create degrees
		Degree degreeTPI = fakeData.degreeTPI();
        Degree degreeLicBio = fakeData.degreeLICBIO();
        Degree degreeArqNaval = fakeData.degreeArqNaval();
        
        // Create director
        Director director = new Director(Arrays.asList(degreeTPI, degreeLicBio, degreeArqNaval),new UserCredential("director@gmail.com", "director"));
		directorService.save(director);

        // Create students
        List<Student> studentsTpi = fakeData.studentsTPI();
        studentsTpi.forEach(student -> studentService.save(student));
        List<Student> studentsLicBio = fakeData.studentsLicBio();
        studentsLicBio.forEach(student -> studentService.save(student));
        List<Student> studentsArqNaval = fakeData.studentsArqNaval();
        studentsTpi.forEach(student -> studentService.save(student));
        
        // Create degreeStudents
        List<DegreeStudent> degreeStudentsTpi = fakeData.getDegreeStudentsOf(degreeTPI, studentsTpi);
        degreeStudentsTpi.forEach(degreeStudent -> degreeStudentService.save(degreeStudent));
        List<DegreeStudent> degreeStudentsLicBio = fakeData.getDegreeStudentsOf(degreeLicBio, studentsLicBio);
        degreeStudentsLicBio.forEach(degreeStudent -> degreeStudentService.save(degreeStudent));
        List<DegreeStudent> degreeStudentsArqNaval = fakeData.getDegreeStudentsOf(degreeArqNaval, studentsArqNaval);
        degreeStudentsArqNaval.forEach(degreeStudent -> degreeStudentService.save(degreeStudent));

        // Create Surveys for active academicOffer
        fakeData.surveysFor(degreeStudentsTpi).forEach(survey -> surveyService.save(survey));
        fakeData.surveysFor(degreeStudentsLicBio).forEach(survey -> surveyService.save(survey));
        fakeData.surveysFor(degreeStudentsArqNaval).forEach(survey -> surveyService.save(survey));
        
        // Create StudentSurveys for ArqNaval
        List<String> codesOfArqNaval = surveyService.findCodes(3l);
        codesOfArqNaval.forEach(code -> {
        	StudentSurvey studentSurvey = fakeData.createStudentSurvey(code, surveyService.getSurveyByCode(code));
        	surveyService.completeSurvey(studentSurvey);
        });
        
	}
	
	
	
}
