package es.smurfdad.sepa;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.smurfdad.sepa.panel.MainPanel;

public class Sepa extends JFrame implements WindowListener {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(Sepa.class);

	/**
	 * @param args
	 * 
	 */
	private Sepa(){
		setTitle("Utilidades Sepa");
		setAlwaysOnTop(true);
		addWindowListener(this);
		setContentPane(new MainPanel());
		pack();
		setResizable(false);
		setVisible(true);
	}
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			logger.info("Aplicación inicializada");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			logger.error("No se puede inicializar la aplicación", e);
		}

		// Ablimos la ventana de la aplicacion
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Sepa().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});

	}
	@Override
	public void windowActivated(WindowEvent pE) {
		logger.info("windowActivated");

	}
	@Override
	public void windowClosed(WindowEvent pE) {
		logger.info("windowClosed");
	}
	@Override
	public void windowClosing(WindowEvent pE) {
		logger.info("windowClosing");

	}
	@Override
	public void windowDeactivated(WindowEvent pE) {
		logger.info("windowDeactivated");

	}
	@Override
	public void windowDeiconified(WindowEvent pE) {
		logger.info("windowDeiconified");

	}
	@Override
	public void windowIconified(WindowEvent pE) {
		logger.info("windowIconified");

	}
	@Override
	public void windowOpened(WindowEvent pE) {
		logger.info("windowOpened");
	}
}
