package gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.UIManager;

import utilities.GUIUtilities;

public class Frame extends JFrame {

	public static JFrame frame;

	public Frame() {

	}

	public static void main(final String[] args) {
		frame = new Frame();
		for (final UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
			if ("Nimbus".equals(laf.getName()))
				try {
					UIManager.setLookAndFeel(laf.getClassName());
				} catch (final Exception ex) {
				}
		}
		frame.setSize(new Dimension(480, 470));
		frame.setMinimumSize(new Dimension(480, 470));
		frame.setMaximumSize(new Dimension(900, 700));
		final RegistryPanel panel = new RegistryPanel();
		// UserPasswordResetPanel panel = new UserPasswordResetPanel();
		// final LoginPanel panel = new LoginPanel();
		// SearchPanel panel = new SearchPanel();
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		GUIUtilities.CenterWindow(frame);

	}
}
