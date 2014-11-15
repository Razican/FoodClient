package foodfinder.client.api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONException;
import org.json.JSONObject;

import com.razican.utils.StringUtils;

public class Api {

	private static String API_URL = "https://www.razican.com/foodweb/api/";

	private Api() {
	}

	public static JSONObject status() {
		return getJSON("status", null);
	}

	public static JSONObject
			login(final String username, final char[] password) {
		final HashMap<String, String> params = new HashMap<>();
		params.put("username", username);
		params.put("password", StringUtils.sha1(password));

		return getJSON("login", params);
	}

	public static JSONObject register(final String name, final String lastName,
			final String email, final String username, final char[] password,
			final boolean gluten, final boolean diabetes,
			final boolean vegetables, final boolean milk) {
		// TODO
		return null;
	}

	private static JSONObject getJSON(final String url, final Map<?, ?> params) {
		try {
			return new JSONObject(getTextfromURL(API_URL + url, params));
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	// From http://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/
	private static String getTextfromURL(final String urlStr,
			final Map<?, ?> params) throws IOException {
		final URL obj = new URL(urlStr);
		final HttpsURLConnection con =
				(HttpsURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");

		String urlParameters = "";
		if (params != null)
			urlParameters = urlEncodeUTF8(params);

		// Send post request
		con.setDoOutput(true);
		final DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		final BufferedReader in =
				new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		final StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		return response.toString();
	}

	// From
	// http://stackoverflow.com/questions/2809877/how-to-convert-map-to-url-query-string
	private static String urlEncodeUTF8(final String s) {
		try {
			return URLEncoder.encode(s, "UTF-8");
		} catch (final UnsupportedEncodingException e) {
			throw new UnsupportedOperationException(e);
		}
	}

	private static String urlEncodeUTF8(final Map<?, ?> map) {
		final StringBuilder sb = new StringBuilder();
		for (final Map.Entry<?, ?> entry : map.entrySet()) {
			if (sb.length() > 0) {
				sb.append("&");
			}
			sb.append(String.format("%s=%s", urlEncodeUTF8(entry.getKey()
					.toString()), urlEncodeUTF8(entry.getValue().toString())));
		}
		return sb.toString();
	}

	public static void main(final String[] args) {

		final String url = "login";
		final HashMap<String, String> params = new HashMap<>();
		params.put("name", "Razican");
		params.put("password", "Razican");

		final JSONObject json = getJSON(url, params);
		System.out.println(json.get("error"));
	}
}