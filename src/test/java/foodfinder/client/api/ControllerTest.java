package foodfinder.client.api;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ControllerTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testStatus() {
		Assert.assertTrue(Controller.checkStatus());
	}

	@Test
	public void testLogin() throws IOException {

		if (Controller.checkStatus()) {

			final char[] password = { '1', '2', '3', '4', '5' };
			final char[] password2 = { '1', '5' };

			Assert.assertEquals("Insert username and password.", Controller.login(null, null));
			Assert.assertEquals("Insert username and password.", Controller.login("", null));
			Assert.assertEquals("Insert username and password.", Controller.login("username", null));
			Assert.assertEquals("Insert username and password.", Controller.login(null, password));
			Assert.assertEquals("Insert username and password.", Controller.login("", password));

			Assert.assertEquals("Incorrect user/password.", Controller.login("testUser2", password));
			Assert.assertEquals("Incorrect user/password.", Controller.login("testUser", password2));

			Assert.assertNull(Controller.login("testUser", password));
			Controller.logout();
		}
	}

	@Test
	public void testRegister() throws IOException {

		if (Controller.checkStatus()) {

			final String name = "testUser";
			final String lastName = "testUserLastName";
			final String email =
					"test_" + RandomStringUtils.randomNumeric(5) + "@"
							+ RandomStringUtils.randomNumeric(5) + ".com";
			final String username = "test_" + RandomStringUtils.randomNumeric(8);
			final char[] password = { '1', '2', '3', '4', '5' };
			final char[] password2 = { '1', '2', 'a', 'b', 'c' };
			final boolean gluten = true;
			final boolean diabetes = false;
			final boolean vegetables = false;
			final boolean milk = false;

			Assert.assertEquals("Passwords don't match.", Controller.register(name, lastName,
					email, username, password, password2, gluten, diabetes, vegetables, milk));

			Assert.assertEquals("You must provide a valid email.", Controller.register(name,
					lastName, "ijdaofjad", username, password, password, gluten, diabetes,
					vegetables, milk));

			Assert.assertEquals("You must fill all the fields.", Controller.register("", lastName,
					email, username, password, password, gluten, diabetes, vegetables, milk));

			Assert.assertEquals("You must fill all the fields.", Controller.register(name, "",
					email, username, password, password, gluten, diabetes, vegetables, milk));

			Assert.assertEquals("You must fill all the fields.", Controller.register(name,
					lastName, "", username, password, password, gluten, diabetes, vegetables, milk));

			Assert.assertEquals("You must fill all the fields.", Controller.register(name,
					lastName, email, "", password, password, gluten, diabetes, vegetables, milk));

			Assert.assertEquals("You must fill all the fields.", Controller.register(name,
					lastName, email, username, null, password, gluten, diabetes, vegetables, milk));

			Assert.assertEquals("You must fill all the fields.", Controller.register(name,
					lastName, email, username, password, null, gluten, diabetes, vegetables, milk));

			Assert.assertEquals("Email already exists.", Controller.register(name, lastName,
					"testUser@example.com", username, password, password, gluten, diabetes,
					vegetables, milk));

			Assert.assertEquals("Username already exists.", Controller.register(name, lastName,
					email, "testUser", password, password, gluten, diabetes, vegetables, milk));

			Assert.assertNull(Controller.register(name, lastName, email, username, password,
					password, gluten, diabetes, vegetables, milk));
		}
	}

	@Test
	public void testResetPassword() throws IOException {
		if (Controller.checkStatus()) {

			Assert.assertEquals("Insert the email address.",
					Controller.resetPassword(null, true, false));

			Assert.assertEquals("Insert the email address.",
					Controller.resetPassword("", true, false));

			Assert.assertEquals(
					"Select what you want to reset.",
					Controller.resetPassword("testR_" + RandomStringUtils.randomNumeric(5)
							+ "@example.com", false, false));

			Assert.assertEquals("The email you provided is not valid",
					Controller.resetPassword("ssdfsfsdfs", true, false));

			Assert.assertEquals(
					"There is no user with that email",
					Controller.resetPassword("testR_" + RandomStringUtils.randomNumeric(5)
							+ "@example.com", true, false));

			Assert.assertNull(Controller.resetPassword("testUser@example.com", true, false));
		}
	}

	@Test
	public void testSearch() throws UserNotSetException, IOException, PriceMismatchException {
		if (Controller.checkStatus()) {
			final String username = "testUser";
			final char[] password = { '1', '2', '3', '4', '5' };
			final String name = "";
			final int type = 0;
			final String brand = "";
			double price_min = 0;
			double price_max = 99.99;

			Controller.login(username, password);

			List<SearchResult> result = Controller.search(name, type, brand, price_min, price_max);
			Assert.assertTrue(result.size() > 0);

			price_max = 0;

			result = Controller.search(name, type, brand, price_min, price_max);
			Assert.assertNull(result);

			price_min = 10;
			price_max = 5;

			exception.expect(PriceMismatchException.class);
			Controller.search(name, type, brand, price_min, price_max);

			Controller.logout();
			exception.expect(UserNotSetException.class);
			Controller.search(name, type, brand, price_min, price_max);
		}
	}

	@Test
	public void testSearchResult() {
		final JSONObject result = new JSONObject();
		result.put("id", 1);
		result.put("name", "testName");
		result.put("type", "Vegetables");
		result.put("brand", "testBrand");
		result.put("price", 1.25);
		result.put("desc", "testDescription");
		result.put("hall", 1);
		result.put("shelf", 2);

		final SearchResult result1 = new SearchResult(result);
		final SearchResult result2 = new SearchResult(result);

		Assert.assertEquals(result1, result2);

		result.put("id", 2);
		final SearchResult result3 = new SearchResult(result);

		Assert.assertNotEquals(result1, result3);
	}
}