package restaurant.reservation.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import restaurant.reservation.dao.OwnerDAO;
import restaurant.reservation.exception.AppException;
import restaurant.reservation.model.Owner;

@Path("/owners")
@Api(tags = { "/owners" })
public class OwnerController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Find owner", notes = "Find owner in the database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public List<Owner> getAll() {
		List<Owner> owners = null;

		OwnerDAO dao = new OwnerDAO();
		try {
			owners = dao.getAllOwners();
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}

		return owners;
	}

	@GET
	@Path("/{owner_id}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Find One", notes = "Finds owner in the database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public Owner getById(@PathParam("owner_id") int ownerId) {

		Owner owner;

		OwnerDAO dao = new OwnerDAO();
		try {
			owner = dao.getOneOwner(ownerId);

		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		if (owner == null) {
			throw new WebApplicationException(Status.NO_CONTENT);

		}

		return owner;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Create owner", notes = "Create owner in the database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public Owner insertOwner(Owner owner) {

		OwnerDAO dao = new OwnerDAO();
		try {
			owner = dao.insert(owner);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);

		}

		return owner;
	}

	@PUT
	@Path("/{owner_id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Update owner", notes = "Update owner in the database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public Owner updateOwner(@PathParam("owner_id") int ownerId, Owner owner) {

		OwnerDAO dao = new OwnerDAO();

		try {
			owner = dao.update(ownerId, owner);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);

		}

		return owner;
	}

	@DELETE
	@Path("/{o_id}")
	@ApiOperation(value = "Delete owner", notes = "Delete owner in the database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public void deleteOwner(@PathParam("o_id") int o_id) {

		OwnerDAO dao = new OwnerDAO();
		try {
			dao.delete(o_id);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
				throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		
			
		}
	}

}
