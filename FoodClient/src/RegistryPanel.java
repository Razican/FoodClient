import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

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
//	private JButton boton = new JButton("Click");
	
	public RegistryPanel()
	{
		initializeVariables();
	
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
		
		
		this.setLayout(new SpringLayout());
		this.add(textFieldPanel);
		this.add(checkBoxIssuePanel);
		//this.add(checkBoxIssuePanel2);
		SpringUtilities.makeCompactGrid(this,2,1,6,6,6,6);
		
		
		
	}
	
	public void initializeVariables()
	{
		textFieldPanel= new JPanel();
		checkBoxIssuePanel = new JPanel();
		checkBoxIssuePanel1 = new JPanel();
		checkBoxIssuePanel2 = new JPanel();
		tfName=new JTextField(20);
		tfLastName=new JTextField(20);
		tfEmail=new JTextField(20);
		tfUsername=new JTextField(20);
		tfPassword=new JPasswordField(20);
		tfPassword2=new JPasswordField(20);
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
	//	boton.addActionListener(this);
		
	}
	//frame.setSize(new Dimension(465, 234));
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
		/*if(e.getSource()==boton)
		{
			System.out.println("heigth:"+this.getSize().height+" Width"+ this.getSize().width);	
		}
		*/
	}
	
	}


