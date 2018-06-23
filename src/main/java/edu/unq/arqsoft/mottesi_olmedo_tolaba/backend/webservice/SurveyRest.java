package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.webservice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.StreamingOutput;

import org.hsqldb.util.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.StudentSurveyDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.StudentSurvey;
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
	@Path("/{code}")
	public Response getSurveyByCode(@Context HttpServletRequest request, @PathParam("code") final String code) {
		try {
			StudentSurveyDTO dto = surveyService.getSurveyByCode(code);
			return this.getResponseGenerator().buildSuccessResponse(dto);
		} catch (Exception e) {
			return this.getResponseGenerator().buildErrorResponse(
					new RuntimeException(e.getMessage())
				);
		}
	
	}
	
	@GET
	@Path("/verify/{code}")
	public Response verifyCode(@Context HttpServletRequest request, @PathParam("code") final String code) {
		return surveyService.verifyCode(code) ? 
				this.getResponseGenerator().buildSuccessResponse(true) 
				: this.getResponseGenerator().buildErrorResponse(new RuntimeException("Codigo inexistente"));
	}
	
	@POST
	public Response completeSurvey(@Context HttpServletRequest request, StudentSurvey studentSurvey) {
		try {
			surveyService.completeSurvey(studentSurvey);
			return this.getResponseGenerator().buildResponse(Status.OK);
		} catch (Exception e) {
			return this.getResponseGenerator().buildErrorResponse(new RuntimeException(e.getMessage()));
		}
	}
	
	@GET
	@Path("/codes/{idDegree}")
	public Response findCodes(@Context HttpServletRequest request, @PathParam("idDegree") final Long idDegree) {
		return this.getResponseGenerator().buildSuccessResponse(
				this.surveyService.findCodes(idDegree));
	}
	
	@GET
	@Path("/codesCSV")
	@Produces({"text/csv"})
	public Response retrieveCSV(@Context HttpServletRequest request) throws FileNotFoundException {
		File file = new File("codes.csv");
        PrintWriter pw = new PrintWriter(file);
        StringBuilder sb = new StringBuilder();
        sb.append("codes");        
        sb.append('\n');
        List <String> codes = this.surveyService.findCodes(new Long(1));
        for (String elem: codes) {
        	sb.append(elem);
        	sb.append('\n');
        }
        pw.write(sb.toString());
        pw.close();
        
        ResponseBuilder response = Response.ok((Object) file);
        //response("application/x-msexcel"); 
        response.header("Content-Disposition","attachment; filename=codes.csv");      
        return response.build();
        
        
	}
	
	
		
	@GET
	@Path("/byUser/{userId}")
	public Response byUser(@Context HttpServletRequest request, @PathParam("userId") final Long userId) {
		return this.getResponseGenerator().buildSuccessResponse(this.surveyService.findByUser(userId));
	}
	
	
	
	
	
}
