import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Utilities.GUIUtilities;
import Utilities.SpringUtilities;

public class SearchPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel headerPanel;
	private JPanel fieldPanel;
	private JPanel searchButtonPanel;
	private JPanel fieldContainer;
	private JButton blogout;
	private JLabel lHeader;
	private JLabel lConnectionStatus;
	private JLabel lName;
	private JLabel lBrand;
	private JLabel lType;
	private JLabel lPrice;
	private JTextField tfName;
	private JTextField tfBrand;
	private JComboBox<String> cbType;
	private JLabel lPrice1;
	private JTextField tfPrice2;
	private JLabel lPrice3;
	private JTextField tfPrice4;
	private JLabel lPrice4;
	private JButton bSearch;
	private JPanel pricePanel;
	private JPanel informationPanel;
	private JPanel informationPanel2;
	private JLabel lImageInfo;
	private JLabel lNameInfo;
	private JLabel lTypeInfo;
	private JLabel lBrandInfo;
	private JLabel lPriceInfo;
	private JLabel lDesc;
	private JLabel lDescInfo;
	private JLabel lName1;
	private JLabel lType1;
	private JLabel lBrand1;
	private JLabel lPrice11;
	private JPanel tableInfoPanel;
	private JTable resultsTable;
	private DefaultTableModel modeloTabla;
	private Object[] headers;
	private Object[][] data;
	private JScrollPane tablePanel;
	private JLabel lSupermarketMap;

	public SearchPanel() {

		InitializeVariables();
		placeHeaderObjects();
		placePriceObjects();
		placeFieldObjects();
		placeInformationObjects();
		placeTableInfoComponents();
		this.setLayout(new FlowLayout());
		this.add(headerPanel);
		this.add(fieldContainer);
		this.add(tableInfoPanel);
		this.add(lSupermarketMap);

	}

	public void InitializeVariables() {
		blogout = new JButton();
		blogout.setIcon(new ImageIcon(getClass().getResource(
				"/Resources/logout.png")));
		blogout.addActionListener(this);
		blogout.setText("Logout");
		lHeader = new JLabel("SEARCH");
		lConnectionStatus = new JLabel(new ImageIcon(getClass().getResource(
				"/Resources/Base Green Deep.png")));
		headerPanel = new JPanel();
		fieldPanel = new JPanel();
		fieldContainer = new JPanel();
		searchButtonPanel = new JPanel();
		bSearch = new JButton();
		bSearch.setLayout(new SpringLayout());
		JLabel searchImage = new JLabel(new ImageIcon(getClass().getResource(
				"/Resources/search.png")));
		bSearch.add(searchImage);
		bSearch.add(new JLabel("Search"));
		SpringUtilities.makeCompactGrid(bSearch, 2, 1, 6, 6, 6, 6);
		lName = new JLabel("Name:");
		tfName = new JTextField("Example:Washer");
		tfName.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (tfName.getText().equals("Example:Washer")) {
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
		lBrand = new JLabel("Brand:");
		tfBrand = new JTextField("Example:Ariel");
		tfBrand.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (tfBrand.getText().equals("Example:Ariel")) {
					tfBrand.setText("");
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
		lType = new JLabel("Type:");
		cbType = new JComboBox<String>();
		pricePanel = new JPanel();
		lPrice = new JLabel("Price:");
		lPrice1 = new JLabel(" between ");
		tfPrice2 = new JTextField(5);
		tfPrice2.setText("0.00");
		tfPrice2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (tfPrice2.getText().equals("0.00")) {
					tfPrice2.setText("");
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
		lPrice3 = new JLabel("€  and ");
		tfPrice4 = new JTextField(5);
		tfPrice4.setText("99.00");
		tfPrice4.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (tfPrice4.getText().equals("99.00")) {
					tfPrice4.setText("");
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
		lPrice4 = new JLabel("€");
		lNameInfo = new JLabel("_______");
		lTypeInfo = new JLabel("_______");
		lBrandInfo = new JLabel("_______");
		lPriceInfo = new JLabel("_______");
		lTypeInfo = new JLabel("______");
		lDesc = new JLabel("Desc:");
		lDescInfo = new JLabel("______");
		lImageInfo = new JLabel(new ImageIcon(getClass().getResource(
				"/Resources/pictographs-information-inv.png")));
		lName1 = new JLabel("Name:");
		lType1 = new JLabel("Type:");
		lBrand1 = new JLabel("Brand:");
		lPrice11 = new JLabel("Price");
		tableInfoPanel = new JPanel();
		headers = new Object[] { "Name", "Type", "Brand", "Price" };
		data = new Object[][] { { "Ariel", "Washing", "Ariel", "3,60" },
				{ "Ariel", "Washing", "Ariel", "3,60" } };
		modeloTabla = new DefaultTableModel(data, headers);
		resultsTable = new JTable(modeloTabla);
		resultsTable.setEnabled(true);
		lSupermarketMap = new JLabel(new ImageIcon(getClass().getResource(
				"/Resources/Supermarket.jpg")));

	}

	public void placeHeaderObjects() {
		headerPanel.setLayout(new SpringLayout());
		headerPanel.add(blogout);
		headerPanel.add(lHeader);
		headerPanel.add(lConnectionStatus);
		SpringUtilities.makeCompactGrid(headerPanel, 1, 3, 70, 6, 130, 1);

	}

	public void placeFieldObjects() {
		fieldPanel.setLayout(new SpringLayout());
		fieldPanel.add(lName);
		fieldPanel.add(tfName);
		fieldPanel.add(lBrand);
		fieldPanel.add(tfBrand);
		fieldPanel.add(lType);
		fieldPanel.add(cbType);
		fieldPanel.add(lPrice);
		fieldPanel.add(pricePanel);
		SpringUtilities.makeCompactGrid(fieldPanel, 4, 2, 6, 6, 6, 6);
		fieldContainer
				.setLayout(new BoxLayout(fieldContainer, BoxLayout.X_AXIS));
		fieldContainer.add(fieldPanel);
		searchButtonPanel.add(bSearch);
		fieldContainer.add(searchButtonPanel);

		// SpringUtilities.makeCompactGrid(fieldContainer, 1, 2, 6, 6, 6, 6);
	}

	public void placePriceObjects() {
		pricePanel.setLayout(new FlowLayout());
		pricePanel.add(lPrice1);
		pricePanel.add(tfPrice2);
		pricePanel.add(lPrice3);
		pricePanel.add(tfPrice4);
		pricePanel.add(lPrice4);

	}

	public void placeInformationObjects() {
		informationPanel = new JPanel();
		informationPanel2 = new JPanel();
		informationPanel2.setLayout(new SpringLayout());
		informationPanel2.add(lName1);
		informationPanel2.add(lNameInfo);
		informationPanel2.add(lType1);
		informationPanel2.add(lTypeInfo);
		informationPanel2.add(lBrand1);
		informationPanel2.add(lBrandInfo);
		informationPanel2.add(lPrice11);
		informationPanel2.add(lPriceInfo);
		informationPanel2.add(lDesc);
		informationPanel2.add(lDescInfo);
		SpringUtilities.makeCompactGrid(informationPanel2, 5, 2, 6, 6, 6, 6);
		informationPanel.setLayout(new SpringLayout());
		informationPanel.add(lImageInfo);
		informationPanel.add(informationPanel2);
		SpringUtilities.makeCompactGrid(informationPanel, 2, 1, 6, 6, 6, 6);

	}

	public void placeTableInfoComponents() {
		tableInfoPanel.setLayout(new SpringLayout());
		resultsTable.setPreferredScrollableViewportSize(resultsTable
				.getPreferredSize());
		resultsTable.setFillsViewportHeight(true);
		tablePanel = new JScrollPane(resultsTable);
		tablePanel.setViewportView(resultsTable);

		tableInfoPanel.add(tablePanel);
		tableInfoPanel.add(informationPanel);
		SpringUtilities.makeCompactGrid(tableInfoPanel, 1, 2, 6, 6, 6, 6);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == blogout) {
			Frame window = (Frame) GUIUtilities
					.getPrincipalContainer(tablePanel);
			window.getContentPane().remove(0);
			window.getContentPane().add(new LoginPanel());
			window.pack();
			window.repaint();
			window.setSize(560, 420);
			GUIUtilities.CenterWindow(window);
		}

	}

}
