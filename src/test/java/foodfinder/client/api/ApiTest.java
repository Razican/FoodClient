package foodfinder.client.api;

import static org.junit.Assert.fail;

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

	@Ignore("Not yet implemented")
	@Test
	public void testRegister() {
		fail("Not yet implemented");
	}

	@Ignore("Not yet implemented")
	@Test
	public void testResetPassword() {
		fail("Not yet implemented");
	}

	@Ignore("Not yet implemented")
	@Test
	public void testSearch() {
		fail("Not yet implemented");
	}
}