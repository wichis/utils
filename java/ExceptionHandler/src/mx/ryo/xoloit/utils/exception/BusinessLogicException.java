package mx.ryo.xoloit.utils.exception;

public class BusinessLogicException extends Exception {
	private final static String DEFAULT_ERR_MSG = "Error en la logica de negocio";
	public BusinessLogicException() {
		super(DEFAULT_ERR_MSG);
	}
	public BusinessLogicException(String errMsg) {
		super(errMsg);
	}
}
