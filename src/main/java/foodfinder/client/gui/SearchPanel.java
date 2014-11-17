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

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import org.apache.uima.tools.util.gui.SpringUtilities;

import foodfinder.client.api.Controller;
import foodfinder.client.gui.components.Frame;

public class SearchPanel extends JPanel implements ActionListener {

	// Dimension(560, 680)

	private static final long serialVersionUID = 1L;
	private JPanel headerPanel;
	private JPanel fieldPanel;
	private JPanel searchButtonPanel;
	private JPanel fieldContainer;
	private JPanel container;
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
	private StatusThread statusThread;

	public SearchPanel() {

		InitializeVariables();
		statusThread.run();
		placeHeaderObjects();
		placePriceObjects();
		placeFieldObjects();
		placeInformationObjects();
		placeTableInfoComponents();
		container.setLayout(new FlowLayout());
		container.add(headerPanel);
		container.add(fieldContainer);
		container.add(tableInfoPanel);
		container.add(lSupermarketMap);
		container.setPreferredSize(new Dimension(560, 680));
		this.add(container);

		Frame.getInstance().addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(final WindowEvent e) {
				Controller.logout();
				statusThread.interrupt();
			}
		});
	}

	public void InitializeVariables() {
		this.setFocusable(true);
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				final int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER)
					search();
			}
		});
		blogout = new JButton();
		blogout.setIcon(new ImageIcon(getClass().getResource("/logout-icon.png")));
		blogout.addActionListener(this);
		blogout.setText("Logout");
		lHeader = new JLabel("SEARCH");
		getConnectionLabel();
		headerPanel = new JPanel();
		fieldPanel = new JPanel();
		fieldContainer = new JPanel();
		searchButtonPanel = new JPanel();
		container = new JPanel();
		bSearch = new JButton();
		bSearch.setLayout(new SpringLayout());
		final JLabel searchImage =
				new JLabel(new ImageIcon(getClass().getResource("/search-icon.png")));
		bSearch.add(searchImage);
		bSearch.add(new JLabel("Search"));
		SpringUtilities.makeCompactGrid(bSearch, 2, 1, 6, 6, 6, 6);
		bSearch.addActionListener(this);
		lName = new JLabel("Name:");
		tfName = new JTextField("Example:Washer");
		tfName.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(final MouseEvent e) {
				if (tfName.getText().equals("Example:Washer")) {
					tfName.setText("");
				}
			}
		});
		tfName.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(final FocusEvent e) {
				if (tfName.getText().equals("")) {
					tfName.setText("Example:Washer");
				}

			}
		});
		lBrand = new JLabel("Brand:");
		tfBrand = new JTextField("Example:Ariel");
		tfBrand.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(final MouseEvent e) {
				if (tfBrand.getText().equals("Example:Ariel")) {
					tfBrand.setText("");
				}
			}
		});
		tfBrand.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(final FocusEvent e) {
				if (tfBrand.getText().equals("")) {
					tfBrand.setText("Example:Ariel");
				}

			}
		});
		lType = new JLabel("Type:");
		String types []={"Vegetables","Fruit","Meat","Fish","Drinks","Snacks"};
		cbType = new JComboBox<String>(types);
		pricePanel = new JPanel();
		lPrice = new JLabel("Price:");
		lPrice1 = new JLabel(" between ");
		tfPrice2 = new JTextField(5);
		tfPrice2.setText("0.00");
		tfPrice2.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(final MouseEvent e) {
				if (tfPrice2.getText().equals("0.00")) {
					tfPrice2.setText("");
				}
			}
		});
		tfPrice2.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(final FocusEvent e) {
				if (tfPrice2.getText().equals("")) {
					tfPrice2.setText("0.00");
				}

			}
		});
		lPrice3 = new JLabel("€  and ");
		tfPrice4 = new JTextField(5);
		tfPrice4.setText("99.00");
		tfPrice4.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(final MouseEvent e) {
				if (tfPrice4.getText().equals("99.00")) {
					tfPrice4.setText("");
				}
			}
		});
		tfPrice4.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(final FocusEvent e) {
				if (tfPrice4.getText().equals("")) {
					tfPrice4.setText("99.00");
				}

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
		lImageInfo = new JLabel(new ImageIcon(getClass().getResource("/missing.png")));
		lName1 = new JLabel("Name:");
		lType1 = new JLabel("Type:");
		lBrand1 = new JLabel("Brand:");
		lPrice11 = new JLabel("Price");
		tableInfoPanel = new JPanel();
		headers = new Object[] { "Name", "Type", "Brand", "Price" };
		data =
				new Object[][] { { "Ariel", "Washing", "Ariel", "3,60" },
				{ "Ariel", "Washing", "Ariel", "3,60" } };
		modeloTabla = new DefaultTableModel(data, headers);
		resultsTable = new JTable(modeloTabla);
		resultsTable.setEnabled(true);
		lSupermarketMap = new JLabel(new ImageIcon(getClass().getResource("/map.png")));
		statusThread=new StatusThread(lConnectionStatus);
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
		fieldContainer.setLayout(new BoxLayout(fieldContainer, BoxLayout.X_AXIS));
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
		resultsTable.setPreferredScrollableViewportSize(resultsTable.getPreferredSize());
		resultsTable.setFillsViewportHeight(true);
		tablePanel = new JScrollPane(resultsTable);
		tablePanel.setViewportView(resultsTable);

		tableInfoPanel.add(tablePanel);
		tableInfoPanel.add(informationPanel);
		SpringUtilities.makeCompactGrid(tableInfoPanel, 1, 2, 6, 6, 6, 6);

	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		if (e.getSource() == blogout) {
			Controller.logout();
			statusThread.interrupt();
			Frame.getInstance().getContentPane().remove(0);
			Frame.getInstance().getContentPane().add(new LoginPanel());
			Frame.getInstance().pack();
			Frame.getInstance().repaint();
			Frame.getInstance().setSize(560, 420);
			Frame.getInstance().setLocationRelativeTo(null);
		}
		if (e.getSource() == bSearch) {
			search();
		}

	}

	public void getConnectionLabel() {

		if (Controller.checkStatus() == true) {
			lConnectionStatus = new JLabel(new ImageIcon(getClass().getResource("/status-OK.png")));
			lConnectionStatus.setToolTipText("Connection Status: OK");
		} else {
			lConnectionStatus =
					new JLabel(new ImageIcon(getClass().getResource("/status-ERR.png")));
			lConnectionStatus.setToolTipText("Connection Status: ERROR");
		}
	}

	public void search() {
		// TODO
	}
}