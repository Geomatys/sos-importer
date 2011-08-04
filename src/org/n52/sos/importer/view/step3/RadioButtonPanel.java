package org.n52.sos.importer.view.step3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.n52.sos.importer.controller.MainController;
import org.n52.sos.importer.model.table.TableElement;

/**
 * used for all radio buttons in step 3
 * @author Raimund
 *
 */
public abstract class RadioButtonPanel extends SelectionPanel {
	
	private static final long serialVersionUID = 1L;
	
	protected ButtonGroup group = new ButtonGroup();
	
	public RadioButtonPanel(JPanel containerPanel) {
		super(containerPanel);
        this.setLayout(new GridLayout(0, 1));
	}
	
	/**
	 * creates a radio button with the given name on the panel
	 * @param name
	 */
	protected void addRadioButton(String name) {
		JRadioButton radioButton = new JRadioButton(name);
		radioButton.addActionListener(new RemoveChildPanel());
		if (group.getButtonCount() == 0) 
			radioButton.setSelected(true);
		group.add(radioButton);
		this.add(radioButton);
	}
	
	/**
	 * creates a radio button with the given name on the panel,
	 * when this button is pressed the given selection panel appears
	 * @param name
	 */
	protected void addRadioButton(String name, String toolTip, SelectionPanel childPanel) {
		JRadioButton radioButton = new JRadioButton(name);
		if (toolTip != null) 
			radioButton.setToolTipText(toolTip);
		addChildPanel(name, childPanel);
		radioButton.addActionListener(new AddChildPanel(childPanel));
		if (group.getButtonCount() == 0) {
			radioButton.setSelected(true);
			setSelectedChildPanel(childPanel);
		}
		group.add(radioButton);
		this.add(radioButton);
	}

	@Override
	public void setSelection(String s) {
		ButtonModel m = null;
		Enumeration<AbstractButton> e = group.getElements();
		while(e.hasMoreElements()) {
			JRadioButton b = (JRadioButton) e.nextElement();
			if (s.equals(b.getText())) {
				m = b.getModel();
				break;
			}
		}	
		group.setSelected(m, true);	
	}
	
	@Override
	public void setDefaultSelection() {
		JRadioButton firstButton = (JRadioButton) group.getElements().nextElement();
		group.setSelected(firstButton.getModel(), true);
		setSelectedChildPanel(firstButton.getText());
	}

	@Override
	public String getSelection() {
		Enumeration<AbstractButton> e = group.getElements();
		while(e.hasMoreElements()) {
			JRadioButton b = (JRadioButton) e.nextElement();
			if (b.isSelected()) {
				return b.getText();
			}
		}
		return null;
	}
	
	@Override
	public void assign(TableElement tableElement) {		
	}
	
	@Override
	public void unassign(TableElement tableElement) {
	};
	
	/**
	 * action when a radio button with selection panel is pressed
	 * @author Raimund
	 */
	private class AddChildPanel implements ActionListener {
		SelectionPanel childPanel;
		
		public AddChildPanel(SelectionPanel childPanel) {
			this.childPanel = childPanel;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (getSelectedChildPanel() != null) 
				getSelectedChildPanel().removeFromContainerPanel();
			
			setSelectedChildPanel(childPanel);
			childPanel.addToContainerPanel();		
			
			MainController.getInstance().pack();
			patternChanged();
		}	
	}
	
	/**
	 * action when a radio button without any child panels is pressed
	 * @author Raimund
	 */
	private class RemoveChildPanel implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (getSelectedChildPanel() != null) {
				getSelectedChildPanel().removeFromContainerPanel();
				MainController.getInstance().pack();
				
				SelectionPanel childPanel = null;
				setSelectedChildPanel(childPanel);
			}
			patternChanged();
		}		
	}
}
