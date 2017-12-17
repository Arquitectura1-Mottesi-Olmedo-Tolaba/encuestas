package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Survey;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service.GenericService;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service.SurveyService;

@Service
@Produces("application/json")
@Consumes("application/json")
@Path("/surveys")
public class SurveyRest  extends GenericRest<Survey> {

	@Autowired
	private SurveyService surveyService;
	

	@Override
	public GenericService<Survey> getService() {
		return surveyService;
	}

	@GET
	@Path("/codes")
	public Response findCodes() {
		return this.getResponseGenerator().buildSuccessResponse(this.surveyService.findCodes());
	}

}
