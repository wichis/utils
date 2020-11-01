package mx.ryo.xoloit.utils.exception.devel;

import mx.ryo.xoloit.utils.exception.DevelLogicException;

public class DataNotFoundException extends DevelLogicException {
	private final static String DEFAULT_ERR_MSG = "No se encontraron coincidencias";
	public DataNotFoundException() {
		super(DEFAULT_ERR_MSG);
	}
	
	public DataNotFoundException(String errMsg) {
		super(errMsg);
	}
}
