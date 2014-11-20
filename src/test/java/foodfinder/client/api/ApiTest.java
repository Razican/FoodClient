package foodfinder.client.api;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class ApiTest {

	@Test
	public void testStatus() {

		try {
			final JSONObject result = Api.checkStatus();

			Assert.assertEquals("OK", result.get("status"));
			Assert.assertEquals(JSONObject.NULL, result.get("error"));
		} catch (JSONException | IOException e) {
		}
	}

	@Test
	public void testLogin() throws IOException {

		if (Controller.checkStatus()) {

			final char[] password = { '1', '2', '3', '4', '5' };
			JSONObject result = Api.login("testUser", password);

			Assert.assertEquals("OK", result.get("status"));
			Assert.assertEquals(JSONObject.NULL, result.get("error"));

			final char[] password2 = { '1', '5' };
			result = Api.login("testUser", password2);

			Assert.assertEquals("ERR", result.get("status"));
			Assert.assertEquals("Incorrect user/password.", result.get("error"));
		}
	}

	@Test
	public void testRegister() throws JSONException, IOException {

		if (Controller.checkStatus()) {
			final String name = "testUser";
			final String lastName = "testUserLastName";
			final String email =
					"test_" + RandomStringUtils.randomNumeric(5) + "@"
							+ RandomStringUtils.randomNumeric(5) + ".com";
			final String username = "test_" + RandomStringUtils.randomNumeric(8);
			final char[] password = { '1', '2', '3', '4', '5' };
			final boolean gluten = true;
			final boolean diabetes = false;
			final boolean vegetables = false;
			final boolean milk = false;

			JSONObject result =
					Api.register(name, lastName, email, username, password, gluten, diabetes,
							vegetables, milk);

			Assert.assertEquals("OK", result.get("status"));
			Assert.assertEquals(JSONObject.NULL, result.get("error"));

			final String email2 =
					"test_" + RandomStringUtils.randomNumeric(5) + "@"
							+ RandomStringUtils.randomNumeric(5) + ".com";

			result =
					Api.register(name, lastName, email2, "testUser", password, gluten, diabetes,
							vegetables, milk);

			Assert.assertEquals("ERR", result.get("status"));
			Assert.assertEquals("Username already exists.", result.get("error"));

			final String username2 = "test_" + RandomStringUtils.randomNumeric(8);

			result =
					Api.register(name, lastName, "testUser@example.com", username2, password,
							gluten, diabetes, vegetables, milk);

			Assert.assertEquals("ERR", result.get("status"));
			Assert.assertEquals("Email already exists.", result.get("error"));
		}
	}

	@Test
	public void testResetPassword() throws JSONException, IOException {

		if (Controller.checkStatus()) {

			JSONObject result = Api.resetPassword("testUser@example.com", true, false);

			Assert.assertEquals("OK", result.get("status"));
			Assert.assertEquals(JSONObject.NULL, result.get("error"));

			result =
					Api.resetPassword("testR_" + RandomStringUtils.randomNumeric(5)
							+ "@example.com", true, false);

			Assert.assertEquals("ERR", result.get("status"));
			Assert.assertEquals("There is no user with that email", result.get("error"));
		}
	}

	@Test
	public void testSearch() throws IOException {
		if (Controller.checkStatus()) {
			final String username = "testUser";
			final String name = "";
			final int type = 0;
			final String brand = "";
			final double price_min = 0;
			double price_max = 99.99;

			JSONObject result = Api.search(username, name, type, brand, price_min, price_max);

			Assert.assertEquals("OK", result.get("status"));
			Assert.assertEquals(JSONObject.NULL, result.get("error"));
			Assert.assertNotEquals(JSONObject.NULL, result.get("result"));

			price_max = 0;

			result = Api.search(username, name, type, brand, price_min, price_max);

			Assert.assertEquals("ERR", result.get("status"));
			Assert.assertEquals("Nothing found according to the criteria.", result.get("error"));
			Assert.assertEquals(JSONObject.NULL, result.get("result"));
		}
	}
}