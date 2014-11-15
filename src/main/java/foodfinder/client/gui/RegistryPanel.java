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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import org.apache.commons.validator.routines.EmailValidator;
import org.apache.uima.tools.util.gui.SpringUtilities;

import foodfinder.client.utilities.GUIUtilities;

public class RegistryPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 4213375059006626818L;
	private JTextField tfName;
	private JTextField tfLastName;
	private JTextField tfEmail;
	private JTextField tfUsername;
	private JPasswordField tfPassword;
	private JPasswordField tfPassword2;
	private JCheckBox cbGluten;
	private JCheckBox cbDiabetes;
	private JCheckBox cbVegetables;
	private JCheckBox cbMilk;
	private JLabel lName;
	private JLabel lLastName;
	private JLabel lEmail;
	private JLabel lUsername;
	private JLabel lPassword;
	private JLabel lPassword2;
	private JLabel lHealthIssues;
	private JButton bRegister;
	private JPanel textFieldPanel;
	private JPanel checkBoxIssuePanel;
	private JPanel checkBoxIssuePanel1;
	private JPanel checkBoxIssuePanel2;
	private JPanel headerPanel;
	private JButton backButton;
	private JLabel headerTitle;
	private JLabel connectionStatus;
	private JButton registerButton;
	private JPanel container;
	private JPanel container2;

	public RegistryPanel() {
		initializeVariables();

		headerPanel.setLayout(new SpringLayout());
		placeHeaderComponents();
		SpringUtilities.makeCompactGrid(headerPanel, 1, 3, 30, 1, 70, 1);

		textFieldPanel.setLayout(new SpringLayout());
		placeComponentsText();
		SpringUtilities.makeCompactGrid(textFieldPanel, 6, 2, 6, 6, 6, 6);

		checkBoxIssuePanel.setLayout(new SpringLayout());
		checkBoxIssuePanel1.setLayout(new SpringLayout());
		placeCheckBoxIssue1();
		SpringUtilities
				.makeCompactGrid(checkBoxIssuePanel1, 1, 1, 1, 1, 50, 50);
		checkBoxIssuePanel2.setLayout(new SpringLayout());
		placeCheckBoxIssue2();
		SpringUtilities
				.makeCompactGrid(checkBoxIssuePanel2, 2, 2, 10, 0, 30, 0);

		checkBoxIssuePanel.add(checkBoxIssuePanel1);
		checkBoxIssuePanel.add(checkBoxIssuePanel2);
		SpringUtilities.makeCompactGrid(checkBoxIssuePanel, 1, 2, 6, 6, 6, 6);

		container.setLayout(new SpringLayout());
		container.add(headerPanel);
		container.add(textFieldPanel);
		container.add(checkBoxIssuePanel);
		SpringUtilities.makeCompactGrid(container, 3, 1, 6, 6, 6, 6);

		container2.setLayout(new FlowLayout());
		container2.add(container);
		container2.add(registerButton);
		this.add(container2);

	}

	public void initializeVariables() {
		this.setFocusable(true);
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				final int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER)
					register();
			}
		});
		container2 = new JPanel();
		container2.setPreferredSize(new Dimension(480, 470));
		textFieldPanel = new JPanel();
		checkBoxIssuePanel = new JPanel();
		checkBoxIssuePanel1 = new JPanel();
		checkBoxIssuePanel2 = new JPanel();
		tfName = new JTextField(20);
		tfName.setText("Example:Patxi");
		tfName.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(final MouseEvent e) {
				if (tfName.getText().equals("Example:Patxi")) {
					tfName.setText("");
				}

			}

		});
		tfName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				final int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER)
					register();
			}
		});
		tfName.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(final FocusEvent e) {
				if (tfName.getText().equals("")) {
					tfName.setText("Example:Patxi");
				}

			}

			@Override
			public void focusGained(final FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
		tfLastName = new JTextField(20);
		tfLastName.setText("Example:Lopez");
		tfLastName.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(final MouseEvent e) {
				if (tfLastName.getText().equals("Example:Lopez")) {
					tfLastName.setText("");
				}
			}
		});
		tfLastName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				final int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER)
					register();
			}
		});
		tfLastName.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(final FocusEvent e) {
				if (tfLastName.getText().equals("")) {
					tfLastName.setText("Example:Lopez");
				}

			}

			@Override
			public void focusGained(final FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
		tfEmail = new JTextField(20);
		tfEmail.setText("Example:alvaro@gmail.com");
		tfEmail.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(final MouseEvent e) {
				if (tfEmail.getText().equals("Example:alvaro@gmail.com")) {
					tfEmail.setText("");
				}

			}
		});
		tfEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				final int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER)
					register();
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
					register();
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
		tfPassword = new JPasswordField(20);
		tfPassword.setText("Example:1234");
		tfPassword.setEchoChar((char) 0);
		tfPassword.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(final MouseEvent e) {
				if (tfPassword.getText().equals("Example:1234")) {
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
					register();
			}
		});
		tfPassword.addFocusListener(new FocusListener() {

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
		tfPassword2 = new JPasswordField(20);
		tfPassword2.setText("Example:1234");
		tfPassword2.setEchoChar((char) 0);
		tfPassword2.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(final MouseEvent e) {
				if (tfPassword2.getText().equals("Example:1234")) {
					tfPassword2.setText("");
					tfPassword2.setEchoChar('*');
				}

			}
		});
		tfPassword2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				final int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER)
					register();
			}
		});
		tfPassword2.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(final FocusEvent e) {
				if (tfPassword2.getText().equals("")) {
					tfPassword2.setText("Example:1234");
					tfPassword2.setEchoChar((char) 0);
				}

			}

			@Override
			public void focusGained(final FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
		cbGluten = new JCheckBox("Gluten");
		cbDiabetes = new JCheckBox("Diabetes");
		cbVegetables = new JCheckBox("Vegetables");
		cbMilk = new JCheckBox("Milk");
		lName = new JLabel("Name:");
		lLastName = new JLabel("Last Name:");
		lEmail = new JLabel("Email:");
		lUsername = new JLabel("Username:");
		lPassword = new JLabel("Password:");
		lPassword2 = new JLabel("Repeat Password:");
		lHealthIssues = new JLabel("Health Issues:");
		bRegister = new JButton("Register");
		headerPanel = new JPanel();
		backButton =
				new JButton(new ImageIcon(getClass().getResource(
						"/resources/back-icon.png")));
		backButton.addActionListener(this);
		headerTitle = new JLabel("REGISTER");
		connectionStatus =
				new JLabel(new ImageIcon(getClass().getResource(
						"/resources/Base Green Deep.png")));
		connectionStatus.setToolTipText("Connection Status:OK");
		container = new JPanel();
		registerButton = new JButton();
		registerButton.setIcon(new ImageIcon(getClass().getResource(
				"/resources/form_icon_25603.png")));
		registerButton.setText("Register");
		registerButton.addActionListener(this);

	}

	public void placeHeaderComponents() {
		headerPanel.add(backButton);
		headerPanel.add(headerTitle);
		headerPanel.add(connectionStatus);
	}

	public void placeComponentsText() {
		textFieldPanel.add(lName);
		textFieldPanel.add(tfName);
		textFieldPanel.add(lLastName);
		textFieldPanel.add(tfLastName);
		textFieldPanel.add(lEmail);
		textFieldPanel.add(tfEmail);
		textFieldPanel.add(lUsername);
		textFieldPanel.add(tfUsername);
		textFieldPanel.add(lPassword);
		textFieldPanel.add(tfPassword);
		textFieldPanel.add(lPassword2);
		textFieldPanel.add(tfPassword2);

	}

	public void placeCheckBoxIssue1() {
		lHealthIssues.setHorizontalAlignment(JLabel.RIGHT);
		checkBoxIssuePanel1.add(lHealthIssues);

	}

	public void placeCheckBoxIssue2() {
		checkBoxIssuePanel2.add(cbGluten);
		checkBoxIssuePanel2.add(cbDiabetes);
		checkBoxIssuePanel2.add(cbVegetables);
		checkBoxIssuePanel2.add(cbMilk);
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		if (e.getSource() == registerButton) {
			register();
		}
		if (e.getSource() == backButton) {
			final Frame window =
					(Frame) GUIUtilities.getMainContainer(container);
			window.getContentPane().remove(0);
			window.getContentPane().add(new LoginPanel());
			window.pack();
			window.repaint();
			window.setMinimumSize(new Dimension(560, 420));
			window.setSize(560, 420);
			GUIUtilities.CenterWindow(window);
		}

	}

	public void register() {
		if (tfName.getText().equals("") || tfLastName.getText().equals("")
				|| tfEmail.getText().equals("")
				|| tfPassword.getText().equals("")
				|| tfPassword2.getText().equals("")
				|| tfUsername.getText().equals("")) {
			JOptionPane.showMessageDialog(null,
					"You must fill all the fields.", "",
					JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass()
							.getResource("/resources/errorIcon.png")));

		} else if (!tfPassword.getText().equals(tfPassword2.getText())) {
			JOptionPane.showMessageDialog(null, "Passwords don't match.", "",
					JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass()
							.getResource("/resources/errorIcon.png")));

		} else if (!EmailValidator.getInstance().isValid(tfEmail.getText())) {
			JOptionPane.showMessageDialog(null,
					"You must provide a valid email.", "",
					JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass()
							.getResource("/resources/errorIcon.png")));
		}
		// TODO Username exists or email exist validation missing.
	}
}
