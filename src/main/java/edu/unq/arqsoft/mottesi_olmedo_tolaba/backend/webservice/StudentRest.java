package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.webservice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Student;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service.GenericService;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service.StudentService;

@Service
@Produces("application/json")
@Consumes("application/json")
@Path("/students")
public class StudentRest extends GenericRest<Student> {

	@Autowired
	private StudentService studentService;

	@Override
	public GenericService<Student> getService() {
		return studentService;
	}
	
	@GET
	@Path("/all")
	public Response findAll() {
		return super.findAll();
	}


	
	

}
