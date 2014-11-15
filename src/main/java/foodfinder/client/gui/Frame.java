package foodfinder.client.gui;

import javax.swing.JFrame;

public class Frame extends JFrame {

	private static final long serialVersionUID = -1643547869380117402L;
	public static JFrame frame = new JFrame();

	private Frame() {
	}

	public static JFrame getInstance() {
		return frame;
	}
}
