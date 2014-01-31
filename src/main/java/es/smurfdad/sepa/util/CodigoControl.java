package es.smurfdad.sepa.util;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

public class CodigoControl {

	public static String get(String pCodPais, String pCadena){
		BigDecimal numero = new BigDecimal(Letras2Num.replace(StringUtils.trimToEmpty(pCadena) + pCodPais + "00"));
		BigDecimal resto = numero.remainder(new BigDecimal(97));
		String resultado = (new BigDecimal(98).subtract(resto)).toPlainString();
		return StringUtils.leftPad(resultado, 2, "0");
	}


}
