package es.smurfdad.utils.validator;

import com.aeat.valida.Validador;

public class NifCifNieValidator extends Validator {

	@Override
	protected boolean validate(Object pObj) {
		boolean resultado = false;
		if (pObj instanceof String) {
			Validador val = new Validador();
			int resVal = val.checkNif((String) pObj);
			if (resVal == Validador.CIF_OK
					|| resVal == Validador.CIF_ORGANIZACION_OK
					|| resVal == Validador.DNI_OK
					|| resVal == Validador.NIF_OK) {
				resultado = true;

			}

		}
		return resultado;
	}

}
