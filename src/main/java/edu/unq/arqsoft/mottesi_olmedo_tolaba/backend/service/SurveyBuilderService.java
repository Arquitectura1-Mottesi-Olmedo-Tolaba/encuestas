package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.AcademicOffer;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Degree;
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
		
		
	}
	
	
	
}
