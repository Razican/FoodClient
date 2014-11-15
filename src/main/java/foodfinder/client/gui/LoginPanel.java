package foodfinder.client.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import org.apache.uima.tools.util.gui.SpringUtilities;

import foodfinder.client.api.Controller;
import foodfinder.client.utilities.GUIUtilities;

public class LoginPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1020165421212949639L;
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
		container2.add(thisContainer);

	}

	public void initializeVariables() {

		user = "Usuario";
		thisContainer = new JPanel();
		container2 = this;
		container2.setFocusable(true);
		container2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				final int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER)
					login();
			}
		});
		thisContainer.setPreferredSize(new Dimension(560, 420));
		header = new JPanel();
		lHeader = new JLabel("PRODUCT FINDER");
		getConnectionLabel();
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
		tfUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				final int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER)
					login();
			}
		});
		tfUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(final FocusEvent e) {
				if (tfUsername.getText().equals("")) {
					tfUsername.setText("Example:Peio");
				}
			}
		});
		lPassword = new JLabel("Password:");
		tfPassword = new JPasswordField(20);
		tfPassword.setEchoChar((char) 0);
		tfPassword.setText("Example:1234");
		tfPassword.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(final MouseEvent e) {
				if (Arrays.equals(tfPassword.getPassword(),
						"Example:1234".toCharArray())) {
					tfPassword.setText("");
					tfPassword.setEchoChar('*');
				}
			}
		});
		tfPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				final int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER)
					login();
			}
		});
		tfPassword.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(final FocusEvent e) {
				if (Arrays.equals(tfPassword.getPassword(), "".toCharArray())) {
					tfPassword.setText("Example:1234");
					tfPassword.setEchoChar((char) 0);
				}
			}
		});
		flowLayout = new FlowLayout();
		flowLayout.setVgap(Frame.frame.getHeight() / 10);
		buttonPanel = new JPanel();
		bUserPasswordReset = new JButton();
		bUserPasswordReset.setIcon(new ImageIcon(getClass().getResource(
				"/question-icon.png")));
		bUserPasswordReset.setText("Forgotten User/Password");
		bUserPasswordReset.addActionListener(this);
		bLogin = new JButton();
		bLogin.setIcon(new ImageIcon(getClass().getResource("/key-icon.png")));
		bLogin.setText("Login");
		bLogin.addActionListener(this);
		bNewUser = new JButton();
		bNewUser.setIcon(new ImageIcon(getClass().getResource(
				"/register-icon.png")));
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
			final JFrame window =
					(JFrame) GUIUtilities.getMainContainer(thisContainer);
			window.getContentPane().remove(0);
			window.getContentPane().add(new PasswordResetPanel());
			window.pack();
			window.repaint();
			window.setSize(560, 400);
			GUIUtilities.CenterWindow(window);
		}

		if (e.getSource() == bLogin) {
			boolean example = false;
			if (tfUsername.getText().equals("Example:Peio")
					|| Arrays.equals(tfPassword.getPassword(),
							"Example:1234".toCharArray())) {
				example = true;
				tfUsername.setText("");
				tfPassword.setText("");
				tfPassword.setEchoChar('*');
			}

			login();

			if (example) {
				tfUsername.setText("Example:Peio");
				tfPassword.setText("Example:1234");
				tfPassword.setEchoChar((char) 0);
			}
		}

		if (e.getSource() == bNewUser) {
			final JFrame window = (JFrame) GUIUtilities.getMainContainer(container2);
			window.getContentPane().remove(0);
			window.getContentPane().add(new RegistryPanel());
			window.pack();
			window.repaint();
			window.setMinimumSize(new Dimension(480, 470));
			window.setSize(480, 470);
			GUIUtilities.CenterWindow(window);
		}
	}

	public void getConnectionLabel() {
		if (Controller.checkStatus() == true) {
			connectionStatus =
					new JLabel(new ImageIcon(getClass().getResource(
							"/status-OK.png")));
			connectionStatus.setToolTipText("Connection Status: OK");
		} else {
			connectionStatus =
					new JLabel(new ImageIcon(getClass().getResource(
							"/status-ERR.png")));
			connectionStatus.setToolTipText("Connection Status: ERROR");
		}
	}

	public void login() {
		String loginResponse = null;
		if (Controller.checkStatus()) {
			try {
				loginResponse =
						Controller.login(tfUsername.getText(),
								tfPassword.getPassword());
			} catch (final IOException e) {
				e.printStackTrace();
			}
		}
		if (loginResponse == null) {

			welcomeMessage = "Welcome " + user + "!";
			JOptionPane.showMessageDialog(null, welcomeMessage, "",
					JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass()
							.getResource("/empty.png")));
			final JFrame window =
					(JFrame) GUIUtilities.getMainContainer(thisContainer);
			window.getContentPane().remove(0);
			window.getContentPane().add(new SearchPanel());
			window.pack();
			window.repaint();
			window.setMinimumSize(new Dimension(600, 710));
			window.setSize(600, 710);
			GUIUtilities.CenterWindow(window);
<<<<<<< HEAD
		}

		 else {
=======
		} else if (loginResponse.equals("Insert username and password.")) {
			JOptionPane.showMessageDialog(null, "Insert username or password.",
					"", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass()
							.getResource("/error-icon.png")));
		} else {
>>>>>>> FETCH_HEAD
			// TODO Show error in loginResponse.get("error")
			JOptionPane.showMessageDialog(null, loginResponse, "",
					JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass()
							.getResource("/error-icon.png")));
		}
	}

}