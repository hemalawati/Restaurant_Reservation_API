package restaurant.reservation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restaurant.reservation.exception.AppException;
import restaurant.reservation.model.SeatingTable;
import restaurant.reservation.util.DatabaseUtils;

public class SeatingTableDAO {

	public List<SeatingTable> getAllTables() throws AppException {

		List<SeatingTable> seatingTables = new ArrayList<SeatingTable>();

		Connection conn = DatabaseUtils.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("SELECT * FROM seating_table");
			rs = ps.executeQuery();

			while (rs.next()) {
				SeatingTable seatingTable = new SeatingTable();
				seatingTable.setT_id(rs.getInt(1));
				seatingTable.setT_status(rs.getString(2));

				seatingTables.add(seatingTable);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		} finally {
			DatabaseUtils.closeResource(ps, rs, conn);
		}

		return seatingTables;
	}

	public SeatingTable getOneTable(int t_id) throws AppException {

		SeatingTable seatingTable = null;

		Connection conn = DatabaseUtils.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("SELECT * FROM seating_table WHERE t_id = ?");
			ps.setInt(1, t_id);
			rs = ps.executeQuery();

			while (rs.next()) {
				seatingTable = new SeatingTable();
				seatingTable.setT_id(rs.getInt(1));
				seatingTable.setT_status(rs.getString(2));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		} finally {
			DatabaseUtils.closeResource(ps, rs, conn);
		}

		return seatingTable;
	}

	public SeatingTable insert(SeatingTable seatingTable) throws AppException {

		Connection conn = DatabaseUtils.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("INSERT INTO seating_table (t_id, t_status) VALUES (?, ?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, seatingTable.getT_id());
			ps.setString(2, seatingTable.getT_status());

			ps.executeUpdate();

			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				seatingTable.setT_id(rs.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		} finally {
			DatabaseUtils.closeResource(ps, rs, conn);
		}

		return seatingTable;
	}

	public SeatingTable update(int t_id, SeatingTable seatingTable) throws AppException {

		Connection conn = DatabaseUtils.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		seatingTable.setT_id(t_id);
		try {
			ps = conn.prepareStatement("UPDATE seating_table set t_status = ? WHERE t_id = ?");
			ps.setString(1, seatingTable.getT_status());
			ps.setInt(2, t_id);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		} finally {
			DatabaseUtils.closeResource(ps, rs, conn);
		}

		return seatingTable;
	}

	public void delete(int t_id) throws AppException {
		Connection conn = DatabaseUtils.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("DELETE FROM seatingTable WHERE t_id = ?");
			ps.setInt(1, t_id);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());

		} finally {
			DatabaseUtils.closeResource(ps, rs, conn);
		}
	}

}
