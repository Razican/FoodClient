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
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.apache.uima.tools.util.gui.SpringUtilities;

import foodfinder.client.api.Controller;
import foodfinder.client.api.PriceMismatchException;
import foodfinder.client.api.SearchResult;
import foodfinder.client.api.UserNotSetException;
import foodfinder.client.gui.components.Frame;
import foodfinder.client.gui.components.Map;
import foodfinder.client.gui.components.SearchTableModel;

public class SearchPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel headerPanel;
	private JPanel fieldPanel;
	private JPanel searchButtonPanel;
	private JPanel fieldContainer;
	private JButton blogout;
	private JLabel lHeader;
	private JLabel connectionStatus;
	private JLabel lName;
	private JLabel lBrand;
	private JLabel lType;
	private JLabel lPrice;
	private JTextField tfName;
	private JTextField tfBrand;
	private JComboBox<String> cbType;
	private JLabel lPriceBetween;
	private JTextField tfPriceMin;
	private JLabel lPriceAnd;
	private JTextField tfPriceMax;
	private JLabel lPriceMax;
	private JButton bSearch;
	private JPanel pricePanel;
	private JPanel informationPanel;
	private JPanel informationPanelText;
	private JLabel lInfoImage;
	private JLabel lInfoName;
	private JLabel lInfoType;
	private JLabel lInfoBrand;
	private JLabel lInfoPrice;
	private JLabel lInfoDesc;
	private JLabel lInfoDescText;
	private JLabel lInfoNameText;
	private JLabel lInfoTypeText;
	private JLabel lInfoBrandText;
	private JLabel lInfoPriceText;
	private JPanel tableInfoPanel;
	private JTable resultsTable;
	private DefaultTableModel tableModel;
	private Object[] headers;
	private Object[][] data;
	private JScrollPane tablePanel;
	private JLabel lSupermarketMap;
	private Map map;
	private StatusThread statusThread;
	private List<SearchResult> results;

	public SearchPanel() {
		InitializeVariables();
		statusThread.start();

		placeHeaderObjects();
		placePriceObjects();
		placeFieldObjects();
		placeInformationObjects();
		placeTableInfoComponents();
		setLayout(new FlowLayout());
		add(headerPanel);
		add(fieldContainer);
		add(tableInfoPanel);
		add(lSupermarketMap);
		setPreferredSize(new Dimension(560, 680));

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
		blogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lHeader = new JLabel("SEARCH");

		if (Controller.checkStatus() == true) {
			connectionStatus = new JLabel(new ImageIcon(getClass().getResource("/status-OK.png")));
			connectionStatus.setToolTipText("Connection Status: OK");
		} else {
			connectionStatus = new JLabel(new ImageIcon(getClass().getResource("/status-ERR.png")));
			connectionStatus.setToolTipText("Connection Status: ERROR");
		}

		headerPanel = new JPanel();
		fieldPanel = new JPanel();
		fieldContainer = new JPanel();
		searchButtonPanel = new JPanel();
		bSearch = new JButton();
		bSearch.setLayout(new SpringLayout());
		final JLabel searchImage =
				new JLabel(new ImageIcon(getClass().getResource("/search-icon.png")));
		bSearch.add(searchImage);
		bSearch.add(new JLabel("Search"));
		bSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SpringUtilities.makeCompactGrid(bSearch, 2, 1, 6, 6, 6, 6);
		bSearch.addActionListener(this);
		lName = new JLabel("Name:");
		tfName = new JTextField("Example: Washer");
		tfName.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(final FocusEvent e) {
				if (tfName.getText().equals("")) {
					tfName.setText("Example: Washer");
				}
			}

			@Override
			public void focusGained(final FocusEvent e) {
				if (tfName.getText().equals("Example: Washer")) {
					tfName.setText("");
				}
			}
		});
		lBrand = new JLabel("Brand:");
		tfBrand = new JTextField("Example: Ariel");
		tfBrand.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(final FocusEvent e) {
				if (tfBrand.getText().equals("")) {
					tfBrand.setText("Example: Ariel");
				}
			}

			@Override
			public void focusGained(final FocusEvent e) {
				if (tfBrand.getText().equals("Example: Ariel")) {
					tfBrand.setText("");
				}
			}
		});
		lType = new JLabel("Type:");
		final String types[] = { "Vegetables", "Fruit", "Meat", "Fish", "Drinks", "Snacks" };
		cbType = new JComboBox<String>(types);
		pricePanel = new JPanel();
		lPrice = new JLabel("Price:");
		lPriceBetween = new JLabel(" between ");
		tfPriceMin = new JTextField(5);
		tfPriceMin.setText("0.00");
		tfPriceMin.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(final FocusEvent e) {
				if (tfPriceMin.getText().equals("")) {
					tfPriceMin.setText("0.00");
				}
			}

			@Override
			public void focusGained(final FocusEvent e) {
				if (tfPriceMin.getText().equals("0.00")) {
					tfPriceMin.setText("");
				}
			}
		});
		lPriceAnd = new JLabel("€  and ");
		tfPriceMax = new JTextField(5);
		tfPriceMax.setText("99.00");
		tfPriceMax.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(final FocusEvent e) {
				if (tfPriceMax.getText().equals("")) {
					tfPriceMax.setText("99.00");
				}
			}

			@Override
			public void focusGained(final FocusEvent e) {
				if (tfPriceMax.getText().equals("99.00")) {
					tfPriceMax.setText("");
				}
			}
		});
		lPriceMax = new JLabel("€");
		map = new Map(getClass().getResource("/map.png"));
		lSupermarketMap = new JLabel(map);
		lInfoImage = new JLabel();

		lInfoDesc = new JLabel("Desc:");
		lInfoNameText = new JLabel("Name:");
		lInfoTypeText = new JLabel("Type:");
		lInfoBrandText = new JLabel("Brand:");
		lInfoPriceText = new JLabel("Price");

		lInfoName = new JLabel();
		lInfoType = new JLabel();
		lInfoBrand = new JLabel();
		lInfoPrice = new JLabel();
		lInfoDescText = new JLabel();
		showProduct(null);

		tableInfoPanel = new JPanel();
		headers = new Object[] { "Name", "Type", "Brand", "Price" };
		data = null;
		tableModel = new SearchTableModel(data, headers);
		resultsTable = new JTable(tableModel);
		resultsTable.setEnabled(true);
		resultsTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		final ListSelectionModel selectionModel = resultsTable.getSelectionModel();
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(final ListSelectionEvent e) {
				if (resultsTable.getSelectedRow() >= 0)
					showProduct(results.get(resultsTable.getSelectedRow()));
			}
		});
		statusThread = new StatusThread(connectionStatus);
	}

	public void placeHeaderObjects() {
		headerPanel.setLayout(new SpringLayout());
		headerPanel.add(blogout);
		headerPanel.add(lHeader);
		headerPanel.add(connectionStatus);
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
	}

	public void placePriceObjects() {
		pricePanel.setLayout(new FlowLayout());
		pricePanel.add(lPriceBetween);
		pricePanel.add(tfPriceMin);
		pricePanel.add(lPriceAnd);
		pricePanel.add(tfPriceMax);
		pricePanel.add(lPriceMax);
	}

	public void placeInformationObjects() {
		informationPanel = new JPanel();
		informationPanelText = new JPanel();
		informationPanelText.setLayout(new SpringLayout());
		informationPanelText.add(lInfoNameText);
		informationPanelText.add(lInfoName);
		informationPanelText.add(lInfoTypeText);
		informationPanelText.add(lInfoType);
		informationPanelText.add(lInfoBrandText);
		informationPanelText.add(lInfoBrand);
		informationPanelText.add(lInfoPriceText);
		informationPanelText.add(lInfoPrice);
		informationPanelText.add(lInfoDesc);
		informationPanelText.add(lInfoDescText);
		SpringUtilities.makeCompactGrid(informationPanelText, 5, 2, 6, 6, 6, 6);
		informationPanel.setLayout(new SpringLayout());
		informationPanel.add(lInfoImage);
		informationPanelText.setPreferredSize(new Dimension(180, 225));
		informationPanel.add(informationPanelText);
		SpringUtilities.makeCompactGrid(informationPanel, 2, 1, 6, 6, 6, 6);
	}

	public void placeTableInfoComponents() {
		tableInfoPanel.setLayout(new SpringLayout());
		resultsTable.setPreferredScrollableViewportSize(resultsTable.getPreferredSize());
		resultsTable.setFillsViewportHeight(true);
		tablePanel = new JScrollPane(resultsTable);
		tablePanel.setViewportView(resultsTable);
		tablePanel.setSize(new Dimension(306, 295));
		tableInfoPanel.add(tablePanel);
		informationPanel.setPreferredSize(new Dimension(180, 295));
		tableInfoPanel.add(informationPanel);
		SpringUtilities.makeCompactGrid(tableInfoPanel, 1, 2, 6, 6, 6, 6);
		tableInfoPanel.setPreferredSize(new Dimension(490, 295));
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		if (e.getSource() == blogout) {
			Controller.logout();
			statusThread.interrupt();

			Frame.getInstance().getContentPane().removeAll();
			Frame.getInstance().setMinimumSize(new Dimension(560, 400));
			Frame.getInstance().setSize(560, 400);
			Frame.getInstance().getContentPane().add(new LoginPanel());
			Frame.getInstance().setMaximumSize(new Dimension(700, 550));
			Frame.getInstance().setLocationRelativeTo(null);
			Frame.getInstance().pack();
			Frame.getInstance().repaint();
		}
		if (e.getSource() == bSearch) {
			search();
		}
	}

	public void search() {
		tableModel.setRowCount(0);
		showProduct(null);

		final String name = tfName.getText().equals("Example: Washer") ? "" : tfName.getText();
		final int type = cbType.getSelectedIndex();
		final String brand = tfBrand.getText().equals("Example: Ariel") ? "" : tfBrand.getText();
		final double price_min = Double.parseDouble(tfPriceMin.getText());
		final double price_max = Double.parseDouble(tfPriceMax.getText());

		if (Controller.checkStatus()) {
			try {
				results = Controller.search(name, type, brand, price_min, price_max);
			} catch (UserNotSetException | PriceMismatchException e) {
				e.printStackTrace();
			} catch (final IOException e) {
				connectionStatus =
						new JLabel(new ImageIcon(getClass().getResource("/status-ERR.png")));
				connectionStatus.setToolTipText("Connection Status: ERROR");
			}
		}

		if (results != null) {

			data = new String[results.size()][4];
			int i = 0;
			for (final SearchResult r : results) {
				data[i][0] = r.getName();
				data[i][1] = r.getType();
				data[i][2] = r.getBrand();
				data[i++][3] = String.valueOf(r.getPrice()) + "€";
			}
			tableModel.setDataVector(data, headers);
		} else {
			JOptionPane.showMessageDialog(null, "Nothing found for the search criteria.", "Error",
					JOptionPane.ERROR_MESSAGE,
					new ImageIcon(getClass().getResource("/error-icon.png")));
		}
	}

	protected void showProduct(final SearchResult result) {
		if (result == null) {
			lInfoName.setText("_______");
			lInfoType.setText("_______");
			lInfoBrand.setText("_______");
			lInfoPrice.setText("_______");
			lInfoDescText.setText("______");
			lInfoImage.setIcon(new ImageIcon(getClass().getResource("/missing.png")));

			map.deleteMark();
			lSupermarketMap.repaint();
		} else {
			lInfoName.setText(result.getName());
			lInfoType.setText(result.getType());
			lInfoBrand.setText(result.getBrand());
			lInfoPrice.setText(String.valueOf(result.getPrice()) + "€");
			lInfoDescText.setText("<html>" + result.getDescription() + "<html>");
			lInfoImage.setIcon(new ImageIcon(getClass().getResource(
					"/products/" + result.getId() + ".jpg")));

			map.setMark(result.getHall(), result.getShelf());
			lSupermarketMap.repaint();
		}
	}
}