import java.awt.Dimension;

import javax.swing.JFrame;


public class Frame extends JFrame {
	
	public Frame()
	{
		
	}

	
	public static void main (String [] args)
	{
		JFrame frame = new Frame();
		
		frame.setSize(new Dimension(1024, 768));
		RegistryPanel panel = new RegistryPanel();
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
