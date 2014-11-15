package foodfinder.client.gui;

import org.junit.Assert;
import org.junit.Test;

public class ResourceTest {

	@Test
	public void testGlobal() {

		Assert.assertNotNull(getClass().getResource("/status-OK.png"));
		Assert.assertNotNull(getClass().getResource("/status-ERR.png"));
		Assert.assertNotNull(getClass().getResource("/error-icon.png"));
		Assert.assertNotNull(getClass().getResource("/empty.png"));
		Assert.assertNotNull(getClass().getResource("/back-icon.png"));
	}

	@Test
	public void testLogin() {

		Assert.assertNotNull(getClass().getResource("/question-icon.png"));
		Assert.assertNotNull(getClass().getResource("/key-icon.png"));
	}

	@Test
	public void testRegister() {

		Assert.assertNotNull(getClass().getResource("/register-icon.png"));
	}

	@Test
	public void testResetPassword() {

		Assert.assertNotNull(getClass().getResource("/reset-icon.png"));
	}

	@Test
	public void testSearch() {

		Assert.assertNotNull(getClass().getResource("/logout-icon.png"));
		Assert.assertNotNull(getClass().getResource("/search-icon.png"));
		Assert.assertNotNull(getClass().getResource("/map.png"));
		Assert.assertNotNull(getClass().getResource("/missing.png"));
	}

	@Test
	public void testProducts() {

		for (int i = 1; i <= 25; i++) {
			Assert.assertNotNull(getClass().getResource(
					"/products/" + i + ".jpg"));
		}
	}
}