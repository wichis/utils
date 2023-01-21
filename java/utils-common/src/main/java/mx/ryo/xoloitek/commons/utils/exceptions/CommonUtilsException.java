package mx.ryo.xoloitek.commons.utils.exceptions;

public class CommonUtilsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static String DEFAULT_ERR_MSG = "Error en la utileria. Verifica su correcta funcionalidad.";
	
	private String ticket;	
	public CommonUtilsException() {
		super(DEFAULT_ERR_MSG);
	}
	
	public CommonUtilsException(String errMsg) {
		super(errMsg);
	}
	

}
