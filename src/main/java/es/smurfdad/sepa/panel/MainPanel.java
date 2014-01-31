package es.smurfdad.sepa.panel;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public MainPanel() {
		super();
		setLayout(new GridLayout(2,1));
		add(new CodigoAcreedorPanel(), 0);
		add(new IbanPanel(), 1);
	}






}
