package mx.ryo.xoloitek.commons.exception.devel;

import org.springframework.http.HttpStatus;

import mx.ryo.xoloitek.commons.exception.DevelLogicException;
import mx.ryo.xoloitek.commons.exception.type.LevelError;

public class DataNotFoundException extends DevelLogicException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static String DEFAULT_ERR_MSG = "No se encontraron coincidencias en la busqueda con los criterios seleccionados.";
	private LevelError levelError;
	private HttpStatus httpResponse;

	public DataNotFoundException(String errMsg) {
		super(errMsg);
		this.levelError = LevelError.INTERNAL_KNOWN;
		this.httpResponse = HttpStatus.NO_CONTENT;
	}

	/**
	 * The internal server error was be responsed.
	 * 
	 * @param levelError Provide
	 * @param errMsg
	 */
	public DataNotFoundException(LevelError levelError, String errMsg) {
		super(errMsg);
		this.levelError = levelError;
		this.httpResponse = HttpStatus.INTERNAL_SERVER_ERROR;
	}

	public DataNotFoundException(LevelError levelError, HttpStatus httpResponse, String errMsg) {
		super(errMsg);
		this.levelError = levelError;
		this.httpResponse = httpResponse;
	}
}
