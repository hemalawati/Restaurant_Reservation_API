package restaurant.reservation.exception;

public class AppException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1534407210483909607L;

	public AppException (String msg) {
		super(msg);
	}
	
	public AppException (String msg, Throwable cause) {
		super(msg, cause);
	}
}
