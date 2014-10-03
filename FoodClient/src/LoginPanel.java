import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import Utilities.GUIUtilities;
import Utilities.SpringUtilities;

public class LoginPanel extends JPanel implements ActionListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lUsername;
	private JLabel lPassword;
	private JTextField tfUsername;
	private JPasswordField tfPassword;
	private JButton bUserPasswordReset;
	private JButton bLogin;
	private JButton bNewUser;
	private JLabel lHeader;
	private JLabel connectionStatus;
	private JPanel header;
	private JPanel textPanel;
	private FlowLayout flowLayout;
	private JPanel buttonPanel;
	private JPanel thisContainer;

	public LoginPanel() {
		initializeVariables();

		header.setLayout(new SpringLayout());
		placeHeaderComponents();
		SpringUtilities.makeCompactGrid(header, 1, 2,
				((Frame.frame.getWidth() / 2) + 25), 1,
				Frame.frame.getWidth() / 4, 0);

		textPanel.setLayout(new SpringLayout());
		placeTextComponents();
		SpringUtilities.makeCompactGrid(textPanel, 2, 2, 6, 6, 6, 6);

		buttonPanel.setLayout(new FlowLayout());
		placeButtons();

		thisContainer.setLayout(flowLayout);
		thisContainer.add(header);
		thisContainer.add(Box.createVerticalStrut(40));
		thisContainer.add(textPanel);
		thisContainer.add(Box.createVerticalStrut(40));
		thisContainer.add(buttonPanel);

	}

	public void initializeVariables() {
		thisContainer=this;
		header = new JPanel();
		lHeader = new JLabel("PRODUCT FINDER");
		connectionStatus = new JLabel(new ImageIcon(getClass().getResource(
				"/Resources/Base Green Deep.png")));
		textPanel = new JPanel();
		lUsername = new JLabel("Username:");
		tfUsername = new JTextField(20);
		tfUsername.setText("Example:Peio");
		tfUsername.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if(tfUsername.getText().equals("Example:Peio"))
				{
					tfUsername.setText("");
				}
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		lPassword = new JLabel("Password:");
		tfPassword = new JPasswordField(20);
		tfPassword.setEchoChar((char) 0);
		tfPassword.setText("Example:1234");
		tfPassword.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if(tfPassword.getText().equals("Example:1234"))
				{
					tfPassword.setText("");
					tfPassword.setEchoChar('*');	
				}
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		flowLayout = new FlowLayout();
		flowLayout.setVgap(Frame.frame.getHeight() / 10);
		buttonPanel = new JPanel();
		bUserPasswordReset = new JButton();
		bUserPasswordReset.setIcon(new ImageIcon(getClass().getResource(
				"/Resources/Question.png")));
		bUserPasswordReset.setText("Forgotten User/Password");
		bUserPasswordReset.addActionListener(this);
		bLogin = new JButton();
		bLogin.setIcon(new ImageIcon(getClass().getResource(
				"/Resources/086817-simple-red-glossy-icon-business-key7.png")));
		bLogin.setText("Login");
		bLogin.addActionListener(this);
		bNewUser = new JButton();
		bNewUser.setIcon(new ImageIcon(getClass().getResource(
				"/Resources/form_icon_25603.png")));
		bNewUser.setText("New User");
		bNewUser.addActionListener(this);
		

	}

	public void placeHeaderComponents() {

		header.add(lHeader);
		header.add(connectionStatus);

	}

	public void placeTextComponents() {
		textPanel.add(lUsername);
		textPanel.add(tfUsername);
		textPanel.add(lPassword);
		textPanel.add(tfPassword);
	}

	public void placeButtons() {
		buttonPanel.add(bUserPasswordReset);
		buttonPanel.add(bLogin);
		buttonPanel.add(bNewUser);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == bUserPasswordReset) {
			Frame window = (Frame) GUIUtilities.getPrincipalContainer(thisContainer);
			window.getContentPane().remove(0);
			window.getContentPane().add(new UserPasswordResetPanel());
			window.pack();
			window.repaint();
			window.setSize(560, 400);
			GUIUtilities.CenterWindow(window);
			
		}
		
		if(e.getSource() == bLogin){
			/*Frame window = (Frame) GUIUtilities.getPrincipalContainer(thisContainer);
			window.getContentPane().remove(0);
			window.getContentPane().add(new UserPasswordResetPanel());
			window.pack();
			window.repaint();
			GUIUtilities.CenterWindow(window);*/
			
			
		}
		
		if(e.getSource() == bNewUser){
			Frame window = (Frame) GUIUtilities.getPrincipalContainer(thisContainer);
			window.getContentPane().remove(0);
			window.getContentPane().add(new RegistryPanel());
			window.pack();
			window.repaint();
			window.setSize(480, 470);
			GUIUtilities.CenterWindow(window);
			
			
		}

	}

}
