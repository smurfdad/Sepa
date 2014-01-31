package es.smurfdad.util.swing;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;

public abstract class ValidableTextField extends JTextField {

	private static final long serialVersionUID = 1L;

	private static final Border wrongBorder = BorderFactory.createLineBorder(Color.RED);
	private final Border defaultBorder;

	/**
	 * Constructor.
	 * @param regEx Expresión regular para evaluar
	 */
	public ValidableTextField(int colums) {
		super(colums);
		defaultBorder = getBorder();
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) { }

			@Override
			public void keyReleased(KeyEvent e) {
				if (validation(getText())){
					setBorder(defaultBorder);
				} else {
					setBorder(wrongBorder);
				}
			}

			@Override
			public void keyPressed(KeyEvent pE) {
				// TODO Auto-generated method stub

			}
		});
	}

	public abstract boolean validation(String value);

}
