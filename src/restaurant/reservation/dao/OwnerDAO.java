package restaurant.reservation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restaurant.reservation.exception.AppException;
import restaurant.reservation.model.Owner;
import restaurant.reservation.util.DatabaseUtils;

public class OwnerDAO {
	public List<Owner> getAllOwners() throws AppException {

		List<Owner> owners = new ArrayList<Owner>();

		Connection conn = DatabaseUtils.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("SELECT * FROM owner");
			rs = ps.executeQuery();

			while (rs.next()) {
				Owner owner = new Owner();
				owner.setO_id(rs.getInt(1));
				owner.setO_name(rs.getString(2));
				owner.setO_title(rs.getString(3));
				
			owners.add(owner);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		} finally {
			DatabaseUtils.closeResource(ps, rs, conn);
		}

		return owners;
	}

	public Owner getOneOwner(int o_id) throws AppException {

		Owner owner = null;

		Connection conn = DatabaseUtils.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("SELECT * FROM owner WHERE o_id = ?");
			ps.setInt(1, o_id);
			rs = ps.executeQuery();

			while (rs.next()) {
				owner = new Owner();
				owner.setO_id(rs.getInt(1));
				owner.setO_name(rs.getString(2));
				owner.setO_title(rs.getString(3));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		} finally {
			DatabaseUtils.closeResource(ps, rs, conn);
		}

		return owner;
	}

	public Owner insert(Owner owner) throws AppException {

		Connection conn = DatabaseUtils.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("INSERT INTO owner (o_name, o_title) VALUES (?, ?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, owner.getO_name());
			ps.setString(2, owner.getO_title());
			
			ps.executeUpdate();

			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				owner.setO_id(rs.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		} finally {
			DatabaseUtils.closeResource(ps, rs, conn);
		}

		return owner;
	}

	public Owner update(int o_id, Owner owner) throws AppException {

		Connection conn = DatabaseUtils.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		owner.setO_id(o_id);
		try {
			ps = conn.prepareStatement(
					"UPDATE owner set o_name = ?, o_title = ? WHERE o_id = ?");
			ps.setString(1, owner.getO_name());
			ps.setString(2, owner.getO_title());
			ps.setInt(3, o_id);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		} finally {
			DatabaseUtils.closeResource(ps, rs, conn);
		}

		return owner;
	}

	public void delete(int o_id) throws AppException {
		Connection conn = DatabaseUtils.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("DELETE FROM owner WHERE o_id = ?");
			ps.setInt(1, o_id);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());

		} finally {
			DatabaseUtils.closeResource(ps, rs, conn);
		}
	}

}
