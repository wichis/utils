package mx.ryo.xoloitek.commons.exception.devel;

import org.springframework.http.HttpStatus;

import mx.ryo.xoloitek.commons.exception.DevelLogicException;
import mx.ryo.xoloitek.commons.exception.type.LevelError;

public class CaseNotImplementedException extends DevelLogicException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static String DEFAULT_ERR_MSG = "No existe implementacion para este caso formulado en el flujo";

	/**
	 * The internal server error was be responsed.
	 * 
	 * @param levelError Provide
	 * @param errMsg
	 */
	public CaseNotImplementedException(LevelError levelError, String errMsg) {
		super(LevelError.INTERNAL_KNOWN, HttpStatus.INTERNAL_SERVER_ERROR, errMsg);
		this.levelError = levelError;
	}

	public CaseNotImplementedException(LevelError levelError, HttpStatus httpResponse, String errMsg) {
		super(levelError, httpResponse, errMsg);
		this.levelError = levelError;
		this.httpResponse = httpResponse;
	}
}
