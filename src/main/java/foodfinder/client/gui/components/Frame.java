package foodfinder.client.gui.components;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import foodfinder.client.api.Controller;

public class Frame extends JFrame {

	private static final long serialVersionUID = -1643547869380117402L;
	public static JFrame frame = new Frame();

	private Frame() {
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(final WindowEvent e) {
				Controller.logout();
			}
		});
	}

	public static JFrame getInstance() {
		return frame;
	}
}