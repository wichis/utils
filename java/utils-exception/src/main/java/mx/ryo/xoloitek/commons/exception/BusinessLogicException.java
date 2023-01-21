package mx.ryo.xoloitek.commons.exception;

import org.springframework.http.HttpStatus;

import mx.ryo.xoloitek.commons.exception.type.LevelError;

public class BusinessLogicException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static String DEFAULT_ERR_MSG = "Error en la logica de negocio";
	private LevelError levelError;
	private HttpStatus httpResponse;

	public BusinessLogicException() {
		super(DEFAULT_ERR_MSG);
		this.levelError = LevelError.INTERNAL_UNKNOWN;
		this.httpResponse = HttpStatus.INTERNAL_SERVER_ERROR;
	}

	public BusinessLogicException(String errMsg) {
		super(errMsg);
		this.levelError = LevelError.INTERNAL_KNOWN;
		this.httpResponse = HttpStatus.INTERNAL_SERVER_ERROR;
	}

	/**
	 * The internal server error was be responsed.
	 * 
	 * @param levelError Provide
	 * @param errMsg
	 */
	public BusinessLogicException(LevelError levelError, String errMsg) {
		super(errMsg);
		this.levelError = levelError;
		this.httpResponse = HttpStatus.INTERNAL_SERVER_ERROR;
	}

	public BusinessLogicException(LevelError levelError, HttpStatus httpResponse, String errMsg) {
		super(errMsg);
		this.levelError = levelError;
		this.httpResponse = httpResponse;
	}

}
