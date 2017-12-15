package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.webservice;


import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.StudentSurveyDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.AcademicOffer;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service.AcademicOfferService;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service.GenericService;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.utils.ResponseGenerator;

@Service
@Produces("application/json")
@Consumes("application/json")
@Path("/academicOffers")
public class AcademicOfferRest  extends GenericRest<AcademicOffer> {

	@Autowired
	private ResponseGenerator responseGenerator;
	
	@Autowired
	private AcademicOfferService academicOfferService;
	

	@Override
	public GenericService<AcademicOffer> getService() {
		return academicOfferService;
	}

	@GET
	@Path("/all")
	public Response findAll() {
		return super.findAll();
	}
		
	@GET
	public Response ok() {
		return responseGenerator.responseOK("OK");
	}
	
	@POST
	public Response create(@Context HttpServletRequest request, AcademicOffer user) {
		return super.create(user);
	}


	@PUT
	public Response update(@Context HttpServletRequest request, AcademicOffer user) {
		return super.update(user);
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@Context HttpServletRequest request, @PathParam("id") final Long id) {
		return super.delete(id);
	}
	
	

}
