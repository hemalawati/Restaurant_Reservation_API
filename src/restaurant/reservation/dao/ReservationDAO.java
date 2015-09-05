package restaurant.reservation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restaurant.reservation.exception.AppException;
import restaurant.reservation.model.Reservation;
import restaurant.reservation.util.DatabaseUtils;

public class ReservationDAO {
	
	public List<Reservation> getAllReservation() throws AppException {

		List<Reservation> reservations = new ArrayList<Reservation>();

		Connection conn = DatabaseUtils.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("SELECT * FROM reservation");
			rs = ps.executeQuery();

			while (rs.next()) {
				Reservation reservation = new Reservation();
				reservation.setR_id(rs.getInt("r_id"));
				reservation.setC_id(rs.getInt("c_id"));
				reservation.setC_name(rs.getString("c_name"));
				reservation.setT_id(rs.getInt("t_id"));
				reservation.setR_size(rs.getInt("r_size"));
				reservation.setR_status(rs.getString("r_status"));
				reservation.setR_reservation_date(rs.getDate("r_reservation_date"));
				reservation.setR_today_date(rs.getDate("r_today_date"));
				reservation.setR_confirmation(rs.getString("r_confirmation"));

				reservations.add(reservation);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		} finally {
			DatabaseUtils.closeResource(ps, rs, conn);
		}

		return reservations;
	}

	public Reservation getOneReservation(int r_id) throws AppException {

		Reservation reservation = null;

		Connection conn = DatabaseUtils.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("SELECT * FROM reservation WHERE r_id = ?");
			ps.setInt(1, r_id);
			rs = ps.executeQuery();

			while (rs.next()) {
				reservation = new Reservation();
				reservation.setR_id(rs.getInt("r_id"));
				reservation.setC_id(rs.getInt("c_id"));
				reservation.setC_name(rs.getString("c_name"));
				reservation.setT_id(rs.getInt("t_id"));
				reservation.setR_size(rs.getInt("r_size"));
				reservation.setR_status(rs.getString("r_status"));
				reservation.setR_reservation_date(rs.getDate("r_reservation_date"));
				reservation.setR_today_date(rs.getDate("r_today_date"));
				reservation.setR_confirmation(rs.getString("r_confirmation"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		} finally {
			DatabaseUtils.closeResource(ps, rs, conn);
		}

		return reservation;
	}
	
	
	public Reservation insert(Reservation reservation) throws AppException {

		Connection conn = DatabaseUtils.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("INSERT INTO reservation (c_id, c_name, t_id, r_size, r_status, r_reservation_date, r_today_date, r_confirmation) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, reservation.getC_id());
			ps.setString(2, reservation.getC_name());
			ps.setInt(3, reservation.getT_id());
			ps.setInt(4, reservation.getR_size());
			ps.setString(5, reservation.getR_status());
			ps.setDate(6, reservation.getR_reservation_date());
			ps.setDate(7, reservation.getR_today_date());
			ps.setString(8, reservation.getR_confirmation());
			

			ps.executeUpdate();

			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				reservation.setR_id(rs.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		} finally {
			DatabaseUtils.closeResource(ps, rs, conn);
		}

		return reservation;
	}

	public Reservation update(int r_id, Reservation reservation) throws AppException {

		Connection conn = DatabaseUtils.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		reservation.setR_id(r_id);
		try {
			ps = conn.prepareStatement(
					"UPDATE reservation set c_id = ?, c_name = ?, t_id = ?, r_size = ?, r_status = ?, r_reservation_date = ?, r_today_date = ?, r_confirmation = ? WHERE r_id = ?");
			ps.setInt(1, reservation.getC_id());
			ps.setString(2, reservation.getC_name());
			ps.setInt(3, reservation.getT_id());
			ps.setInt(4, reservation.getR_size());
			ps.setString(5, reservation.getR_status());
			ps.setDate(6, reservation.getR_reservation_date());
			ps.setDate(7, reservation.getR_today_date());
			ps.setString(8, reservation.getR_confirmation());
			ps.setInt(9, r_id);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		} finally {
			DatabaseUtils.closeResource(ps, rs, conn);
		}

		return reservation;
	}

	public void delete(int r_id) throws AppException {
		Connection conn = DatabaseUtils.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("DELETE FROM reservation WHERE r_id = ?");
			ps.setInt(1, r_id);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());

		} finally {
			DatabaseUtils.closeResource(ps, rs, conn);
		}
	}
}
