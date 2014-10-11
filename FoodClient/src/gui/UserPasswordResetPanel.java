package gui;
import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.Year;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import utilities.GUIUtilities;
import utilities.SpringUtilities;

public class UserPasswordResetPanel extends JPanel implements ActionListener {

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
		// container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
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

		this.setLayout(new FlowLayout());
		this.add(container);
		this.add(bReset);
		this.setSize(600, 400);

	}

	public void initializeVartiables() {
		headerPanel = new JPanel();
		textPanel = new JPanel();
		checkBoxPanel = new JPanel();
		container = new JPanel();
		backButton = new JButton(new ImageIcon(getClass().getResource(
				"/resources/back-icon.png")));
		backButton.addActionListener(this);
		headerTitle = new JLabel("USER/PASSWORD RESET");
		connectionStatus = new JLabel(new ImageIcon(getClass().getResource(
				"/resources/Base Green Deep.png")));
		lEmail = new JLabel("Email:");
		tfEmail = new JTextField(15);
		tfEmail.setText("Example:alvaro@gmail.com");
		tfEmail.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (tfEmail.getText().equals("Example:alvaro@gmail.com"))
					;
				{
					tfEmail.setText("");
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
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bReset) {
			System.out.println(this.getSize().toString());
		}
		if (e.getSource() == backButton) {
			Frame window = (Frame) GUIUtilities
					.getPrincipalContainer(container);
			window.getContentPane().remove(0);
			window.getContentPane().add(new LoginPanel());
			window.pack();
			window.repaint();
			window.setSize(600, 400);
			GUIUtilities.CenterWindow(window);
		}

	}

}
