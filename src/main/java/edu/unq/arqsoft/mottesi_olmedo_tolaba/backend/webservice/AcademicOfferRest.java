package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.webservice;

import java.util.List;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.AcademicOfferDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.AcademicOffer;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Offer;
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
	@Path("/{id}")
	public Response find(@Context HttpServletRequest request, @PathParam("id") final Long id) {
		return super.find(id);
	}
	
	@GET
	@Path("/first")
	public Response getFirst(@Context HttpServletRequest request) {
		try {
			AcademicOfferDTO dto = this.academicOfferService.getFirstAcademicOfferDTO();
			return responseGenerator.buildSuccessResponse(dto);
		} catch (Exception e) {
			return responseGenerator.buildErrorResponse(e);
		}
	}
	
	@GET
	@Path("/offersFromFirst")
	public Response offers(@Context HttpServletRequest request) {
		try {
			List<Offer> offers = this.academicOfferService.find((long) 1).getOffers();
			return responseGenerator.buildSuccessResponse(offers);
		} catch (Exception e) {
			return responseGenerator.buildErrorResponse(e);
		}
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
