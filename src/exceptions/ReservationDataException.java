package exceptions;

public class ReservationDataException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ReservationDataException(String message) {
		super(message);
	}

}
