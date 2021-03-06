package foodfinder.client.gui;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import org.apache.uima.tools.util.gui.SpringUtilities;

import foodfinder.client.api.Controller;
import foodfinder.client.gui.components.Frame;

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
	private JLabel lconnectionStatus;
	private JPanel headerPanel;
	private JPanel formPanel;
	private JPanel buttonPanel;
	private String welcomeMessage;
	private StatusThread statusThread;

	public LoginPanel() {
		initializeVariables();

		statusThread.start();

		headerPanel.setLayout(new SpringLayout());
		placeHeaderComponents();
		SpringUtilities.makeCompactGrid(headerPanel, 1, 2,
				((Frame.getInstance().getWidth() / 2) + 25), 1, Frame.getInstance().getWidth() / 4,
				0);

		formPanel.setLayout(new SpringLayout());
		placeTextComponents();
		SpringUtilities.makeCompactGrid(formPanel, 2, 2, 6, 6, 6, 6);

		buttonPanel.setLayout(new FlowLayout());
		placeButtons();

		final FlowLayout layout = new FlowLayout();
		layout.setVgap(Frame.getInstance().getHeight() / 10);
		setLayout(layout);
		add(headerPanel);
		add(Box.createVerticalStrut(40));
		add(formPanel);
		add(Box.createVerticalStrut(40));
		add(buttonPanel);

		Frame.getInstance().addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(final WindowEvent e) {
				statusThread.interrupt();
			}
		});
	}

	public void initializeVariables() {

		setFocusable(true);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				final int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER)
					login();
			}
		});
		setPreferredSize(new Dimension(560, 400));
		headerPanel = new JPanel();
		lHeader = new JLabel("PRODUCT FINDER");

		if (Controller.checkStatus() == true) {
			lconnectionStatus = new JLabel(new ImageIcon(getClass().getResource("/status-OK.png")));
			lconnectionStatus.setToolTipText("Connection Status: OK");
		} else {
			lconnectionStatus =
					new JLabel(new ImageIcon(getClass().getResource("/status-ERR.png")));
			lconnectionStatus.setToolTipText("Connection Status: ERROR");
		}

		formPanel = new JPanel();
		lUsername = new JLabel("Username:");
		tfUsername = new JTextField(20);
		tfUsername.setText("Example: Peio");
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
					tfUsername.setText("Example: Peio");
				}
			}

			@Override
			public void focusGained(final FocusEvent e) {
				if (tfUsername.getText().equals("Example: Peio")) {
					tfUsername.setText("");
				}
			}
		});
		lPassword = new JLabel("Password:");
		tfPassword = new JPasswordField(20);
		tfPassword.setEchoChar((char) 0);
		tfPassword.setText("Example: 1234");
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
					tfPassword.setText("Example: 1234");
					tfPassword.setEchoChar((char) 0);
				}
			}

			@Override
			public void focusGained(final FocusEvent e) {
				if (Arrays.equals(tfPassword.getPassword(), "Example: 1234".toCharArray())) {
					tfPassword.setText("");
					tfPassword.setEchoChar('*');
				}
			}
		});

		buttonPanel = new JPanel();
		bUserPasswordReset = new JButton();
		bUserPasswordReset.setIcon(new ImageIcon(getClass().getResource("/question-icon.png")));
		bUserPasswordReset.setText("Forgotten User/Password");
		bUserPasswordReset.addActionListener(this);
		bUserPasswordReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bLogin = new JButton();
		bLogin.setIcon(new ImageIcon(getClass().getResource("/key-icon.png")));
		bLogin.setText("Login");
		bLogin.addActionListener(this);
		bLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bNewUser = new JButton();
		bNewUser.setIcon(new ImageIcon(getClass().getResource("/register-icon.png")));
		bNewUser.setText("New User");
		bNewUser.addActionListener(this);
		bNewUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		statusThread = new StatusThread(lconnectionStatus);
	}

	public void placeHeaderComponents() {

		headerPanel.add(lHeader);
		headerPanel.add(lconnectionStatus);

	}

	public void placeTextComponents() {
		formPanel.add(lUsername);
		formPanel.add(tfUsername);
		formPanel.add(lPassword);
		formPanel.add(tfPassword);
	}

	public void placeButtons() {
		buttonPanel.add(bUserPasswordReset);
		buttonPanel.add(bLogin);
		buttonPanel.add(bNewUser);
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		if (e.getSource() == bUserPasswordReset) {

			Frame.getInstance().getContentPane().remove(0);
			Frame.getInstance().getContentPane().add(new PasswordResetPanel());
			Frame.getInstance().setMinimumSize(new Dimension(560, 400));
			Frame.getInstance().setSize(560, 400);
			Frame.getInstance().setMaximumSize(new Dimension(700, 550));
			Frame.getInstance().pack();
			Frame.getInstance().repaint();
			Frame.getInstance().setLocationRelativeTo(null);
		}

		if (e.getSource() == bLogin) {
			login();
		}

		if (e.getSource() == bNewUser) {
			statusThread.interrupt();

			Frame.getInstance().getContentPane().remove(0);
			Frame.getInstance().getContentPane().add(new RegistryPanel());
			Frame.getInstance().setMinimumSize(new Dimension(480, 470));
			Frame.getInstance().setSize(480, 470);
			Frame.getInstance().setMaximumSize(new Dimension(700, 550));
			Frame.getInstance().pack();
			Frame.getInstance().repaint();
			Frame.getInstance().setLocationRelativeTo(null);
		}
	}

	public void login() {
		String loginResponse = null;
		final String username =
				tfUsername.getText().equals("Example: Peio") ? "" : tfUsername.getText();
		final char[] password =
				Arrays.equals(tfPassword.getPassword(), "Example: 1234".toCharArray()) ? null
						: tfPassword.getPassword();

		if (Controller.checkStatus()) {
			try {
				loginResponse = Controller.login(username, password);
			} catch (final IOException e) {
				lconnectionStatus =
						new JLabel(new ImageIcon(getClass().getResource("/status-ERR.png")));
				lconnectionStatus.setToolTipText("Connection Status: ERROR");
			}
		} else {
			lconnectionStatus =
					new JLabel(new ImageIcon(getClass().getResource("/status-ERR.png")));
			lconnectionStatus.setToolTipText("Connection Status: ERROR");
		}

		if (loginResponse == null) {

			welcomeMessage = "Welcome " + username + "!";
			JOptionPane.showMessageDialog(null, welcomeMessage, "Welcome",
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon(getClass().getResource("/empty.png")));

			statusThread.interrupt();

			Frame.getInstance().getContentPane().remove(0);
			Frame.getInstance().getContentPane().add(new SearchPanel());
			Frame.getInstance().setMinimumSize(new Dimension(600, 710));
			Frame.getInstance().setSize(600, 710);
			Frame.getInstance().setMaximumSize(new Dimension(700, 710));
			Frame.getInstance().pack();
			Frame.getInstance().repaint();
			Frame.getInstance().setLocationRelativeTo(null);
		} else {
			JOptionPane.showMessageDialog(null, loginResponse, "Error", JOptionPane.ERROR_MESSAGE,
					new ImageIcon(getClass().getResource("/error-icon.png")));
		}
	}
}