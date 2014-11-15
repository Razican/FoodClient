package foodfinder.client.api;

import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.validator.routines.EmailValidator;
import org.json.JSONObject;

public class Controller {

	private Controller() {
	}

	public static boolean checkStatus() {
		try {
			return Api.checkStatus().getString("status").equals("OK");
		} catch (final IOException e) {
			return false;
		}
	}

	public static String login(final String username, final char[] password)
			throws IOException {

		if (username == null || username.equals("") || password == null)
			return "Insert username and password.";

		final JSONObject apiCall = Api.login(username, password);
		if (apiCall.get("error").equals(JSONObject.NULL))
			return null;

		return apiCall.getString("error");
	}

	public static String
	register(final String name, final String lastName,
			final String email, final String username,
			final char[] password, final char[] pass_conf,
			final boolean gluten, final boolean diabetes,
			final boolean vegetables, final boolean milk)
					throws IOException {

		if (empty(name) || empty(lastName) || empty(email) || empty(username)
				|| empty(password) || empty(pass_conf))
			return "You must fill all the fields.";

		if (!Arrays.equals(password, pass_conf))
			return "Passwords don't match.";

		if (!EmailValidator.getInstance().isValid(email))
			return "You must provide a valid email.";

		final JSONObject apiCall =
				Api.register(name, lastName, email, username, password, gluten,
						diabetes, vegetables, milk);
		if (apiCall.get("error").equals(JSONObject.NULL))
			return null;

		return apiCall.getString("error");
	}

	public static String resetPassword() throws IOException {
		// TODO
		return null;
	}

	private static boolean empty(final String str) {
		return str == null || str.equals("");
	}

	private static boolean empty(final char[] password) {
		return password == null;
	}
}