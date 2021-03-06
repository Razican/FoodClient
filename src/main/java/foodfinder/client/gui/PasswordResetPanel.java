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

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import org.apache.uima.tools.util.gui.SpringUtilities;

import foodfinder.client.api.Controller;
import foodfinder.client.gui.components.Frame;

public class PasswordResetPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 7978489183613836147L;

	private JButton backButton;
	private JLabel headerTitle;
	private JLabel connectionStatus;
	private JLabel lEmail;
	private JTextField tfEmail;
	private JLabel lQuestion;
	private JCheckBox cbUsername;
	private JCheckBox cbPassword;
	private JButton bReset;
	private JPanel headerPanel;
	private JPanel textPanel;
	private JPanel checkBoxPanel;
	private JPanel formPanel;
	private StatusThread statusThread;

	public PasswordResetPanel() {
		initializeVartiables();
		statusThread.start();
		headerPanel.setLayout(new SpringLayout());
		placeHeaderComponents();
		SpringUtilities.makeCompactGrid(headerPanel, 1, 3, 30, 1, 70, 1);

		textPanel.setLayout(new SpringLayout());
		placeTextComponents();
		SpringUtilities.makeCompactGrid(textPanel, 1, 2, 6, 6, 6, 6);

		checkBoxPanel.setLayout(new SpringLayout());
		placeCheckBoxComponents();
		SpringUtilities.makeCompactGrid(checkBoxPanel, 1, 2, 125, 6, 50, 6);

		formPanel.setLayout(new SpringLayout());
		formPanel.add(headerPanel);
		formPanel.add(Box.createVerticalStrut(20));
		formPanel.add(textPanel);
		formPanel.add(Box.createVerticalStrut(20));
		formPanel.add(lQuestion);
		lQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		formPanel.add(Box.createVerticalStrut(20));
		formPanel.add(checkBoxPanel);
		formPanel.add(Box.createVerticalStrut(20));
		bReset.setHorizontalAlignment(SwingConstants.CENTER);
		SpringUtilities.makeCompactGrid(formPanel, 8, 1, 6, 6, 6, 6);

		setLayout(new FlowLayout());
		add(formPanel);
		add(bReset);
		setPreferredSize(new Dimension(560, 400));

		Frame.getInstance().addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(final WindowEvent e) {
				statusThread.interrupt();
			}
		});
	}

	public void initializeVartiables() {
		this.setFocusable(true);
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				final int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER)
					reset();
			}
		});
		headerPanel = new JPanel();
		textPanel = new JPanel();
		checkBoxPanel = new JPanel();
		formPanel = new JPanel();
		backButton = new JButton(new ImageIcon(getClass().getResource("/back-icon.png")));
		backButton.addActionListener(this);
		backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		headerTitle = new JLabel("USER/PASSWORD RESET");

		if (Controller.checkStatus() == true) {
			connectionStatus = new JLabel(new ImageIcon(getClass().getResource("/status-OK.png")));
			connectionStatus.setToolTipText("Connection Status: OK");
		} else {
			connectionStatus = new JLabel(new ImageIcon(getClass().getResource("/status-ERR.png")));
			connectionStatus.setToolTipText("Connection Status: ERROR");
		}

		lEmail = new JLabel("Email:");
		tfEmail = new JTextField(15);
		tfEmail.setText("Example:alvaro@gmail.com");
		tfEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				final int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER)
					reset();
			}
		});
		tfEmail.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(final FocusEvent e) {
				if (tfEmail.getText().equals("")) {
					tfEmail.setText("Example:alvaro@gmail.com");
				}
			}

			@Override
			public void focusGained(final FocusEvent e) {
				if (tfEmail.getText().equals("Example:alvaro@gmail.com")) {
					tfEmail.setText("");
				}
			}
		});
		cbUsername = new JCheckBox("Username");
		cbPassword = new JCheckBox("Password");
		lQuestion = new JLabel("What did you forgot?");
		bReset = new JButton();
		bReset.setText(" Reset ");
		bReset.setIcon(new ImageIcon(getClass().getResource("/reset-icon.png")));
		bReset.addActionListener(this);
		bReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		statusThread = new StatusThread(connectionStatus);
	}

	public void placeHeaderComponents() {
		headerPanel.add(backButton);
		headerPanel.add(headerTitle);
		headerPanel.add(connectionStatus);
	}

	public void placeTextComponents() {
		textPanel.add(lEmail);
		textPanel.add(tfEmail);
	}

	public void placeCheckBoxComponents() {
		checkBoxPanel.add(cbUsername);
		checkBoxPanel.add(cbPassword);
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		if (e.getSource() == bReset) {

			if (tfEmail.getText().equals("Example:alvaro@gmail.com")) {
				tfEmail.setText("");
			}

			reset();
			tfEmail.setText("Example:alvaro@gmail.com");
		}

		if (e.getSource() == backButton) {
			statusThread.interrupt();

			Frame.getInstance().getContentPane().remove(0);
			Frame.getInstance().getContentPane().add(new LoginPanel());
			Frame.getInstance().setMinimumSize(new Dimension(560, 400));
			Frame.getInstance().setSize(560, 400);
			Frame.getInstance().setMaximumSize(new Dimension(700, 550));
			Frame.getInstance().pack();
			Frame.getInstance().repaint();
			Frame.getInstance().setLocationRelativeTo(null);
		}
	}

	public void reset() {
		String resetResponse = null;
		if (Controller.checkStatus()) {
			try {
				resetResponse =
						Controller.resetPassword(tfEmail.getText(), cbUsername.isSelected(),
								cbPassword.isSelected());
			} catch (final IOException e) {
				e.printStackTrace();
			}
		}

		if (resetResponse == null) {

			final int optionType = JOptionPane.DEFAULT_OPTION;
			final int messageType = JOptionPane.QUESTION_MESSAGE;
			final ImageIcon icon = new ImageIcon(getClass().getResource("/empty.png"));
			final Object[] selValues = { "No", "Yes" };
			final int selection =
					JOptionPane.showOptionDialog(null,
							"Are you sure you want to reset user/password?", "Confirmation",
							optionType, messageType, icon, selValues, selValues[0]);
			if (selection == 1) {
				statusThread.interrupt();
				Frame.getInstance().getContentPane().remove(0);
				Frame.getInstance().getContentPane().add(new LoginPanel());
				Frame.getInstance().setMinimumSize(new Dimension(560, 400));
				Frame.getInstance().setSize(560, 400);
				Frame.getInstance().setMaximumSize(new Dimension(700, 550));
				Frame.getInstance().pack();
				Frame.getInstance().repaint();
				Frame.getInstance().setLocationRelativeTo(null);
			}
		} else {
			JOptionPane.showMessageDialog(null, resetResponse, "Error", JOptionPane.ERROR_MESSAGE,
					new ImageIcon(getClass().getResource("/error-icon.png")));
		}
	}
}