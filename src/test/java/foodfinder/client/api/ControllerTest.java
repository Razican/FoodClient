package foodfinder.client.api;

import static org.junit.Assert.fail;

import java.io.IOException;

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