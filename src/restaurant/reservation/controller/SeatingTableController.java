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
import restaurant.reservation.dao.SeatingTableDAO;
import restaurant.reservation.exception.AppException;
import restaurant.reservation.model.SeatingTable;

@Path("/seating")
@Api(tags = {"/seating"})
public class SeatingTableController {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Find All Tables", notes = "Finds all tables in the database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public List<SeatingTable> getAll() {
		List<SeatingTable> seatingTable = null;

		SeatingTableDAO dao = new SeatingTableDAO();
		try {
			seatingTable = dao.getAllTables();
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);

		}

		return seatingTable;
	}

	@GET
	@Path("/{table_id}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Find one table", notes = "Finds one table in the database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public SeatingTable getById(@PathParam("table_id") int tableId) {

		SeatingTable seatingTable;

		SeatingTableDAO dao = new SeatingTableDAO();
		try {
			seatingTable = dao.getOneTable(tableId);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);

		}
		if (seatingTable == null) {
			throw new WebApplicationException(Status.NO_CONTENT);

		}

		return seatingTable;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Create a table reservation", notes = "Creates seating table reservation in database")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public SeatingTable insertTable(SeatingTable seatingTable) {

		SeatingTableDAO dao = new SeatingTableDAO();
		try {
			seatingTable = dao.insert(seatingTable);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);

		}

		// TODO
		// NEED EXCEPTION
		return seatingTable;
	}
	
	@PUT
	@Path("/{table_id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Update seating table status", notes = "Update seating table status in database")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public SeatingTable updateTable(@PathParam("table_id") int tableId, SeatingTable seatingTable){
		
		SeatingTableDAO dao = new SeatingTableDAO();
		
		try {
			seatingTable = dao.update(tableId, seatingTable);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);

		}
		
		
		return seatingTable;
	}
	
	@DELETE
	@Path("/{table_id}")
	@ApiOperation(value = "Delete seating table", notes = "Delete seating table in database")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public void deleteTable(@PathParam("table_id") int table_id){
		
		SeatingTableDAO dao = new SeatingTableDAO();
		try {
			dao.delete(table_id);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);

		}
	}

}
