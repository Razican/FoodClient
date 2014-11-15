package foodfinder.client.api;

import java.io.IOException;

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

	public static String register() throws IOException {
		// TODO
		return null;
	}

	public static String resetPassword() throws IOException {
		// TODO
		return null;
	}
}