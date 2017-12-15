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

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.DegreeStudentDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.DegreeStudent;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service.DegreeStudentService;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service.GenericService;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.utils.ResponseGenerator;

@Service
@Produces("application/json")
@Consumes("application/json")
@Path("/degree_students")
public class DegreeStudentRest  extends GenericRest<DegreeStudent> {

	@Autowired
	private ResponseGenerator responseGenerator;
	
	@Autowired
	private DegreeStudentService degreeStudentService;
	

	@Override
	public GenericService<DegreeStudent> getService() {
		return degreeStudentService;
	}
	
	@GET
	@Path("/{id}")
	public Response find(@Context HttpServletRequest request, @PathParam("id") final Long id) {
		try {
			DegreeStudentDTO dto = this.degreeStudentService.findByDTO(id);
			return responseGenerator.buildSuccessResponse(dto);
		} catch (Exception e) {
			return responseGenerator.buildErrorResponse(e);
		}
	}
	
	
	@GET
	public Response ok() {
		return responseGenerator.responseOK("OK");
	}
	
	@POST
	public Response create(@Context HttpServletRequest request, DegreeStudent user) {
		return super.create(user);
	}


	@PUT
	public Response update(@Context HttpServletRequest request, DegreeStudent user) {
		return super.update(user);
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@Context HttpServletRequest request, @PathParam("id") final Long id) {
		return super.delete(id);
	}

}
