package es.smurfdad.sepa.panel;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.smurfdad.sepa.util.CodigoControl;
import es.smurfdad.util.swing.ValidableTextField;
import es.smurfdad.utils.validator.NifCifNieValidator;

public class CodigoAcreedorPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(CodigoAcreedorPanel.class);
	private final ValidableTextField fCif;
	private final JTextField fCodAcreedor;
	private final NifCifNieValidator validador = new NifCifNieValidator();
	public CodigoAcreedorPanel() {
		super();
		setLayout(new FlowLayout(FlowLayout.LEFT));
		fCif = new ValidableTextField(20) {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean validation(String pValue) {
				boolean resultado = false;
				try{
					String cadena = StringUtils.upperCase(StringUtils.trimToEmpty(pValue));
					validador.isValid(StringUtils.trimToEmpty(cadena));
					resultado = true;
					fCodAcreedor.setText(calculoCodigoAcreedor(cadena));
				}catch (IllegalArgumentException e) {
					fCodAcreedor.setText("");
				}

				return resultado;
			}
		};
		add(new JLabel("CIF:"));
		add(fCif);
		add(new JLabel("Cod. Acreedor:"));
		fCodAcreedor = new JTextField(20);
		fCodAcreedor.setEditable(false);
		add(fCodAcreedor);

	}

	private String calculoCodigoAcreedor(String cif){

		String codPais = "ES"; //ES: c�digo del pa�s Espa�a seg�n la norma ISO 3166
		String dc = "ZZ";//ZZ: d�gitos de control (cuyo c�lculo se explica a continuaci�n)
		String sufijo = "000";//XXX: sufijo (normalmente 000, pero el acreedor puede gestionar m�s de un canal de adeudos poniendo otros valores)

		dc = CodigoControl.get(codPais, cif);

		StringBuffer resultado = new StringBuffer();
		resultado.append(codPais);
		resultado.append(dc);
		resultado.append(sufijo);
		resultado.append(cif);

		return resultado.toString();
	}

}
