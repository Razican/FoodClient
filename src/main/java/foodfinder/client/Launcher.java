package foodfinder.client;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import foodfinder.client.gui.Frame;
import foodfinder.client.gui.LoginPanel;
import foodfinder.client.utilities.GUIUtilities;

public class Launcher {

	public static void main(final String[] args) {

		for (final UIManager.LookAndFeelInfo laf : UIManager
				.getInstalledLookAndFeels()) {
			if ("Nimbus".equals(laf.getName()))
				try {
					UIManager.setLookAndFeel(laf.getClassName());
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
		}
		Frame.getInstance().setSize(new Dimension(560, 680));
		Frame.getInstance().setMinimumSize(new Dimension(560, 680));
		Frame.getInstance().setMaximumSize(new Dimension(900, 700));

		Frame.getInstance().add(new LoginPanel());
		Frame.getInstance().setVisible(true);
		Frame.getInstance().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GUIUtilities.CenterWindow(Frame.getInstance());
	}
}