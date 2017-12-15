package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import java.util.Arrays;
import java.util.List;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.fakeData.FakeData;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        
        // Create director
        Director director = new Director(Arrays.asList(degreeTPI, degreeLicBio),new UserCredential("director@gmail.com", "director"));
		directorService.save(director);

        // Create students
        List<Student> studentsTpi = fakeData.studentsTPI();
        studentsTpi.forEach(student -> studentService.save(student));
        List<Student> studentsLicBio = fakeData.studentsLicBio();
        studentsLicBio.forEach(student -> studentService.save(student));

        // Create degreeStudents
        List<DegreeStudent> degreeStudentsTpi = fakeData.getDegreeStudentsOf(degreeTPI, studentsTpi);
        degreeStudentsTpi.forEach(degreeStudent -> degreeStudentService.save(degreeStudent));
        List<DegreeStudent> degreeStudentsLicBio = fakeData.getDegreeStudentsOf(degreeLicBio, studentsLicBio);
        degreeStudentsLicBio.forEach(degreeStudent -> degreeStudentService.save(degreeStudent));

        // Create Surveys for active academicOffer
        fakeData.surveysFor(degreeStudentsTpi).forEach(survey -> surveyService.save(survey));
        fakeData.surveysFor(degreeStudentsLicBio).forEach(survey -> surveyService.save(survey));
        
	}
	
	
	
}
