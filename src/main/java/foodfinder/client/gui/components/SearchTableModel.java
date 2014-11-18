package foodfinder.client.gui.components;

import javax.swing.table.DefaultTableModel;

public class SearchTableModel extends DefaultTableModel {

	private static final long serialVersionUID = 1733609153610082425L;

	public SearchTableModel(final Object[][] data, final Object[] headers) {
		super(data, headers);
	}

	@Override
	public boolean isCellEditable(final int rowIndex, final int columnIndex) {
		return false;
	}
}