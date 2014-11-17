package foodfinder.client.api;

public class PriceMismatchException extends Exception {

	private static final long serialVersionUID = 824463372560833919L;

	public PriceMismatchException() {
		super("The minimum price provided is higher than the maximum price provided.");
	}
}