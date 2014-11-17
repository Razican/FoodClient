package foodfinder.client.gui.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.net.URL;
import java.util.HashMap;

import javax.swing.ImageIcon;

public class Map extends ImageIcon {

	private static final long serialVersionUID = -3610884586146980628L;

	private final HashMap<Point, Point> locationToCoordinate = new HashMap<>();
	private Point mark;

	public Map(final URL location) {
		super(location);

		locationToCoordinate.put(new Point(1, 1), new Point(164, 65));
		locationToCoordinate.put(new Point(1, 2), new Point(224, 65));
		locationToCoordinate.put(new Point(2, 1), new Point(252, 65));
		locationToCoordinate.put(new Point(2, 2), new Point(312, 65));
		locationToCoordinate.put(new Point(3, 1), new Point(340, 65));
		locationToCoordinate.put(new Point(3, 2), new Point(400, 65));
		locationToCoordinate.put(new Point(4, 1), new Point(428, 65));
		locationToCoordinate.put(new Point(4, 2), new Point(488, 65));
	}

	private synchronized void setMark(final Point p) {
		mark = p;
	}

	public void setMark(final int hall, final int shelf) {
		setMark(locationToCoordinate.get(new Point(hall, shelf)));
	}

	@Override
	public synchronized void
	paintIcon(final Component c, final Graphics g, final int x, final int y) {
		super.paintIcon(c, g, x, y);

		if (mark != null) {
			g.setColor(Color.RED);
			g.fillOval(mark.x - 4, mark.y - 4, 8, 8);
		}
	}
}