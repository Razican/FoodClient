package foodfinder.client.api;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class ControllerTest {

	@Test
	public void testStatus() {
		Assert.assertTrue(Controller.checkStatus());
	}

	@Ignore("Not yet implemented")
	@Test
	public void testLogin() {
		fail("Not yet implemented");
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