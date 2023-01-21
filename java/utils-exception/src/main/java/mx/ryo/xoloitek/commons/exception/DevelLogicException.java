package mx.ryo.xoloitek.commons.exception;

import org.springframework.http.HttpStatus;

import mx.ryo.xoloitek.commons.exception.type.LevelError;

public class DevelLogicException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static String DEFAULT_ERR_MSG = "¡Ups! Algo falló. Reportelo inmediatamente.";
	protected LevelError levelError;
	
	protected HttpStatus httpResponse;

	public DevelLogicException() {
		super(DEFAULT_ERR_MSG);
		this.levelError = LevelError.INTERNAL_UNKNOWN;
		this.httpResponse = HttpStatus.INTERNAL_SERVER_ERROR;
	}

	public DevelLogicException(String errMsg) {
		super(errMsg);
		this.levelError = LevelError.INTERNAL_KNOWN;
		this.httpResponse = HttpStatus.INTERNAL_SERVER_ERROR;
	}

	public DevelLogicException(LevelError levelError, HttpStatus httpResponse, String errMsg) {
		super(errMsg);
		this.levelError = levelError;
		this.httpResponse = httpResponse;
	}
	
	/**
	 * The internal server error was be responsed.
	 * @param levelError Provide 
	 * @param errMsg
	 */
	public DevelLogicException(LevelError levelError, String errMsg) {
		super(errMsg);
		this.levelError = levelError;
		this.httpResponse = HttpStatus.INTERNAL_SERVER_ERROR;
	}
}
