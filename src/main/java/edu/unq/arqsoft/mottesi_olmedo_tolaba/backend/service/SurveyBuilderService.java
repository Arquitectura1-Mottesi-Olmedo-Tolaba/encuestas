package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.AcademicOffer;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Course;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Degree;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Offer;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.OptionCounter;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Statistic;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Student;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Survey;

@Transactional
@Service
public class SurveyBuilderService {

	
	@Autowired
	private DegreeService degreeService;
	
	@Autowired
	private DegreeStudentService degreeStudentService;
	
	@Autowired
	private SurveyService surveyService;
	
	@Autowired
	private StatisticService statisticService;
	
	/*	
	TODO: MANEJO DE EXCEPCIONES ...
	*/
	
	@Transactional
	public void sarasa(Long idDegree, AcademicOffer academicOffer){
		//Obtiene degree y le agrega esa academic offer, actualiza degree ,
		Degree degree = degreeService.find(idDegree);
		degree.addAcademicOffer(academicOffer);
		degreeService.save(degree);
		
		//En degreeStudentService busca los estudiantes del degree
		List<Student> studentsOfDegree = degreeStudentService.searchStudentForDegree(idDegree);
		
		//Creo la survey con esa academicOffer y student
		for (Student student : studentsOfDegree){
			surveyService.save(new Survey(student, academicOffer));
		}
		
		//Creo estadisticas vacias
		for (Offer offer: academicOffer.getOffers()){
			List<OptionCounter> options = new ArrayList<OptionCounter>();
			for (Course course : offer.getCourses()){
				options.add(new OptionCounter(course.getName(),0,0));
			}
			statisticService.save(new Statistic(offer.getSubject(),options,academicOffer));
		}
		
	}
	
	
	
}
