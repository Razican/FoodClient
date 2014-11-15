package foodfinder.client.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

import org.apache.commons.validator.routines.EmailValidator;
import org.apache.uima.tools.util.gui.SpringUtilities;

import foodfinder.client.utilities.GUIUtilities;

public class UserPasswordResetPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
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
	private JPanel container;
	private JPanel container2;

	public UserPasswordResetPanel() {
		initializeVartiables();

		headerPanel.setLayout(new SpringLayout());
		placeHeaderComponents();
		SpringUtilities.makeCompactGrid(headerPanel, 1, 3, 30, 1, 70, 1);

		textPanel.setLayout(new SpringLayout());
		placeTextComponents();
		SpringUtilities.makeCompactGrid(textPanel, 1, 2, 6, 6, 6, 6);

		checkBoxPanel.setLayout(new SpringLayout());
		placeCheckBoxComponents();
		SpringUtilities.makeCompactGrid(checkBoxPanel, 1, 2, 125, 6, 50, 6);

		container.setLayout(new SpringLayout());
		container.add(headerPanel);
		container.add(Box.createVerticalStrut(20));
		container.add(textPanel);
		container.add(Box.createVerticalStrut(20));
		container.add(lQuestion);
		lQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(Box.createVerticalStrut(20));
		container.add(checkBoxPanel);
		container.add(Box.createVerticalStrut(20));
		bReset.setHorizontalAlignment(SwingConstants.CENTER);
		SpringUtilities.makeCompactGrid(container, 8, 1, 6, 6, 6, 6);

		container2.setLayout(new FlowLayout());
		container2.add(container);
		container2.add(bReset);
		container2.setPreferredSize(new Dimension(560, 400));
		this.add(container2);

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
		container2 = new JPanel();
		headerPanel = new JPanel();
		textPanel = new JPanel();
		checkBoxPanel = new JPanel();
		container = new JPanel();
		backButton =
				new JButton(new ImageIcon(getClass().getResource(
						"/resources/back-icon.png")));
		backButton.addActionListener(this);
		headerTitle = new JLabel("USER/PASSWORD RESET");
		connectionStatus =
				new JLabel(new ImageIcon(getClass().getResource(
						"/resources/Base Green Deep.png")));
		connectionStatus.setText("Connection Status:OK");
		lEmail = new JLabel("Email:");
		tfEmail = new JTextField(15);
		tfEmail.setText("Example:alvaro@gmail.com");
		tfEmail.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(final MouseEvent e) {
				if (tfEmail.getText().equals("Example:alvaro@gmail.com"))
					;
				{
					tfEmail.setText("");
				}
			}
		});
		tfEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				final int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER)
					reset();
			}
		});
		tfEmail.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(final FocusEvent e) {
				if (tfEmail.getText().equals("")) {
					tfEmail.setText("Example:alvaro@gmail.com");
				}

			}

			@Override
			public void focusGained(final FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
		cbUsername = new JCheckBox("Username");
		cbPassword = new JCheckBox("Password");
		lQuestion = new JLabel("What did you forgot?");
		bReset = new JButton();
		bReset.setText(" Reset ");
		bReset.setIcon(new ImageIcon(getClass().getResource(
				"/resources/images.jpeg")));
		bReset.addActionListener(this);

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
			reset();
		}

		if (e.getSource() == backButton) {
			final Frame window =
					(Frame) GUIUtilities.getMainContainer(container);
			window.getContentPane().remove(0);
			window.getContentPane().add(new LoginPanel());
			window.pack();
			window.setMinimumSize(new Dimension(560, 400));
			window.setSize(560, 400);
			GUIUtilities.CenterWindow(window);
		}

	}

	public void reset() {
		if (tfEmail.getText().equals("")
				|| tfEmail.getText().equals("Example:alvaro@gmail.com")) {

			JOptionPane.showMessageDialog(null, "Insert the email address.",
					"", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass()
							.getResource("/resources/errorIcon.png")));

		} else if (!cbPassword.isSelected() && !cbUsername.isSelected()) {
			JOptionPane.showMessageDialog(null,
					"Select what you want to reset.", "",
					JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass()
							.getResource("/resources/errorIcon.png")));
		}

		else if (!EmailValidator.getInstance().isValid(tfEmail.getText())) {
			JOptionPane.showMessageDialog(null, "Incorrect Email.", "",
					JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass()
							.getResource("/resources/errorIcon.png")));
		} else {

			final int optionType = JOptionPane.DEFAULT_OPTION;
			final int messageType = JOptionPane.QUESTION_MESSAGE;
			final ImageIcon icon =
					new ImageIcon(getClass().getResource(
							"/resources/nothing.png"));
			final Object[] selValues = { "No", "Yes" };
			final int selection =
					JOptionPane.showOptionDialog(null,
							"Are you sure you want to reset user/password?",
							"", optionType, messageType, icon, selValues,
							selValues[0]);
			if (selection == 1) {
				final Frame window =
						(Frame) GUIUtilities.getMainContainer(container);
				window.getContentPane().remove(0);
				window.getContentPane().add(new LoginPanel());
				window.pack();
				window.repaint();
				window.setMinimumSize(new Dimension(560, 400));
				window.setSize(560, 400);
				GUIUtilities.CenterWindow(window);
			}
		}
	}

}
