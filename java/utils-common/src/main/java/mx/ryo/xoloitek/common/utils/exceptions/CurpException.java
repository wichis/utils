package mx.ryo.xoloitek.common.utils.exceptions;

public class CurpException extends CommonUtilsException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static String DEFAULT_ERR_MSG = "La generacion de la CURP fallo";
	public CurpException() {
		super(DEFAULT_ERR_MSG);
	}
	
	public CurpException(String errMsg) {
		super(errMsg);
	}
}
