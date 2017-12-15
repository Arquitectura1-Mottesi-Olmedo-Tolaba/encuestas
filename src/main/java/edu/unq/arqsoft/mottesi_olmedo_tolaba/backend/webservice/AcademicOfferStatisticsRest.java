package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.webservice;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service.AcademicOfferStatisticsService;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.utils.ResponseGenerator;

@Service
@Produces("application/json")
@Consumes("application/json")
@Path("/information")
public class AcademicOfferStatisticsRest {

	@Autowired
	private AcademicOfferStatisticsService academicOfferStatisticsService;

	@Autowired
	private ResponseGenerator responseGenerator;

	@GET
	@Path("/academicOfferInformation/{idDegree}")
	public Response getAcademicOfferInformation(@Context HttpServletRequest request,
			@PathParam("idDegree") final Long idDegree) {
		return this.responseGenerator
				.buildSuccessResponse(academicOfferStatisticsService.getAcademicOfferInformation(idDegree));
	}

}
