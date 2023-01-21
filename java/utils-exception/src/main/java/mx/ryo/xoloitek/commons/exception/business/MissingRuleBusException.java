package mx.ryo.xoloitek.commons.exception.business;

import org.springframework.http.HttpStatus;

import mx.ryo.xoloitek.commons.exception.BusinessLogicException;
import mx.ryo.xoloitek.commons.exception.type.LevelError;

public class MissingRuleBusException extends BusinessLogicException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static String DEFAULT_INFO_MSG = "La solicitud se está procesando.";
	private LevelError levelError;
	private HttpStatus httpResponse;
	
	public MissingRuleBusException() {
		super(DEFAULT_INFO_MSG);
		this.levelError = LevelError.INTERNAL_UNKNOWN;
		this.httpResponse = HttpStatus.INTERNAL_SERVER_ERROR;
	}
	
	public MissingRuleBusException(String errMsg) {
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
	public MissingRuleBusException(LevelError levelError, String errMsg) {
		super(errMsg);
		this.levelError = levelError;
		this.httpResponse = HttpStatus.INTERNAL_SERVER_ERROR;
	}

	public MissingRuleBusException(LevelError levelError, HttpStatus httpResponse, String errMsg) {
		super(errMsg);
		this.levelError = levelError;
		this.httpResponse = httpResponse;
	}
}
