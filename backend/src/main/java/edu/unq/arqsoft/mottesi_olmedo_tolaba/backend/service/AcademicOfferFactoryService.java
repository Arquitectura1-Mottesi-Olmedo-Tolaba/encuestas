package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.AcademicOffer;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Course;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Offer;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Period;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Professor;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Student;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Subject;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Timeline;
@Transactional
@Service
public class AcademicOfferFactoryService {

	@Autowired
	private AcademicOfferService academicOfferService;
	
	@Autowired
	private OfferService offerService;
	
	@Autowired
	private SubjectService subjectService;
	
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
	
	@Transactional
	public Offer createOrgaOffer(){
		Offer offer = new Offer();
		Course cursada = new Course();
		Professor hortensia = new Professor("Hortensia");
		hortensia = professorService.save(hortensia);
		cursada.setProfessor(hortensia);
		
		Timeline lunes = new Timeline("Lunes","18:00","22:00");
		Timeline miercoles = new Timeline("Miercoles","18:00","22:00");
		lunes = timelineService.save(lunes);
		miercoles = timelineService.save(miercoles);
		cursada.setTimelines(Arrays.asList(lunes, miercoles));

		courseService.save(cursada);
		Subject subject = new Subject("Organizacion de computadoras");
		subjectService.save(subject);
		offer.setSubject(subject);
		offer.setCourses(Arrays.asList(cursada));
		offer = offerService.save(offer);
		return offer;
	}
	
	@Transactional
	public Offer createIntroOffer(){
		Offer offer = new Offer();
		Course cursada = new Course();
		Professor hortensia = new Professor("Hortensia");
		hortensia = professorService.save(hortensia);
		cursada.setProfessor(hortensia);
		
		Timeline lunes = new Timeline("Lunes","18:00","22:00");
		Timeline miercoles = new Timeline("Miercoles","18:00","22:00");
		lunes = timelineService.save(lunes);
		miercoles = timelineService.save(miercoles);
		cursada.setTimelines(Arrays.asList(lunes, miercoles));

		courseService.save(cursada);
		Subject subject = new Subject("introduccion a la programacion");
		subjectService.save(subject);
		offer.setSubject(subject);
		offer.setCourses(Arrays.asList(cursada));
		offer = offerService.save(offer);
		return offer;
	}
	
	@Transactional
	public Offer createMatematicaOffer(){
		Offer offer = new Offer();
		Course cursada = new Course();
		Course cursada2 = new Course();
		
		Timeline lunes = new Timeline("Lunes","18:00","22:00");
		Timeline miercoles = new Timeline("Miercoles","18:00","22:00");
		lunes = timelineService.save(lunes);
		miercoles = timelineService.save(miercoles);
		
		Timeline lunes1 = new Timeline("Lunes","18:00","22:00");
		Timeline miercoles1 = new Timeline("Miercoles","18:00","22:00");
		lunes1 = timelineService.save(lunes);
		miercoles1 = timelineService.save(miercoles);
		
		Professor hortensia = new Professor("Hortensia");
		hortensia = professorService.save(hortensia);
		Professor jano = new Professor("Jano");
		jano = professorService.save(jano);
		
		cursada.setProfessor(hortensia);
		cursada.setTimelines(Arrays.asList(lunes, miercoles));
		
		cursada2.setProfessor(jano);
		cursada2.setTimelines(Arrays.asList(lunes1, miercoles1));

		cursada = courseService.save(cursada);
		cursada2 = courseService.save(cursada2);
		
		Subject subject = new Subject("Matematica 1");
		subjectService.save(subject);
		offer.setSubject(subject);
		offer.setCourses(Arrays.asList(cursada,cursada2));
		offer = offerService.save(offer);
		return offer;
	}
	
	
	public void initialize() {
		
		AcademicOffer academicOffer = new AcademicOffer();
		academicOffer.setName("Tecnicatura Universitaria en Programación Informática");
		Integer quarter = 1;
		Period period = new Period(2017,quarter);
		periodService.save(period);
		
		// TODO: SET DEGREE, STUDENT ???
		Student student = new Student();
		student.setName("Homero");
		student.setLastName("Simpson");
		studentService.save(student);
		// MATERIAS APROBADAS ???
		academicOffer.setPeriod(period);
		academicOffer = academicOfferService.save(academicOffer);
		
		
		
		Offer offerMatematica = createMatematicaOffer();
		Offer offerIntro = createIntroOffer();
		Offer offerOrga = createOrgaOffer();
		
		academicOffer.setOffers(Arrays.asList(offerMatematica,offerIntro, offerOrga));
		academicOffer = academicOfferService.save(academicOffer);
		System.out.println("------------------");
		System.out.println("------------------");
		System.out.println(academicOffer);
		System.out.println("------------------");
		System.out.println("------------------");
		
		
	}
	
	
	
}
