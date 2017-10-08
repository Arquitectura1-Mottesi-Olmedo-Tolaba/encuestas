package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Service;


@Service
@Produces("application/json")
@Consumes("application/json")
@Path("/brands")
public class BrandRest {
/*
	@Autowired
	private ResponseGenerator responseGenerator;
	
	@Autowired
	public BrandService brandService;

	@Override
	public GenericService<Brand> getService() {
		return brandService;
	}

	@GET
	@Path("/all")
	public Response findAll() {
		return super.findAll();
	}

	@GET
	@Path("/{id}")
	public Response find(@PathParam("id") final Long id) {
		return super.find(id);
	}
	
	@GET
	public Response ok() {
		return responseGenerator.responseOK("OK");
	}
	
	@GET
	@Path("/find-by-page")
	public Response findByPage(@QueryParam("pageNumber") Integer pageNumber,
			@QueryParam("pageSize") Integer pageSize) {
		return super.findByPage(pageNumber, pageSize);
	}
	
	@POST
	public Response create(@Context HttpServletRequest request,Brand brand) {
		return super.create(brand);
	}

	@PUT
	public Response update(@Context HttpServletRequest request,
			@PathParam("id") final Long id, Brand brand) {
		Brand originalBrand = this.brandService.find(id);
		originalBrand.setName(brand.getName());
		return super.update(originalBrand);
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") final Long id) {
		return super.delete(id);
	}
*/
}
