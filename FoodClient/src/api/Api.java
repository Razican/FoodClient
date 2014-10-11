package api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class Api {

	public Api() {
		// TODO Auto-generated constructor stub
	}

	public static void main(final String[] args) {
		final String url = "http://localhost/foodweb/api";

		final JSONObject json = getJSON(url);
		System.out.println(json.get("message"));
	}

	private static JSONObject getJSON(final String url) {
		return new JSONObject(getTextfromURL(url));
	}

	private static String getTextfromURL(final String urlStr) {
		final StringBuilder sb = new StringBuilder();
		URLConnection urlConn = null;
		InputStreamReader in = null;
		try {
			final URL url = new URL(urlStr);
			urlConn = url.openConnection();
			if (urlConn != null)
				urlConn.setReadTimeout(60 * 1000);

			if (urlConn != null && urlConn.getInputStream() != null) {
				in = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
				final BufferedReader bufferedReader = new BufferedReader(in);
				if (bufferedReader != null) {
					int cp;
					while ((cp = bufferedReader.read()) != -1) {
						sb.append((char) cp);
					}
					bufferedReader.close();
				}
			}
			in.close();
		} catch (final Exception e) {
			throw new RuntimeException("Exception while calling URL:" + urlStr, e);
		}

		return sb.toString();
	}
}