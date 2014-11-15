package foodfinder.client.gui;

import org.junit.Assert;
import org.junit.Test;

public class ResourceTest {

	@Test
	public void testGlobal() {
		Assert.assertNotNull("Status OK icon check",
				getClass().getResource("/status-OK.png"));

		Assert.assertNotNull("Status ERR icon check",
				getClass().getResource("/status-ERR.png"));

		Assert.assertNotNull("Error icon check",
				getClass().getResource("/error-icon.png"));

		Assert.assertNotNull("Empty icon check",
				getClass().getResource("/empty.png"));

		Assert.assertNotNull("Back icon check",
				getClass().getResource("/back-icon.png"));
	}

	@Test
	public void testLogin() {
		Assert.assertNotNull("Question icon check",
				getClass().getResource("/question-icon.png"));

		Assert.assertNotNull("Key icon check",
				getClass().getResource("/key-icon.png"));
	}

	@Test
	public void testRegister() {
		Assert.assertNotNull("Register icon check",
				getClass().getResource("/register-icon.png"));
	}

	@Test
	public void testResetPassword() {
		Assert.assertNotNull("Reset icon check",
				getClass().getResource("/reset-icon.png"));
	}

	@Test
	public void testSearch() {
		Assert.assertNotNull("Logout icon check",
				getClass().getResource("/logout-icon.png"));

		Assert.assertNotNull("Search icon check",
				getClass().getResource("/search-icon.png"));

		Assert.assertNotNull("Map image check",
				getClass().getResource("/map.png"));

		Assert.assertNotNull("Missing image check",
				getClass().getResource("/missing.png"));
	}

	@Test
	public void testProducts() {

		for (int i = 1; i <= 25; i++) {
			Assert.assertNotNull("Product #" + i + " image check", getClass()
					.getResource("/products/" + i + ".jpg"));
		}
	}
}