package org.n52.sos.importer.view;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.n52.sos.importer.combobox.EditableComboBoxItems;
import org.n52.sos.importer.combobox.EditableJComboBoxPanel;
import org.n52.sos.importer.tooltips.ToolTips;
import org.n52.sos.importer.utils.JTextFieldFilter;

/**
 * offers settings for parsing the CSV file and 
 * displays a preview of the CSV file
 * @author Raimund, Eike
 *
 */
public class Step2Panel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private final EditableJComboBoxPanel columnSeparatorCombobox;
	private final EditableJComboBoxPanel commentIndicatorCombobox;
	private final EditableJComboBoxPanel textQualifierCombobox;
	
	private final JTextArea csvFileTextArea = new JTextArea(7, 30);
	
	private final JTextField firstLineWithDataTF;
	private final JLabel firstLineWithDataJL;
	
	public Step2Panel() {
		super();
		
		EditableComboBoxItems items = EditableComboBoxItems.getInstance();
		columnSeparatorCombobox = new EditableJComboBoxPanel(items.getColumnSeparators(), "Column separator", ToolTips.get("ColumnSeparator"));
		commentIndicatorCombobox = new EditableJComboBoxPanel(items.getCommentIndicators(), "Comment indicator", ToolTips.get("CommentIndicator"));
		textQualifierCombobox = new EditableJComboBoxPanel(items.getTextQualifiers(), "Text qualifier", ToolTips.get("TextQualifier"));
		
		firstLineWithDataTF = new JTextField(1);
		firstLineWithDataTF.setDocument(new JTextFieldFilter(JTextFieldFilter.NUMERIC));
		firstLineWithDataTF.setText("1");
		firstLineWithDataJL = new JLabel("First Line with data:");
		
		JPanel firstLineWithDataJPanel = new JPanel();
		firstLineWithDataJPanel.setLayout(new BoxLayout(firstLineWithDataJPanel, BoxLayout.LINE_AXIS));
		firstLineWithDataJPanel.add(firstLineWithDataJL);
		firstLineWithDataJPanel.add(firstLineWithDataTF);
		
		csvFileTextArea.setEditable(false);		
		
		JPanel csvSettingsPanel = new JPanel();
		csvSettingsPanel.setLayout(new GridLayout(4,1));
		csvSettingsPanel.add(columnSeparatorCombobox);
		csvSettingsPanel.add(commentIndicatorCombobox);
		csvSettingsPanel.add(textQualifierCombobox);
		// TODO add when it is used
		//csvSettingsPanel.add(firstLineWithDataJPanel);
		this.add(csvSettingsPanel);
		
		JScrollPane scrollPane = new JScrollPane(csvFileTextArea);
		this.add(scrollPane);
	}
	
	/**
	 * @return user input or <code>-1</code> if invalid input is defined
	 */
	public int getFirstLineWithData() {
		String text = firstLineWithDataTF.getText();
		if(text == null || text.equalsIgnoreCase("")) {
			return -1;
		} else {
			try {
				int line = Integer.parseInt(text);
				return line;
			} catch (NumberFormatException nfe) {
				return -1;
			}
		}
	}
	
	public String getSelectedColumnSeparator() {
		return (String) columnSeparatorCombobox.getSelectedItem();
	}
	
	public String getSelectedCommentIndicator() {
		return (String) commentIndicatorCombobox.getSelectedItem();
	}
	
	public String getSelectedTextQualifier() {
		return (String) textQualifierCombobox.getSelectedItem();
	}
	
	public void setFirstLineWithData(int firstLineWithData) {
		firstLineWithDataTF.setText("" + firstLineWithData);
	}
	
	public void setSelectedColumnSeparator(String columnSeparator) {
		columnSeparatorCombobox.setSelectedItem(columnSeparator);
	}
	
	public void setSelectedCommentIndicator(String commentIndicator) {
		commentIndicatorCombobox.setSelectedItem(commentIndicator);
	}
	
	public void setSelectedTextQualifier(String textQualifier) {
		textQualifierCombobox.setSelectedItem(textQualifier);
	}
		
	public String getCSVFileContent() {
		return csvFileTextArea.getText();
	}
	
	public void setCSVFileContent(String content) {
		csvFileTextArea.setText(content);
		csvFileTextArea.setCaretPosition(0);	
	}
}
