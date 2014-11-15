package foodfinder.client.api;

import static org.junit.Assert.fail;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class ApiTest {

	@Test
	public void testStatus() {
		final JSONObject result = Api.status();

		Assert.assertEquals("OK", result.get("status"));
		Assert.assertEquals(JSONObject.NULL, result.get("error"));
	}

	@Test
	public void testLogin() {

		final char[] password = { '1', '2', '3', '4', '5' };
		JSONObject result = Api.login("testUser", password);

		Assert.assertEquals("OK", result.get("status"));
		Assert.assertEquals(JSONObject.NULL, result.get("error"));

		final char[] password2 = { '1', '5' };
		result = Api.login("testUser", password2);

		Assert.assertEquals("ERR", result.get("status"));
		Assert.assertEquals("Incorrect user/password.", result.get("error"));
	}

	@Test
	public void testRegister() {
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
				Api.register(name, lastName, email, username, password, gluten,
						diabetes, vegetables, milk);

		Assert.assertEquals("OK", result.get("status"));
		Assert.assertEquals(JSONObject.NULL, result.get("error"));

		final String email2 =
				"test_" + RandomStringUtils.randomNumeric(5) + "@"
						+ RandomStringUtils.randomNumeric(5) + ".com";

		result =
				Api.register(name, lastName, email2, username, password,
						gluten, diabetes, vegetables, milk);

		Assert.assertEquals("ERR", result.get("status"));
		Assert.assertEquals("Username already exists.", result.get("error"));

		final String username2 = "test_" + RandomStringUtils.randomNumeric(8);

		result =
				Api.register(name, lastName, email, username2, password,
						gluten, diabetes, vegetables, milk);

		Assert.assertEquals("ERR", result.get("status"));
		Assert.assertEquals("Email exists", result.get("error"));
	}

	@Test
	public void testResetPassword() {

		JSONObject result =
				Api.resetPassword("testUser@example.com", true, false);

		Assert.assertEquals("OK", result.get("status"));
		Assert.assertEquals(JSONObject.NULL, result.get("error"));

		result =
				Api.resetPassword("testR_" + RandomStringUtils.randomNumeric(5)
						+ "@example.com", true, false);

		Assert.assertEquals("ERR", result.get("status"));
		Assert.assertEquals("There is no user with that email",
				result.get("error"));

	}

	@Ignore("Not yet implemented")
	@Test
	public void testSearch() {
		fail("Not yet implemented");
	}
}