package foodfinder.client.api;

public class UserNotSetException extends Exception {

	private static final long serialVersionUID = 2463388650098774878L;

	public UserNotSetException() {
		super("The username was not set in the Controller.");
	}
}