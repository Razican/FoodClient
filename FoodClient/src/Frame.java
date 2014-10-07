import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Utilities.GUIUtilities;

public class Frame extends JFrame {

	public static JFrame frame;

	public Frame() {

	}

	public static void main(String[] args) {
		frame = new Frame();
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
