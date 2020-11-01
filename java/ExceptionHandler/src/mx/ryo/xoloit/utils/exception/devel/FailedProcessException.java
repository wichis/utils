package mx.ryo.xoloit.utils.exception.devel;

import mx.ryo.xoloit.utils.exception.DevelLogicException;

public class FailedProcessException extends DevelLogicException {
	private final static String DEFAULT_ERR_MSG = "Proceso interrumpido por fallo";
	public FailedProcessException() {
		super(DEFAULT_ERR_MSG);
	}
	public FailedProcessException(String errMsg) {
		super(errMsg);
	}
}
