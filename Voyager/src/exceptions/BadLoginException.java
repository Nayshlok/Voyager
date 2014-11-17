package exceptions;

public class BadLoginException extends RuntimeException {

	public BadLoginException(String message){
		super(message);
	}
}
