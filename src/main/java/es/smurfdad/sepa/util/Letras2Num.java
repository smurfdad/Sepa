package es.smurfdad.sepa.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class Letras2Num {

	private static Map<String, String> tablaPesos = new HashMap<String, String>();
	static{
		tablaPesos.put("A","10");
		tablaPesos.put("B","11");
		tablaPesos.put("C","12");
		tablaPesos.put("D","13");
		tablaPesos.put("E","14");
		tablaPesos.put("F","15");
		tablaPesos.put("G","16");
		tablaPesos.put("H","17");
		tablaPesos.put("I","18");
		tablaPesos.put("J","19");
		tablaPesos.put("K","20");
		tablaPesos.put("L","21");
		tablaPesos.put("M","22");
		tablaPesos.put("N","23");
		tablaPesos.put("O","24");
		tablaPesos.put("P","25");
		tablaPesos.put("Q","26");
		tablaPesos.put("R","27");
		tablaPesos.put("S","28");
		tablaPesos.put("T","29");
		tablaPesos.put("U","30");
		tablaPesos.put("V","31");
		tablaPesos.put("W","32");
		tablaPesos.put("X","33");
		tablaPesos.put("Y","34");
		tablaPesos.put("Z","55");
	}

	public static String replace(String pCadena){

		String resultado = pCadena;
		for(String key: tablaPesos.keySet()){
			if (tablaPesos.containsKey(key)){
				resultado = StringUtils.replace(resultado, key, tablaPesos.get(key));
			}
		}
		return resultado;
	}
}
