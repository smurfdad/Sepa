package es.smurfdad.sepa.panel;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.commons.lang.StringUtils;

import es.smurfdad.sepa.util.CodigoControl;
import es.smurfdad.util.swing.ValidableTextField;
import es.smurfdad.utils.validator.CuentaBancariaValidator;

public class IbanPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final ValidableTextField fCcc;
	private final JTextField fIban;
	private final CuentaBancariaValidator validador = new CuentaBancariaValidator();
	public IbanPanel() {
		super();
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(new JLabel("CCC:"));
		fCcc = new ValidableTextField(20){

			private static final long serialVersionUID = 1L;

			@Override
			public boolean validation(String pValue) {
				boolean resultado = false;
				try{
					String cadena = StringUtils.upperCase(StringUtils.trimToEmpty(pValue));
					validador.isValid(StringUtils.trimToEmpty(cadena));
					resultado = true;
					fIban.setText(calculoCodigoIban(cadena));
				}catch (IllegalArgumentException e) {
					fIban.setText("");
				}

				return resultado;
			}

		};
		add(fCcc);
		add(new JLabel("IBAN:"));
		fIban = new JTextField(26);
		fIban.setEditable(false);
		add(fIban);
	}

	private String calculoCodigoIban(String ccc){
		String codPais = "ES"; //ES: código del país España según la norma ISO 3166
		String dc = "ZZ";//ZZ: dígitos de control (cuyo cálculo se explica a continuación)

		dc = CodigoControl.get(codPais, ccc);

		StringBuffer resultado = new StringBuffer();
		resultado.append("IBAN");
		resultado.append(codPais);
		resultado.append(dc);
		resultado.append(ccc);

		return resultado.toString();
	}




}
