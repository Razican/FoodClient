package foodfinder.client.api;

public class Controller {

	private Controller() {
	}

	public static boolean checkStatus() {
		return Api.checkStatus().get("status").equals("OK");
	}
}