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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import org.apache.uima.tools.util.gui.SpringUtilities;

import foodfinder.client.api.Controller;
import foodfinder.client.gui.components.Frame;

public class RegistryPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 4213375059006626818L;
	private JTextField tfName;
	private JTextField tfLastName;
	private JTextField tfEmail;
	private JTextField tfUsername;
	private JPasswordField tfPassword;
	private JPasswordField tfPassConf;
	private JCheckBox cbGluten;
	private JCheckBox cbDiabetes;
	private JCheckBox cbVegetables;
	private JCheckBox cbMilk;
	private JLabel lName;
	private JLabel lLastName;
	private JLabel lEmail;
	private JLabel lUsername;
	private JLabel lPassword;
	private JLabel lPassConf;
	private JLabel lHealthIssues;
	private JPanel textFieldPanel;
	private JPanel checkBoxIssuePanel;
	private JPanel checkBoxIssuePanel1;
	private JPanel checkBoxIssuePanel2;
	private JPanel headerPanel;
	private JButton backButton;
	private JLabel headerTitle;
	private JLabel connectionStatus;
	private JButton registerButton;
	private JPanel formPanel;
	private StatusThread statusThread;

	public RegistryPanel() {
		initializeVariables();

		statusThread.start();

		headerPanel.setLayout(new SpringLayout());
		placeHeaderComponents();
		SpringUtilities.makeCompactGrid(headerPanel, 1, 3, 30, 1, 70, 1);

		textFieldPanel.setLayout(new SpringLayout());
		placeComponentsText();
		SpringUtilities.makeCompactGrid(textFieldPanel, 6, 2, 6, 6, 6, 6);

		checkBoxIssuePanel.setLayout(new SpringLayout());
		checkBoxIssuePanel1.setLayout(new SpringLayout());
		placeCheckBoxIssue1();
		SpringUtilities.makeCompactGrid(checkBoxIssuePanel1, 1, 1, 1, 1, 50, 50);
		checkBoxIssuePanel2.setLayout(new SpringLayout());
		placeCheckBoxIssue2();
		SpringUtilities.makeCompactGrid(checkBoxIssuePanel2, 2, 2, 10, 0, 30, 0);

		checkBoxIssuePanel.add(checkBoxIssuePanel1);
		checkBoxIssuePanel.add(checkBoxIssuePanel2);
		SpringUtilities.makeCompactGrid(checkBoxIssuePanel, 1, 2, 6, 6, 6, 6);

		formPanel.setLayout(new SpringLayout());
		formPanel.add(headerPanel);
		formPanel.add(textFieldPanel);
		formPanel.add(checkBoxIssuePanel);
		SpringUtilities.makeCompactGrid(formPanel, 3, 1, 6, 6, 6, 6);

		setLayout(new FlowLayout());
		add(formPanel);
		add(registerButton);

		Frame.getInstance().addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(final WindowEvent e) {
				statusThread.interrupt();
			}
		});
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

		setPreferredSize(new Dimension(480, 470));
		textFieldPanel = new JPanel();
		checkBoxIssuePanel = new JPanel();
		checkBoxIssuePanel1 = new JPanel();
		checkBoxIssuePanel2 = new JPanel();
		tfName = new JTextField(20);
		tfName.setText("Example: Patxi");
		tfName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				final int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER)
					register();
			}
		});
		tfName.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(final FocusEvent e) {
				if (tfName.getText().equals("")) {
					tfName.setText("Example: Patxi");
				}
			}

			@Override
			public void focusGained(final FocusEvent e) {
				if (tfName.getText().equals("Example: Patxi")) {
					tfName.setText("");
				}
			}
		});
		tfLastName = new JTextField(20);
		tfLastName.setText("Example: Lopez");
		tfLastName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				final int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER)
					register();
			}
		});
		tfLastName.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(final FocusEvent e) {
				if (tfLastName.getText().equals("")) {
					tfLastName.setText("Example: Lopez");
				}
			}

			@Override
			public void focusGained(final FocusEvent e) {
				if (tfLastName.getText().equals("Example: Lopez")) {
					tfLastName.setText("");
				}
			}
		});
		tfEmail = new JTextField(20);
		tfEmail.setText("Example: alvaro@gmail.com");
		tfEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				final int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER)
					register();
			}
		});
		tfEmail.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(final FocusEvent e) {
				if (tfEmail.getText().equals("")) {
					tfEmail.setText("Example: alvaro@gmail.com");
				}
			}

			@Override
			public void focusGained(final FocusEvent e) {
				if (tfEmail.getText().equals("Example: alvaro@gmail.com")) {
					tfEmail.setText("");
				}
			}
		});
		tfUsername = new JTextField(20);
		tfUsername.setText("Example: Peio");
		tfUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				final int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER)
					register();
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
		tfPassword = new JPasswordField(20);
		tfPassword.setText("Example: 1234");
		tfPassword.setEchoChar((char) 0);
		tfPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				final int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER)
					register();
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
		tfPassConf = new JPasswordField(20);
		tfPassConf.setText("Example: 1234");
		tfPassConf.setEchoChar((char) 0);
		tfPassConf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				final int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER)
					register();
			}
		});
		tfPassConf.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(final FocusEvent e) {
				if (Arrays.equals(tfPassConf.getPassword(), "".toCharArray())) {
					tfPassConf.setText("Example: 1234");
					tfPassConf.setEchoChar((char) 0);
				}
			}

			@Override
			public void focusGained(final FocusEvent e) {
				if (Arrays.equals(tfPassConf.getPassword(), "Example: 1234".toCharArray())) {
					tfPassConf.setText("");
					tfPassConf.setEchoChar('*');
				}
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
		lPassConf = new JLabel("Repeat Password:");
		lHealthIssues = new JLabel("Health Issues:");
		headerPanel = new JPanel();
		backButton = new JButton(new ImageIcon(getClass().getResource("/back-icon.png")));
		backButton.addActionListener(this);
		backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		headerTitle = new JLabel("REGISTER");

		if (Controller.checkStatus() == true) {
			connectionStatus = new JLabel(new ImageIcon(getClass().getResource("/status-OK.png")));
			connectionStatus.setToolTipText("Connection Status: OK");
		} else {
			connectionStatus = new JLabel(new ImageIcon(getClass().getResource("/status-ERR.png")));
			connectionStatus.setToolTipText("Connection Status: ERROR");
		}

		formPanel = new JPanel();
		registerButton = new JButton();
		registerButton.setIcon(new ImageIcon(getClass().getResource("/register-icon.png")));
		registerButton.setText("Register");
		registerButton.addActionListener(this);
		registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		statusThread = new StatusThread(connectionStatus);
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
		textFieldPanel.add(lPassConf);
		textFieldPanel.add(tfPassConf);

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

	public void register() {
		String registerResponse = null;

		final String name = tfName.getText().equals("Example: Patxi") ? "" : tfName.getText();
		final String lastName =
				tfLastName.getText().equals("Example: Lopez") ? "" : tfLastName.getText();
		final String email =
				tfEmail.getText().equals("Example: alvaro@gmail.com") ? "" : tfEmail.getText();
		final String username =
				tfUsername.getText().equals("Example: Peio") ? "" : tfUsername.getText();
		final char[] password =
				Arrays.equals(tfPassword.getPassword(), "Example: 1234".toCharArray()) ? null
						: tfPassword.getPassword();
		final char[] passconf =
				Arrays.equals(tfPassConf.getPassword(), "Example: 1234".toCharArray()) ? null
						: tfPassConf.getPassword();

		if (Controller.checkStatus()) {
			try {
				registerResponse =
						Controller.register(name, lastName, email, username, password, passconf,
								cbGluten.isSelected(), cbDiabetes.isSelected(),
								cbVegetables.isSelected(), cbMilk.isSelected());
			} catch (final IOException e) {
				e.printStackTrace();
			}
		}

		if (registerResponse == null) {

			statusThread.interrupt();
			Frame.getInstance().getContentPane().remove(0);
			Frame.getInstance().getContentPane().add(new LoginPanel());
			Frame.getInstance().setMinimumSize(new Dimension(560, 400));
			Frame.getInstance().setSize(560, 400);
			Frame.getInstance().setMaximumSize(new Dimension(700, 550));
			Frame.getInstance().pack();
			Frame.getInstance().repaint();
			Frame.getInstance().setLocationRelativeTo(null);

		} else {
			JOptionPane.showMessageDialog(null, registerResponse, "Error",
					JOptionPane.ERROR_MESSAGE,
					new ImageIcon(getClass().getResource("/error-icon.png")));
		}
	}
}