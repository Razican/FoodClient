package foodfinder.client.gui;

public class Controller {

	private static Controller instance = new Controller();

	private Controller() {
		// TODO Auto-generated constructor stub
	}

	public static Controller getInstance() {
		return instance;
	}
}