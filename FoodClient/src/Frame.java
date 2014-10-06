import java.awt.Dimension;

import javax.swing.JFrame;

import Utilities.GUIUtilities;

public class Frame extends JFrame {

	public static JFrame frame;

	public Frame() {

	}

	public static void main(String[] args) {
		frame = new Frame();

		frame.setSize(new Dimension(560, 420));
		// RegistryPanel panel = new RegistryPanel();
		// UserPasswordResetPanel panel = new UserPasswordResetPanel();
		LoginPanel panel = new LoginPanel();
		// SearchPanel panel = new SearchPanel();
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		GUIUtilities.CenterWindow(frame);

	}
}
