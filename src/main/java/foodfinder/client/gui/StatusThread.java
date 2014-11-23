package foodfinder.client.gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import foodfinder.client.api.Controller;

public class StatusThread extends Thread {

	private JLabel connectionStatus;

	public StatusThread(final JLabel label) {
		connectionStatus = label;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			if (Controller.checkStatus() == true) {
				connectionStatus =
						new JLabel(new ImageIcon(getClass().getResource("/status-OK.png")));
				connectionStatus.setToolTipText("Connection Status: OK");
			} else {
				connectionStatus =
						new JLabel(new ImageIcon(getClass().getResource("/status-ERR.png")));
				connectionStatus.setToolTipText("Connection Status: ERROR");
			}

			try {
				Thread.sleep(5000);
			} catch (final InterruptedException e) {
				this.interrupt();
			}
		}
	}
}