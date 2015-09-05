package restaurant.reservation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restaurant.reservation.exception.AppException;
import restaurant.reservation.model.Customer;
import restaurant.reservation.util.DatabaseUtils;

public class CustomerDAO {

	public List<Customer> getAllCustomers() throws AppException {

		List<Customer> customers = new ArrayList<Customer>();

		Connection conn = DatabaseUtils.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("SELECT * FROM customer");
			rs = ps.executeQuery();

			while (rs.next()) {
				Customer customer = new Customer();
				customer.setC_id(rs.getInt(1));
				customer.setC_name(rs.getString(2));
				customer.setC_phone(rs.getString(3));
				customer.setC_email(rs.getString(4));
				customer.setC_address(rs.getString(5));

				customers.add(customer);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		} finally {
			DatabaseUtils.closeResource(ps, rs, conn);
		}

		return customers;
	}

	public Customer getOneCustomer(int c_id) throws AppException {

		Customer customer = null;

		Connection conn = DatabaseUtils.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("SELECT * FROM customer WHERE c_id = ?");
			ps.setInt(1, c_id);
			rs = ps.executeQuery();

			while (rs.next()) {
				customer = new Customer();
				customer.setC_id(rs.getInt(1));
				customer.setC_name(rs.getString(2));
				customer.setC_phone(rs.getString(3));
				customer.setC_email(rs.getString(4));
				customer.setC_address(rs.getString(5));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		} finally {
			DatabaseUtils.closeResource(ps, rs, conn);
		}

		return customer;
	}
	
	
	public Customer insert(Customer customer) throws AppException {

		Connection conn = DatabaseUtils.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("INSERT INTO customer (c_name, c_phone, c_email, c_address) VALUES (?, ?, ?, ?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, customer.getC_name());
			ps.setString(2, customer.getC_phone());
			ps.setString(3, customer.getC_email());
			ps.setString(4, customer.getC_address());

			ps.executeUpdate();

			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				customer.setC_id(rs.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		} finally {
			DatabaseUtils.closeResource(ps, rs, conn);
		}

		return customer;
	}

	public Customer update(int c_id, Customer customer) throws AppException {

		Connection conn = DatabaseUtils.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		customer.setC_id(c_id);
		try {
			ps = conn.prepareStatement(
					"UPDATE customer set c_name = ?, c_phone = ?, c_email = ?, c_address = ? WHERE c_id = ?");
			ps.setString(1, customer.getC_name());
			ps.setString(2, customer.getC_phone());
			ps.setString(3, customer.getC_email());
			ps.setString(4, customer.getC_address());
			ps.setInt(5, c_id);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		} finally {
			DatabaseUtils.closeResource(ps, rs, conn);
		}

		return customer;
	}

	public void delete(int c_id) throws AppException {
		Connection conn = DatabaseUtils.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("DELETE FROM customer WHERE c_id = ?");
			ps.setInt(1, c_id);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		} finally {
			DatabaseUtils.closeResource(ps, rs, conn);
		}
	}
}
