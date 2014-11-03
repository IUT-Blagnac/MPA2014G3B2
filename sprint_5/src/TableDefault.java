import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

@SuppressWarnings("serial")
public class TableDefault extends JTable {

	public TableDefault() {
		// TODO Auto-generated constructor stub
	}

	public TableDefault(TableModel dm) {
		super(dm);
		// TODO Auto-generated constructor stub
	}

	public TableDefault(TableModel dm, TableColumnModel cm) {
		super(dm, cm);
		// TODO Auto-generated constructor stub
	}

	public TableDefault(int numRows, int numColumns) {
		super(numRows, numColumns);
		// TODO Auto-generated constructor stub
	}

	public TableDefault(Vector rowData, Vector columnNames) {
		super(rowData, columnNames);
		// TODO Auto-generated constructor stub
	}

	public TableDefault(Object[][] rowData, Object[] columnNames) {
		super(rowData, columnNames);
		// TODO Auto-generated constructor stub
	}

	public TableDefault(TableModel dm, TableColumnModel cm,
			ListSelectionModel sm) {
		super(dm, cm, sm);

	}

	@Override
	public boolean isCellEditable(int row, int column) {
		// all cells false
		return false;
	}

	/* We create our table models */
	public void createModel(final JTable jTableData, final Object[][] data,
			final String[] columns) {
		/*
		 * First we create the main model We overide the AbstractTableModel
		 * necessary methods
		 */
		AbstractTableModel modelo = new AbstractTableModel() {
			public String getColumnName(int col) {
				return columns[col].toString();
			}

			public Class getColumnClass(int col) {
				if (getRowCount() < 1)
					return null;
				return data[0][col].getClass();
			}

			public int getRowCount() {
				return data.length;
			}

			public int getColumnCount() {
				return columns.length;
			}

			public Object getValueAt(int row, int col) {
				return data[row][col];
			}

			public boolean isCellEditable(int row, int col) {
				return true;
			}

			public void setValueAt(Object value, int row, int col) {
				data[row][col] = value;
				fireTableCellUpdated(row, col);
			}
		};
		/* We apply the model to the main jTable */
		jTableData.setModel(modelo);
		/*
		 * We create a cell Renderer to display the data of the multivalue
		 * fields
		 */
		TableCellRenderer jTableCellRenderer = new TableCellRenderer() {
			/* Magic Happens */
			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				/*
				 * If what we're displaying isn't an array of values we return
				 * the normal renderer
				 */
				if (!value.getClass().isArray()) {
					return table.getDefaultRenderer(value.getClass())
							.getTableCellRendererComponent(table, value,
									isSelected, hasFocus, row, column);
				} else {
					final Object[] passed = (Object[]) value;
					/*
					 * We create the table that will hold the multivaluefields
					 * and that will be embedded in the main table
					 */
					JTable embedded = new JTable(new AbstractTableModel() {
						public int getColumnCount() {
							return 1;
						}

						public int getRowCount() {
							return passed.length;
						}

						public Object getValueAt(int rowIndex, int columnIndex) {
							return passed[rowIndex];
						}

						public boolean isCellEditable(int row, int col) {
							return true;
						}
					});

					if (isSelected) {
						embedded.setBackground(jTableData
								.getSelectionBackground());
						embedded.setForeground(jTableData
								.getSelectionForeground());
					}
					if (hasFocus) {
						embedded.setRowSelectionInterval(0, 1);
					}

					/*
					 * If this is what you plan to enable mouseClick detection,
					 * in your table, IT WONT WORK. Have a look at
					 * TableCellEditor.
					 */
					embedded.addMouseListener(new MouseAdapter() {
						public void mouseClicked(java.awt.event.MouseEvent evt) {
							System.out.println("PEPE");
						}
					});
					if (Character.isDigit(((String) passed[0]).charAt(1))) {
						setPreferredSize(embedded.getPreferredSize());
					} else {
						//faire ca
					}
					if (getPreferredSize().height != table.getRowHeight(row)) {
						table.setRowHeight(row, getPreferredSize().height);
					}
					/**/

					return embedded;
				}
			}
		};
		/* Finally we apply the new cellRenderer to the whole table */
		TableColumnModel tcm = jTableData.getColumnModel();
		for (int it = 0; it < tcm.getColumnCount(); it++) {
			tcm.getColumn(it).setCellRenderer(jTableCellRenderer);
			// tcm.getColumn(it).setCellEditor(jTableCellEditor);
		}
		/*
		 * Note: if we need to edit the values inside the embedded jtable we
		 * will need to create a TableCellEditor too.
		 */

	}

}
