package mx.ryo.xoloitek.commons.exception.devel;

import org.springframework.http.HttpStatus;

import mx.ryo.xoloitek.commons.exception.DevelLogicException;
import mx.ryo.xoloitek.commons.exception.type.LevelError;

public class FailedProcessException extends DevelLogicException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static String DEFAULT_ERR_MSG = "El proceso fue interrumpido por fallo";
	private LevelError levelError;
	private HttpStatus httpResponse;
	
	public FailedProcessException() {
		super(DEFAULT_ERR_MSG);
		this.levelError = LevelError.INTERNAL_KNOWN;
		this.httpResponse = HttpStatus.INTERNAL_SERVER_ERROR;
	}
	
	public FailedProcessException(String errMsg) {
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
	public FailedProcessException(LevelError levelError, String errMsg) {
		super(errMsg);
		this.levelError = levelError;
		this.httpResponse = HttpStatus.INTERNAL_SERVER_ERROR;
	}

	public FailedProcessException(LevelError levelError, HttpStatus httpResponse, String errMsg) {
		super(errMsg);
		this.levelError = levelError;
		this.httpResponse = httpResponse;
	}
}
