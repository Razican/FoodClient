import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import Utilities.GUIUtilities;
import Utilities.SpringUtilities;


public class RegistryPanel extends JPanel implements ActionListener {
	
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
	private JButton registerButton ;
	private JPanel container;
	
	public RegistryPanel()
	{
		initializeVariables();
		
		headerPanel.setLayout(new SpringLayout());
		placeHeaderComponents();
		SpringUtilities.makeCompactGrid(headerPanel,1,3,30,1,70,1); 
	
		textFieldPanel.setLayout(new SpringLayout());
		placeComponentsText();
		SpringUtilities.makeCompactGrid(textFieldPanel,6,2,6,6,6,6);    
		
		checkBoxIssuePanel.setLayout(new SpringLayout());
		checkBoxIssuePanel1.setLayout(new SpringLayout());
		placeCheckBoxIssue1();
		SpringUtilities.makeCompactGrid(checkBoxIssuePanel1, 1, 1, 1, 1, 50, 50);
		checkBoxIssuePanel2.setLayout(new SpringLayout());
		placeCheckBoxIssue2();
		SpringUtilities.makeCompactGrid(checkBoxIssuePanel2,2,2,10,0,30,0);
		
		checkBoxIssuePanel.add(checkBoxIssuePanel1);
		checkBoxIssuePanel.add(checkBoxIssuePanel2);
		SpringUtilities.makeCompactGrid(checkBoxIssuePanel, 1, 2, 6,6,6,6);
		
		
		container.setLayout(new SpringLayout());
		container.add(headerPanel);
		container.add(textFieldPanel);
		container.add(checkBoxIssuePanel);
		SpringUtilities.makeCompactGrid(container,3,1,6,6,6,6);
		
		
	this.setLayout(new FlowLayout());
	this.add(container);
	this.add(registerButton);
	this.setSize(new Dimension(460,480));
		
		
		
	}
	
	public void initializeVariables()
	{
		textFieldPanel= new JPanel();
		checkBoxIssuePanel = new JPanel();
		checkBoxIssuePanel1 = new JPanel();
		checkBoxIssuePanel2 = new JPanel();
		tfName=new JTextField(20);
		tfName.setText("Example:Patxi");
		tfName.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(tfName.getText().equals("Example:Patxi"))
				{
					tfName.setText("");	
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
		tfLastName=new JTextField(20);
		tfLastName.setText("Example:Lopez");
		tfLastName.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(tfLastName.getText().equals("Example:Lopez"))
				{
					tfLastName.setText("");
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
		tfEmail=new JTextField(20);
		tfEmail.setText("Example:alvaro@gmail.com");
		tfEmail.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(tfEmail.getText().equals("Example:alvaro@gmail.com"))
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
		tfUsername=new JTextField(20);
		tfUsername.setText("Example:Peio");
		tfUsername.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
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
		tfPassword=new JPasswordField(20);
		tfPassword.setText("Example:1234");
		tfPassword.setEchoChar((char)0);
		tfPassword.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
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
				// TODO Auto-generated method stub
				
			}
		});
		tfPassword2=new JPasswordField(20);
		tfPassword2.setText("Example:1234");
		tfPassword2.setEchoChar((char)0);
		tfPassword2.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(tfPassword2.getText().equals("Example:1234"))
				{
					tfPassword2.setText("");
					tfPassword2.setEchoChar('*');
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
		cbGluten=new JCheckBox("Gluten");
		cbDiabetes=new JCheckBox("Diabetes");
		cbVegetables=new JCheckBox("Vegetables");
		cbMilk=new JCheckBox("Milk");
		lName=new JLabel("Name:");
		lLastName=new JLabel("Last Name:");
		lEmail=new JLabel("Email:");
		lUsername=new JLabel("Username:");
		lPassword=new JLabel("Password:");
		lPassword2=new JLabel("Repeat Password:");
		lHealthIssues=new JLabel("Health Issues:");
		bRegister=new JButton("Register");
		headerPanel=new JPanel();
		backButton=new JButton(new ImageIcon(getClass().getResource("/Resources/back-icon.png")));
		backButton.addActionListener(this);
		headerTitle = new JLabel("REGISTER");
		connectionStatus= new JLabel(new ImageIcon(getClass().getResource("/Resources/Base Green Deep.png")));
		container=new JPanel();
		registerButton= new JButton();
		registerButton.setIcon(new ImageIcon(getClass().getResource("/Resources/form_icon_25603.png")));
		registerButton.setText("Register");
		registerButton.addActionListener(this);
		
	}
	
	public void placeHeaderComponents()
	{
		headerPanel.add(backButton);
		headerPanel.add(headerTitle);
		headerPanel.add(connectionStatus);
	}
	
	
	
	//frame.setSize(new Dimension(460, 480));
	public void placeComponentsText()
	{
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
		//this.add(boton);
		
	}
	public void placeCheckBoxIssue1()
	{
		lHealthIssues.setHorizontalAlignment(JLabel.RIGHT);
		checkBoxIssuePanel1.add(lHealthIssues);
		
	}
	
	public void placeCheckBoxIssue2()
	{
		checkBoxIssuePanel2.add(cbGluten);
		checkBoxIssuePanel2.add(cbDiabetes);
		checkBoxIssuePanel2.add(cbVegetables);
		checkBoxIssuePanel2.add(cbMilk);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==registerButton)
		{
			System.out.println("heigth:"+this.getSize().height+" Width"+ this.getSize().width);	
		}
		if(e.getSource()==backButton)
		{
			Frame window = (Frame) GUIUtilities.getPrincipalContainer(container);
			window.getContentPane().remove(0);
			window.getContentPane().add(new LoginPanel());
			window.pack();
			window.repaint();
			window.setSize(600, 400);
			GUIUtilities.CenterWindow(window);
		}
		
	}
	
	}


