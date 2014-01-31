package es.smurfdad.utils.validator;

import org.apache.commons.lang.StringUtils;


public class CuentaBancariaValidator extends Validator {
	private static int TABLA_PESOS[] = {1, 2, 4, 8, 5, 10, 9, 7, 3, 6};

	@Override
	protected boolean validate(Object pObj) {
		boolean resultado = false;

		String cadena = (String)pObj;
		if (cadena.length() == 20 && StringUtils.isNumeric(cadena)){

			String entidadOficina = cadena.substring(0,8);
			String dc = cadena.substring(8,10);
			String cuenta = cadena.substring(10,20);

			StringBuffer dcCalculado = new StringBuffer();
			dcCalculado.append(digitoControl(entidadOficina));
			dcCalculado.append(digitoControl(cuenta));

			if(dc.equals(dcCalculado.toString())){
				resultado = true;
			}else{
				resultado =  false;
			}
		}
		return resultado;
	}

	private int digitoControl(String pCadena){
		String cadena = StringUtils.leftPad(pCadena, 10, "0");
		int resultado = 0;
		int suma=0;
		for (int i=0; i<cadena.length() ; i++){
			suma += Character.getNumericValue(cadena.charAt(i))*TABLA_PESOS[i];
		}

		resultado = 11 - (suma % 11);
		if (resultado == 10){
			resultado = 1;
		}else if(resultado == 11){
			resultado = 0;
		}
		return resultado;
	}
}
