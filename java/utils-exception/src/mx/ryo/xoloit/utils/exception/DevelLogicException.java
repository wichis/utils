package mx.ryo.xoloit.utils.exception;

public class DevelLogicException extends Exception {
	private final static String DEFAULT_ERR_MSG = "Fallo proceso en ejecucion";
	public DevelLogicException() {
		super(DEFAULT_ERR_MSG);
	}
	
	public DevelLogicException(String errMsg) {
		super(errMsg);
	}
}
