package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.webservice;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.DirectorDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Director;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.UserCredential;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service.DirectorService;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service.GenericService;

@Service
@Produces("application/json")
@Consumes("application/json")
@Path("/directors")
public class DirectorRest extends GenericRest<Director> {

	@Autowired
	private DirectorService directorService;

	@Override
	public GenericService<Director> getService() {
		return directorService;
	}

	@GET
	@Path("/degreesFor/{id}")
	public Response find(@Context HttpServletRequest request, @PathParam("id") final Long directorID) {
		try {
			Director director = directorService.find(directorID);
			return this.getResponseGenerator().buildSuccessResponse(
					new DirectorDTO(director));
		} catch (Exception e) {
			return this.getResponseGenerator().buildErrorResponse(
					new RuntimeException(e.getMessage())
				);
		}
	}

	@POST
	@Path("/login")
	public Response login(@Context HttpServletRequest request, UserCredential credential) {
		Director director = this.directorService.findDirector(credential);
		if (director == null) {
			return this.getResponseGenerator().buildErrorResponse(new RuntimeException("Director inexistente"));
		}
		return this.getResponseGenerator().buildSuccessResponse(director.getId());
	}

}
