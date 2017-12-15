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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Student;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service.GenericService;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service.StudentService;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.utils.ResponseGenerator;

@Service
@Produces("application/json")
@Consumes("application/json")
@Path("/students")
public class StudentRest  extends GenericRest<Student> {

	@Autowired
	private StudentService studentService;

	@Override
	public GenericService<Student> getService() {
		return studentService;
	}


	@GET
	@Path("/verify/{code}")
	public Response verifyCode(@Context HttpServletRequest request, @PathParam("code") final String code) {
		return this.getResponseGenerator().buildSuccessResponse(studentService.verifyCode(code));
	}

	@GET
    @Path("/getByCode/{code}")
    public Response getByCode(@Context HttpServletRequest request, @PathParam("code") final String code) {
        return this.getResponseGenerator().buildSuccessResponse(studentService.getSurveyByCode(code));
    }

}
