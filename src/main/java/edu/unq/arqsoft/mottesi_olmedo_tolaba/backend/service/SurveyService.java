package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.StudentOfferDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.StudentSurveyDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.SurveyDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.SurveyMatchDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.AcademicOffer;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Course;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Offer;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Option;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Period;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Student;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Survey;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.SurveyMatch;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.SurveyRepository;


@Transactional
@Service
public class SurveyService extends GenericService<Survey> {

	@Autowired
	private SurveyRepository repository;
	
	@Autowired
	private DegreeService degreeService;
		
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private OfferService offerService;
	
	@Autowired
	private SurveyMatchService surveyMatchService;
	
	@Autowired
	private StatisticService statisticService;
	
	public SurveyService() {}
	
	public SurveyService(SurveyRepository repo) {
		this.setRepository(repo);
	}

	public SurveyRepository getRepository() {
		return repository;
	}

	public void setRepository(SurveyRepository repository) {
		this.repository = repository;
	}
	
	@Transactional
	public Survey update(Survey model) {
		return super.update(model);
	}
	
	@Transactional
	public Survey save(Survey model) {
		return super.save(model);
	}
	
	public Survey newSurvey(List<SurveyMatch> surveyMatches) {
		Survey elem = new Survey();
		elem.setSurveyMatches(surveyMatches);
		return this.save(elem);
	}

	public Survey updateSurveyFromDTO(SurveyDTO surveyDTO) {
		
		Survey survey = this.getByCode(surveyDTO.code);
		for (SurveyMatchDTO smDTO : surveyDTO.surveyMatches){
			SurveyMatch sm = surveyMatchService.createSurveyMatchFromDTO(smDTO);
			survey.addSurveyMatch(sm);
			
			//Podria ser el mismo survey pero como no fue persistido ...
			statisticService.updateFromSurvey(smDTO, survey.getAcademicOffer());
		}		
		survey.setMessage(surveyDTO.message);
		
		return this.update(survey);
	}

	public Survey createSurvey(Student student, AcademicOffer academicOffer) {
		Survey survey = new Survey(student,academicOffer);
		return this.save(survey);
	}
	
	public Survey getByCode(String code) {
		Survey survey = this.repository.getByCode(code);
		return survey;
	}

	public StudentSurveyDTO getDTO(AcademicOffer academicOffer) {
		StudentSurveyDTO academicOfferDTO = new StudentSurveyDTO();
		academicOfferDTO.setName("TPI");

		//academicOfferDTO.setEndDate(academicOffer.getEndDate());


		
		//Ver como ponderar elecciones pasadas...
		//academicOfferDTO.setOffers(offerService.getOffersDTO(academicOffer.getOffers()));
		return academicOfferDTO;
	}


	public Integer surveysCompletedOf(Long academicOfferId) {
		return this.repository.surveysCompletedOf(academicOfferId);
	}

    public Boolean verifyCode(String code) {
        return this.getRepository().verifyCode(code);
    }

    public StudentSurveyDTO getSurveyByCode(String code) {
        Survey survey = this.getByCode(code);
        String degreeName = degreeService.getDegreeNameForAcademicOffer(survey.getAcademicOffer().getId());
        Period period = survey.getAcademicOffer().getPeriod();
		List<StudentOfferDTO> studentOfferDTOs = this.createStudentOfferDTOs(survey);
        return new StudentSurveyDTO(degreeName, period, survey.getStudent(), studentOfferDTOs);
    }

	private List<StudentOfferDTO> createStudentOfferDTOs(Survey survey) {
		return survey.getAcademicOffer().getOffers().stream()
				.map(offer -> this.createStudentOfferDTO(offer, survey))
                .collect(Collectors.toList());
	}

	private StudentOfferDTO createStudentOfferDTO(Offer offer, Survey survey){
	    List<Option> options = this.getOptions(offer.getCourses());
        Option selectedOption = survey.getSurveyMatches().stream()
                .filter(surveyMatch -> surveyMatch.getSubject().equals(offer.getSubject()))
                .findFirst()
                .orElse(new SurveyMatch(this.getDefaultOption(options), null))
                .getOption();
	    return new StudentOfferDTO(offer.getSubject(), offer.getCourses(), selectedOption, options);
    }

    private Option getDefaultOption(List<Option> options) {
        return options.stream()
                .filter(option -> option.getDescription().equals("Todavia no la voy a cursar"))
                .findFirst().orElseThrow(() -> new RuntimeException("Falta la opcion default"));
    }

    private List<Option> getOptions(List<Course> courses) {
        List<Option> options = new ArrayList<>(Arrays.asList(
                new Option("Todavia no la voy a cursar"),
                new Option("Ya la curse"),
                new Option("Quisiera pero...")));
        courses.forEach(course -> options.add(new Option(course.getName())));
        return options;
    }

	public List<String> findCodes() {
		return this.repository.findCodes();
	}

}
