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
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.StatisticDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Statistic;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service.GenericService;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service.StatisticService;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.utils.ResponseGenerator;

@Service
@Produces("application/json")
@Consumes("application/json")
@Path("/statistics")
public class StatisticRest  extends GenericRest<Statistic> {

	@Autowired
	private ResponseGenerator responseGenerator;
	
	@Autowired
	private StatisticService statisticService;
	

	@Override
	public GenericService<Statistic> getService() {
		return statisticService;
	}
//
//	@GET
//	@Path("/findByAcademicOffer/{id}")
//	public Response findByAcademicOffer(@Context HttpServletRequest request, @PathParam("id") final Long id) {
//		try {
//			List<StatisticDTO> dtos = this.statisticService.findDTOByAcademicOffer(id);
//			return responseGenerator.buildSuccessResponse(dtos);
//		} 
//		catch (RuntimeException e) {
//            return responseGenerator.buildCustomErrorResponse(e.getMessage(), Status.BAD_REQUEST);
//        }
//		catch (Exception e) {
//			return responseGenerator.buildErrorResponse(e);
//		}
//	}
	
//	@GET
//	@Path("/all")
//	public Response findAll() {
//		try {
//			List<StatisticDTO> dtos = this.statisticService.findAllDTO();
//			return responseGenerator.buildSuccessResponse(dtos);
//		} catch (Exception e) {
//			return responseGenerator.buildErrorResponse(e);
//		}
//	}

//	
//	@GET
//	@Path("/{id}")
//	public Response find(@Context HttpServletRequest request, @PathParam("id") final Long id) {
//		try {
//			StatisticDTO dto = this.statisticService.findDTO(id);
//			return responseGenerator.buildSuccessResponse(dto);
//		} catch (Exception e) {
//			return responseGenerator.buildErrorResponse(e);
//		}
//	}
//	
	@GET
	public Response ok() {
		return responseGenerator.responseOK("OK");
	}
	
	@POST
	public Response create(@Context HttpServletRequest request, Statistic user) {
		return super.create(user);
	}


	@PUT
	public Response update(@Context HttpServletRequest request, Statistic user) {
		return super.update(user);
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@Context HttpServletRequest request, @PathParam("id") final Long id) {
		return super.delete(id);
	}

}
