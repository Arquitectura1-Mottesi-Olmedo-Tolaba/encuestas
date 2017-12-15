package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.OptionCounterDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.StatisticDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.OptionCounter;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Statistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.AcademicOfferStatistics;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.StudentInformation;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.AcademicOffer;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class AcademicOfferStatisticsService {

	@Autowired
	private DegreeService degreeService;
	
	@Autowired
	private AcademicOfferService academicOfferService;
	
	@Autowired
	private DegreeStudentService degreeStudentService;
	
	@Autowired
	private SurveyService surveyService;
		
	@Transactional
	public AcademicOfferStatistics getAcademicOfferInformation(Long idDegree) {
		AcademicOffer academicOffer = this.getCurrentAcademicOfferFor(idDegree);
		String degreeName = this.getDegreeName(idDegree);
		StudentInformation studentInformation = new StudentInformation(this.studentsOf(idDegree), this.surveysCompletedOf(academicOffer.getId()));
		return new AcademicOfferStatistics(this.getStatisticsFor(academicOffer), academicOffer.getEndDate(), degreeName, studentInformation);
	}

	private List<StatisticDTO> getStatisticsFor(AcademicOffer academicOffer) {
		return academicOffer.getStatistics().stream()
                .map(statistic -> new StatisticDTO(statistic.getSubject(), this.getInfo(statistic.getOptionsCounter())))
                .collect(Collectors.toList());
	}

    private List<OptionCounterDTO> getInfo(List<OptionCounter> optionsCounter) {
        return optionsCounter.stream()
                .map(optionCounter -> new OptionCounterDTO(optionCounter.getDescription(), optionCounter.getCapacity(), optionCounter.getAmount()))
                .collect(Collectors.toList());
    }


    private AcademicOffer getCurrentAcademicOfferFor(Long idDegree) {
		return this.academicOfferService.getCurrentAcademicOfferFor(idDegree);
	}

	private String getDegreeName(Long idDegree) {
		return this.degreeService.getDegreeName(idDegree);
	}

	private Integer surveysCompletedOf(Long academicOfferId) {
		return this.surveyService.surveysCompletedOf(academicOfferId);
	}

	private Integer studentsOf(Long idDegree) {
		return this.degreeStudentService.studentsForDegree(idDegree);
	}
	
}
