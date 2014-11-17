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

		container.setLayout(new SpringLayout());
		container.add(headerPanel);
		container.add(textFieldPanel);
		container.add(checkBoxIssuePanel);
		SpringUtilities.makeCompactGrid(container, 3, 1, 6, 6, 6, 6);

		container2.setLayout(new FlowLayout());
		container2.add(container);
		container2.add(registerButton);
		this.add(container2);

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
		tfName.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(final FocusEvent e) {
				if (tfName.getText().equals("")) {
					tfName.setText("Example:Patxi");
				}

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
		tfLastName.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(final FocusEvent e) {
				if (tfLastName.getText().equals("")) {
					tfLastName.setText("Example:Lopez");
				}

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
		tfEmail.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(final FocusEvent e) {
				if (tfEmail.getText().equals("")) {
					tfEmail.setText("Example:alvaro@gmail.com");
				}

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
		tfUsername.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(final FocusEvent e) {
				if (tfUsername.getText().equals("")) {
					tfUsername.setText("Example:Peio");
				}

			}
		});
		tfPassword = new JPasswordField(20);
		tfPassword.setText("Example:1234");
		tfPassword.setEchoChar((char) 0);
		tfPassword.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(final MouseEvent e) {
				if (Arrays.equals(tfPassword.getPassword(), "Example:1234".toCharArray())) {
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
		tfPassword.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(final FocusEvent e) {
				if (Arrays.equals(tfPassword.getPassword(), "".toCharArray())) {
					tfPassword.setText("Example:1234");
					tfPassword.setEchoChar((char) 0);
				}

			}
		});
		tfPassword2 = new JPasswordField(20);
		tfPassword2.setText("Example:1234");
		tfPassword2.setEchoChar((char) 0);
		tfPassword2.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(final MouseEvent e) {
				if (Arrays.equals(tfPassword2.getPassword(), "Example:1234".toCharArray())) {
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
		tfPassword2.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(final FocusEvent e) {
				if (Arrays.equals(tfPassword2.getPassword(), "".toCharArray())) {
					tfPassword2.setText("Example:1234");
					tfPassword2.setEchoChar((char) 0);
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
		lPassword2 = new JLabel("Repeat Password:");
		lHealthIssues = new JLabel("Health Issues:");
		headerPanel = new JPanel();
		backButton = new JButton(new ImageIcon(getClass().getResource("/back-icon.png")));
		backButton.addActionListener(this);
		headerTitle = new JLabel("REGISTER");

		if (Controller.checkStatus() == true) {
			connectionStatus = new JLabel(new ImageIcon(getClass().getResource("/status-OK.png")));
			connectionStatus.setToolTipText("Connection Status: OK");
		} else {
			connectionStatus = new JLabel(new ImageIcon(getClass().getResource("/status-ERR.png")));
			connectionStatus.setToolTipText("Connection Status: ERROR");
		}

		container = new JPanel();
		registerButton = new JButton();
		registerButton.setIcon(new ImageIcon(getClass().getResource("/register-icon.png")));
		registerButton.setText("Register");
		registerButton.addActionListener(this);
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
			statusThread.interrupt();
			Frame.getInstance().getContentPane().remove(0);
			Frame.getInstance().getContentPane().add(new LoginPanel());
			Frame.getInstance().setMinimumSize(new Dimension(560, 420));
			Frame.getInstance().setSize(560, 420);
			Frame.getInstance().pack();
			Frame.getInstance().repaint();
			Frame.getInstance().setLocationRelativeTo(null);
		}

	}

	public void register() {
		String registerResponse = null;
		if (Controller.checkStatus()) {
			try {
				registerResponse =
						Controller.register(tfName.getText(), tfLastName.getText(),
								tfEmail.getText(), tfUsername.getText(), tfPassword.getPassword(),
								tfPassword2.getPassword(), cbGluten.isSelected(),
								cbDiabetes.isSelected(), cbVegetables.isSelected(),
								cbMilk.isSelected());
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
			Frame.getInstance().pack();
			Frame.getInstance().repaint();
			Frame.getInstance().setLocationRelativeTo(null);

		} else {
			JOptionPane.showMessageDialog(null, registerResponse, "", JOptionPane.ERROR_MESSAGE,
					new ImageIcon(getClass().getResource("/error-icon.png")));

		}
		// TODO Username exists or email exist validation missing.
	}
}
