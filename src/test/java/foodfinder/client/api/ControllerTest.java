package foodfinder.client.api;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class ControllerTest {

	@Test
	public void testStatus() {
		Assert.assertTrue(Controller.checkStatus());
	}

	@Test
	public void testLogin() throws IOException {

		if (Controller.checkStatus()) {

			final char[] password = { '1', '2', '3', '4', '5' };
			final char[] password2 = { '1', '5' };

			Assert.assertEquals("Insert username and password.",
					Controller.login(null, null));
			Assert.assertEquals("Insert username and password.",
					Controller.login("", null));
			Assert.assertEquals("Insert username and password.",
					Controller.login("username", null));
			Assert.assertEquals("Insert username and password.",
					Controller.login(null, password));
			Assert.assertEquals("Insert username and password.",
					Controller.login("", password));

			Assert.assertEquals("Incorrect user/password.",
					Controller.login("testUser2", password));
			Assert.assertEquals("Incorrect user/password.",
					Controller.login("testUser", password2));

			Assert.assertNull(Controller.login("testUser", password));
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
			final String username =
					"test_" + RandomStringUtils.randomNumeric(8);
			final char[] password = { '1', '2', '3', '4', '5' };
			final char[] password2 = { '1', '2', 'a', 'b', 'c' };
			final boolean gluten = true;
			final boolean diabetes = false;
			final boolean vegetables = false;
			final boolean milk = false;

			Assert.assertEquals("Passwords don't match.", Controller.register(
					name, lastName, email, username, password, password2,
					gluten, diabetes, vegetables, milk));

			Assert.assertEquals("You must provide a valid email.", Controller
					.register(name, lastName, "ijdaofjad", username, password,
							password, gluten, diabetes, vegetables, milk));

			Assert.assertEquals("You must fill all the fields.", Controller
					.register("", lastName, email, username, password,
							password, gluten, diabetes, vegetables, milk));

			Assert.assertEquals("You must fill all the fields.", Controller
					.register(name, "", email, username, password, password,
							gluten, diabetes, vegetables, milk));

			Assert.assertEquals("You must fill all the fields.", Controller
					.register(name, lastName, "", username, password, password,
							gluten, diabetes, vegetables, milk));

			Assert.assertEquals("You must fill all the fields.", Controller
					.register(name, lastName, email, "", password, password,
							gluten, diabetes, vegetables, milk));

			Assert.assertEquals("You must fill all the fields.", Controller
					.register(name, lastName, email, username, null, password,
							gluten, diabetes, vegetables, milk));

			Assert.assertEquals("You must fill all the fields.", Controller
					.register(name, lastName, email, username, password, null,
							gluten, diabetes, vegetables, milk));

			Assert.assertEquals("Email already exists.", Controller.register(
					name, lastName, "testUser@example.com", username, password,
					password, gluten, diabetes, vegetables, milk));

			Assert.assertEquals("Username already exists.", Controller
					.register(name, lastName, email, "testUser", password,
							password, gluten, diabetes, vegetables, milk));

			Assert.assertNull(Controller.register(name, lastName, email,
					username, password, password, gluten, diabetes, vegetables,
					milk));
		}
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