package api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class Api {

	private static String API_URL = "http://localhost/foodweb/api/";

	private Api() {
	}

	public JSONObject login(final String username, final String password) {
		final HashMap<String, String> params = new HashMap<>();
		params.put("username", username);
		params.put("password", password);

		return getJSON("login", params);
	}

	public static void main(final String[] args) {
		final String url = "http://localhost/foodweb/api";

		final HashMap<String, String> params = new HashMap<>();
		params.put("name", "Razican");

		final JSONObject json = getJSON(url, params);
		System.out.println(json.get("message"));
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
	private static String getTextfromURL(final String urlStr, final Map<?, ?> params) throws IOException {
		final URL obj = new URL(urlStr);
		final HttpURLConnection con = (HttpURLConnection) obj.openConnection();

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

		final int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL: " + urlStr);
		System.out.println("Post parameters: " + urlParameters);
		System.out.println("Response Code: " + responseCode);

		final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
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
			sb.append(String.format("%s=%s", urlEncodeUTF8(entry.getKey().toString()), urlEncodeUTF8(entry.getValue().toString())));
		}
		return sb.toString();
	}
}