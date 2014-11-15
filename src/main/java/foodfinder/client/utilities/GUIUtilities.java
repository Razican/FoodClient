package foodfinder.client.utilities;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class GUIUtilities {

	public static Container getMainContainer(Component c) {
		if (c == null)
			return null;
		Container ret = c.getParent();
		while (ret != null) {
			c = ret;
			ret = ret.getParent();
		}
		return (Container) c;
	}

	public static void CenterWindow(final JFrame a) {
		final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		final Dimension window = a.getSize();
		a.setLocation((int) (screen.width - window.getWidth()) / 2, (int) (screen.height - window.getHeight()) / 2);
	}
}
