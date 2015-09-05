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
import restaurant.reservation.dao.CustomerDAO;
import restaurant.reservation.exception.AppException;
import restaurant.reservation.model.Customer;

@Path("/customers")
@Api(tags = { "/customers" })
public class CustomerController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Find all customers", notes = "Find all customers in database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Found"),
			@ApiResponse(code = 400, message = "Internal Server Error") })
	public List<Customer> getAll() {
		List<Customer> customers = null;

		try {
			CustomerDAO dao = new CustomerDAO();
			customers = dao.getAllCustomers();
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}

		return customers;
	}

	@GET
	@Path("/{customer_id}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Find one customer", notes = "Find a customer in database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Found"),
			@ApiResponse(code = 400, message = "Internal Server Error") })
	public Customer getById(@PathParam("customer_id") int customerId) {

		Customer customer;

		try {
			CustomerDAO dao = new CustomerDAO();
			customer = dao.getOneCustomer(customerId);
			
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		
		if (customer == null) {
				throw new WebApplicationException(Status.NO_CONTENT);
			}
		
		return customer;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Create a customer", notes = "Create a customer into database")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Inserted"),
			@ApiResponse(code = 400, message = "Internal Server Error") })
	public Customer insertCustomer(Customer customer) {

		CustomerDAO dao = new CustomerDAO();

		try {
			customer = dao.insert(customer);
		} catch (AppException e) {

			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}

		return customer;
	}

	@PUT
	@Path("/{customer_id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Update customer", notes = "Update customer in database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Internal Server Error") })
	public Customer updateCustomer(@PathParam("customer_id") int customerId, Customer customer) {

		CustomerDAO dao = new CustomerDAO();

		try {
			customer = dao.update(customerId, customer);
		} catch (AppException e) {

			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}

		return customer;
	}

	@DELETE
	@Path("/{c_id}")
	@ApiOperation(value = "Delete customer", notes = "Delete customer in database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Internal Server Error") })
	public void deleteCustomer(@PathParam("c_id") int c_id) {

		CustomerDAO dao = new CustomerDAO();
		try {
			dao.delete(c_id);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
	}
}
