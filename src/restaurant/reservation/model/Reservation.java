package restaurant.reservation.model;

import java.sql.Date;

public class Reservation {

	private int r_id;
	private int c_id;
	private String c_name;
	private int t_id;
	private int r_size;
	private String r_status;
	private Date r_reservation_date;
	private Date r_today_date;
	private String r_confirmation;
	
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public int getR_size() {
		return r_size;
	}
	public void setR_size(int r_size) {
		this.r_size = r_size;
	}
	public String getR_status() {
		return r_status;
	}
	public void setR_status(String r_status) {
		this.r_status = r_status;
	}
	public Date getR_reservation_date() {
		return r_reservation_date;
	}
	public void setR_reservation_date(Date r_reservation_date) {
		this.r_reservation_date = r_reservation_date;
	}
	public Date getR_today_date() {
		return r_today_date;
	}
	public void setR_today_date(Date r_today_date) {
		this.r_today_date = r_today_date;
	}
	public String getR_confirmation() {
		return r_confirmation;
	}
	public void setR_confirmation(String r_confirmation) {
		this.r_confirmation = r_confirmation;
	}
	
	
	
	
}
