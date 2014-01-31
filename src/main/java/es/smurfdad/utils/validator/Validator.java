package es.smurfdad.utils.validator;

public abstract class Validator {

	public void isValid(Object pObj){
		if (!validate(pObj)){
			throw new IllegalArgumentException();
		}
	}

	protected abstract boolean validate(Object pObj);
}
