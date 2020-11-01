package mx.ryo.xoloit.utils.exception.devel;

import mx.ryo.xoloit.utils.exception.DevelLogicException;

public class CaseNotImplementedException extends DevelLogicException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static String DEFAULT_ERR_MSG = "No existe implementacion para algun caso formulado en el flujo";
	public CaseNotImplementedException() {
		super(DEFAULT_ERR_MSG);
	}
	
	public CaseNotImplementedException(String errMsg) {
		super(errMsg);
	}
}
