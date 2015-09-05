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
import restaurant.reservation.dao.ReservationDAO;
import restaurant.reservation.exception.AppException;
import restaurant.reservation.model.Reservation;

@Path("/reservations")
@Api(tags = {"/reservations"})
public class ReservationController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Find all reservations", notes = "Finds all reservations in the database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public List<Reservation> getAll() {
		List<Reservation> reservations = null;

		ReservationDAO dao = new ReservationDAO();
		try {
			reservations = dao.getAllReservation();
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}

		return reservations;
	}

	@GET
	@Path("/{r_id}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Find one reservation", notes = "Finds one reservation in the database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public Reservation getById(@PathParam("r_id") int rId) {

		Reservation reservation;

		
		try {
			ReservationDAO dao = new ReservationDAO();
			reservation = dao.getOneReservation(rId);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		if (reservation == null) {
			throw new WebApplicationException(Status.NO_CONTENT);
		}

		return reservation;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Create a reservation", notes = "Creates a reservation in the database")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public Reservation insertReservation(Reservation reservation) {

		ReservationDAO dao = new ReservationDAO();
		try {
			reservation = dao.insert(reservation);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}

		// TODO
		// NEED EXCEPTION
		return reservation;
	}
	
	@PUT
	@Path("/{r_id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Update reservation", notes = "Update reservation in database")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public Reservation updateReservation(@PathParam("r_id") int rId, Reservation reservation){
		
		ReservationDAO dao = new ReservationDAO();
		
		try {
			reservation = dao.update(rId, reservation);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		
		
		return reservation;
	}
	
	@DELETE
	@Path("/{r_id}")
	@ApiOperation(value = "Delete reservation", notes = "Delete reservation in database")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public void deleteReservation(@PathParam("r_id") int r_id){
		
		ReservationDAO dao = new ReservationDAO();
		try {
			dao.delete(r_id);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
	}

	
}
