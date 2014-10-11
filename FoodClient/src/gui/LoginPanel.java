package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import razican.utils.StringUtils;
import utilities.GUIUtilities;
import utilities.SpringUtilities;
import api.Api;
import api.JSONObject;

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
	private JPanel container2;
	private String user;
	private String welcomeMessage;

	public LoginPanel() {
		initializeVariables();

		header.setLayout(new SpringLayout());
		placeHeaderComponents();
		SpringUtilities.makeCompactGrid(header, 1, 2, ((Frame.frame.getWidth() / 2) + 25), 1, Frame.frame.getWidth() / 4, 0);

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
		container2.add(thisContainer);

	}

	public void initializeVariables() {
		user = "Usuario";
		thisContainer = new JPanel();
		container2 = this;
		thisContainer.setPreferredSize(new Dimension(560, 420));
		header = new JPanel();
		lHeader = new JLabel("PRODUCT FINDER");
		connectionStatus = new JLabel(new ImageIcon(getClass().getResource("/resources/Base Green Deep.png")));
		connectionStatus.setToolTipText("Connection Status: OK");
		textPanel = new JPanel();
		lUsername = new JLabel("Username:");
		tfUsername = new JTextField(20);
		tfUsername.setText("Example:Peio");
		tfUsername.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(final MouseEvent e) {
				if (tfUsername.getText().equals("Example:Peio")) {
					tfUsername.setText("");
				}
			}
		});
		tfUsername.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(final FocusEvent e) {
				if (tfUsername.getText().equals("")) {
					tfUsername.setText("Example:Peio");
				}
			}

			@Override
			public void focusGained(final FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
		lPassword = new JLabel("Password:");
		tfPassword = new JPasswordField(20);
		tfPassword.setEchoChar((char) 0);
		tfPassword.setText("Example:1234");
		tfPassword.addMouseListener(new MouseAdapter() {

			@SuppressWarnings("deprecation")
			@Override
			public void mousePressed(final MouseEvent e) {
				if (tfPassword.getText().equals("Example:1234")) {
					tfPassword.setText("");
					tfPassword.setEchoChar('*');
				}
			}
		});
		tfPassword.addFocusListener(new FocusListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(final FocusEvent e) {
				if (tfPassword.getText().equals("")) {
					tfPassword.setText("Example:1234");
					tfPassword.setEchoChar((char) 0);
				}
			}

			@Override
			public void focusGained(final FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
		flowLayout = new FlowLayout();
		flowLayout.setVgap(Frame.frame.getHeight() / 10);
		buttonPanel = new JPanel();
		bUserPasswordReset = new JButton();
		bUserPasswordReset.setIcon(new ImageIcon(getClass().getResource("/resources/Question.png")));
		bUserPasswordReset.setText("Forgotten User/Password");
		bUserPasswordReset.addActionListener(this);
		bLogin = new JButton();
		bLogin.setIcon(new ImageIcon(getClass().getResource("/resources/086817-simple-red-glossy-icon-business-key7.png")));
		bLogin.setText("Login");
		bLogin.addActionListener(this);
		bNewUser = new JButton();
		bNewUser.setIcon(new ImageIcon(getClass().getResource("/resources/form_icon_25603.png")));
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
	public void actionPerformed(final ActionEvent e) {
		if (e.getSource() == bUserPasswordReset) {
			final Frame window = (Frame) GUIUtilities.getPrincipalContainer(thisContainer);
			window.getContentPane().remove(0);
			window.getContentPane().add(new UserPasswordResetPanel());
			window.pack();
			window.repaint();
			window.setSize(560, 400);
			GUIUtilities.CenterWindow(window);
		}

		if (e.getSource() == bLogin) {

			final JSONObject loginResponse = Api.login(tfUsername.getText(), StringUtils.sha1(tfPassword.getPassword()));

			if (tfUsername.getText().equals("") || tfPassword.getText().equals("") || tfUsername.getText().equals("Example:Peio") || tfPassword.getText().equals("Example:1234")) {
				JOptionPane.showMessageDialog(null, "Insert username or password.", "", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/resources/errorIcon.png")));
			}

			else if (loginResponse.get("status").equals("OK")) {

				welcomeMessage = "Welcome " + user + "!";
				JOptionPane.showMessageDialog(null, welcomeMessage, "", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/resources/nothing.png")));
				final Frame window = (Frame) GUIUtilities.getPrincipalContainer(thisContainer);
				window.getContentPane().remove(0);
				window.getContentPane().add(new SearchPanel());
				window.pack();
				window.repaint();
				window.setMinimumSize(new Dimension(600, 710));
				window.setSize(600, 710);
				GUIUtilities.CenterWindow(window);
			}
		} else {
			// TODO Show error in loginResponse.get("error")
			JOptionPane.showMessageDialog(null, "Incorrect username or password.", "", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/resources/errorIcon.png")));
		}

		if (e.getSource() == bNewUser) {
			final Frame window = (Frame) GUIUtilities.getPrincipalContainer(thisContainer);
			window.getContentPane().remove(0);
			window.getContentPane().add(new RegistryPanel());
			window.pack();
			window.repaint();
			window.setMinimumSize(new Dimension(480, 470));
			window.setSize(480, 470);
			GUIUtilities.CenterWindow(window);
		}
	}
}