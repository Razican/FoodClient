package foodfinder.client;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import foodfinder.client.gui.LoginPanel;
import foodfinder.client.gui.components.Frame;

public class Launcher {

	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {

				for (final UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
					if ("Nimbus".equals(laf.getName()))
						try {
							UIManager.setLookAndFeel(laf.getClassName());
						} catch (ClassNotFoundException | InstantiationException
								| IllegalAccessException | UnsupportedLookAndFeelException e) {
							e.printStackTrace();
						}
				}
				Frame.getInstance().setSize(new Dimension(560, 420));
				Frame.getInstance().setMinimumSize(new Dimension(560, 420));
				Frame.getInstance().setMaximumSize(new Dimension(900, 550));
				Frame.getInstance().setLocationRelativeTo(null);

				Frame.getInstance().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Frame.getInstance().add(new LoginPanel());
				Frame.getInstance().setVisible(true);
			}
		});
	}
}