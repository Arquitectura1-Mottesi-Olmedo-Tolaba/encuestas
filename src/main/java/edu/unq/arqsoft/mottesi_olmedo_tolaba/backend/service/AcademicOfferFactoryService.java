package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import java.lang.reflect.Array;
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
	private StudentService studentService;
	
	@Autowired
	private SurveyService surveyService;

	@Autowired
	private DegreeService degreeService;

    @Autowired
    private DegreeStudentService degreeStudentService;


	@Transactional
	public void initialize() {

        // Create degrees
        FakeData fakeData = new FakeData();
		Degree degreeTPI = degreeService.save(fakeData.degreeTPI());
        Degree degreeLicBio = degreeService.save(fakeData.degreeLICBIO());

        // Create students
        List<Student> studentsTpi = fakeData.studentsTPI();
        studentsTpi.forEach(student -> studentService.save(student));
        List<Student> studentsLicBio = fakeData.studentsLicBio();
        studentsLicBio.forEach(student -> studentService.save(student));

        // Create degreeSturdents
        List<DegreeStudent> degreeStudentsTpi = fakeData.getDegreeStudentsOf(degreeTPI, studentsTpi);
        degreeStudentsTpi.forEach(degreeStudent -> degreeStudentService.save(degreeStudent));
        List<DegreeStudent> degreeStudentsLicBio = fakeData.getDegreeStudentsOf(degreeLicBio, studentsLicBio);
        degreeStudentsLicBio.forEach(degreeStudent -> degreeStudentService.save(degreeStudent));

        // Create Surveys for active academicOffer
        fakeData.surveysFor(degreeStudentsTpi).forEach(survey -> surveyService.save(survey));
        fakeData.surveysFor(degreeStudentsLicBio).forEach(survey -> surveyService.save(survey));
        
	}
	
	
	
}
