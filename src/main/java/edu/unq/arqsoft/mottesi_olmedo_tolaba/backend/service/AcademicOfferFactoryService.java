package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.AcademicOffer;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Course;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Offer;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Period;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Professor;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Student;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Subject;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Survey;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Timeline;
@Transactional
@Service
public class AcademicOfferFactoryService {

	@Autowired
	private AcademicOfferService academicOfferService;
		
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private PeriodService periodService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private TimelineService timelineService;
	
	@Autowired
	private SurveyService surveyService;

	public Offer createOrgaOffer(Subject subject){
		Professor mara = new Professor("Mara Dalponte");
		Timeline lunes = new Timeline("Lunes","18:00","22:00");
		Timeline miercoles = new Timeline("Miercoles","18:00","22:00");
		Course cursada = new Course("Comision 1", mara, Arrays.asList(lunes, miercoles));

		return new Offer(subject, Arrays.asList(cursada));
	}

	public Offer createIntroOffer(Subject subject){
		Professor eduardo = new Professor("Eduardo Bonelli");
		Timeline lunes = new Timeline("Lunes","18:00","22:00");
		Timeline miercoles = new Timeline("Miercoles","18:00","22:00");
		Course cursada = new Course("Comision 1", eduardo, Arrays.asList(lunes, miercoles));

		return new Offer(subject, Arrays.asList(cursada));
	}

	public Offer createMatematicaOffer(Subject subject){
		Professor jano = new Professor("Jano");
		Professor hortensia = new Professor("Hortensia");

		Timeline lunes = new Timeline("Lunes","18:00","22:00");
		Timeline miercoles = new Timeline("Miercoles","18:00","22:00");
		Timeline lunes1 = new Timeline("Lunes","18:00","22:00");
		Timeline miercoles1 = new Timeline("Miercoles","18:00","22:00");

		Course cursada = new Course("Comision 1", hortensia, Arrays.asList(lunes, miercoles));
		Course cursada1 = new Course("Comision 2", jano, Arrays.asList(lunes1, miercoles1));

		return new Offer(subject, Arrays.asList(cursada, cursada1));
	}
	
	@Transactional
	public AcademicOffer initialize(String nameDegree, List<Subject> subjects) {

		// TODO: SET DEGREE, STUDENT ??? EL NAME ES EL NOMBRE DEL DEGREE ...
		Period period = new Period(2017, 1);
				
		Student student = new Student();
		student.setName("Homero");
		student.setLastName("Simpson");
		studentService.save(student);

		Offer offerMatematica = createMatematicaOffer(subjects.get(0));
		Offer offerOrga = createOrgaOffer(subjects.get(1));
		Offer offerIntro = createIntroOffer(subjects.get(2));

		AcademicOffer academicOffer =
				new AcademicOffer(Arrays.asList(offerMatematica, offerOrga, offerIntro), period, "2017-01-01", true);

		academicOfferService.save(academicOffer);
		
		Survey survey = surveyService.createSurvey(student,academicOffer);
				
		System.out.println("---------------------");
		System.out.println("---------------------");
		System.out.println("---------------------");
		System.out.println("---------------------");
		System.out.println("---------------------");
		System.out.println(survey.getCode());
		System.out.println("---------------------");
		System.out.println("---------------------");
		System.out.println("---------------------");
		System.out.println("---------------------");
		System.out.println("---------------------");
		
		return academicOffer;
	}
	
	
	
}
