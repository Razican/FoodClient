package foodfinder.client.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.validator.routines.EmailValidator;
import org.json.JSONArray;
import org.json.JSONObject;

public class Controller {

	private static String username;

	private Controller() {
	}

	public static void logout() {
		username = null;
	}

	public static boolean checkStatus() {
		try {
			return Api.checkStatus().getString("status").equals("OK");
		} catch (final IOException e) {
			return false;
		}
	}

	public static String login(final String username, final char[] password) throws IOException {

		if (username == null || username.equals("") || password == null)
			return "Insert username and password.";

		final JSONObject apiCall = Api.login(username, password);
		if (apiCall.get("error").equals(JSONObject.NULL)) {
			Controller.username = username;
			return null;
		}

		return apiCall.getString("error");
	}

	public static String register(final String name, final String lastName, final String email,
			final String username, final char[] password, final char[] pass_conf,
			final boolean gluten, final boolean diabetes, final boolean vegetables,
			final boolean milk) throws IOException {

		if (empty(name) || empty(lastName) || empty(email) || empty(username) || empty(password)
				|| empty(pass_conf))
			return "You must fill all the fields.";

		if (!Arrays.equals(password, pass_conf))
			return "Passwords don't match.";

		if (!EmailValidator.getInstance().isValid(email))
			return "You must provide a valid email.";

		final JSONObject apiCall =
				Api.register(name, lastName, email, username, password, gluten, diabetes,
						vegetables, milk);
		if (apiCall.get("error").equals(JSONObject.NULL))
			return null;

		return apiCall.getString("error");
	}

	public static String resetPassword(final String email, final boolean username,
			final boolean password) throws IOException {

		if (empty(email))
			return "Insert the email address.";

		if (username == false && password == false)
			return "Select what you want to reset.";

		if (!EmailValidator.getInstance().isValid(email))
			return "The email you provided is not valid";

		final JSONObject apiCall = Api.resetPassword(email, username, password);
		if (apiCall.get("error").equals(JSONObject.NULL))
			return null;

		return apiCall.getString("error");
	}

	public static List<SearchResult> search(String name, final int type, String brand,
			final double price_min, final double price_max) throws UserNotSetException,
			IOException, PriceMismatchException {

		if (empty(username))
			throw new UserNotSetException();
		if (price_min > price_max)
			throw new PriceMismatchException();

		if (name == null)
			name = "";
		if (brand == null)
			brand = "";

		final JSONObject apiCall = Api.search(username, name, type, brand, price_min, price_max);
		if (apiCall.get("error").equals(JSONObject.NULL)) {

			final JSONArray result = apiCall.getJSONArray("result");
			final List<SearchResult> resultList = new ArrayList<>(result.length());

			for (int i = 0; i < result.length(); i++) {
				resultList.add(new SearchResult(result.getJSONObject(i)));
			}

			return resultList;
		}

		return null;
	}

	private static boolean empty(final String str) {
		return str == null || str.equals("");
	}

	private static boolean empty(final char[] password) {
		return password == null;
	}
}