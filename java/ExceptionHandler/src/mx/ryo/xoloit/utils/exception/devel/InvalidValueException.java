package mx.ryo.xoloit.utils.exception.devel;

import mx.ryo.xoloit.utils.exception.DevelLogicException;

public class InvalidValueException extends DevelLogicException {

	private static final long serialVersionUID = 1L;
	private final static String DEFAULT_ERR_MSG = "Valor contenido es invalido";
	public InvalidValueException() {
		super(DEFAULT_ERR_MSG);
	}
	public InvalidValueException(String errMsg) {
		super(errMsg);
	}
}
