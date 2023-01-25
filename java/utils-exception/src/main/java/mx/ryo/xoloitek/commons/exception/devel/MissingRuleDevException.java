package mx.ryo.xoloitek.commons.exception.devel;

import org.springframework.http.HttpStatus;

import mx.ryo.xoloitek.commons.exception.DevelLogicException;
import mx.ryo.xoloitek.commons.exception.dto.ApiErrorResponseDto;
import mx.ryo.xoloitek.commons.exception.type.LevelError;
import mx.ryo.xoloitek.commons.exception.utils.StringCodeError;

public class MissingRuleDevException extends DevelLogicException {
	
	private static final long serialVersionUID = 1L;
	private final static String DEFAULT_ERR_MSG = "[STRAY SHEEP]";
	private LevelError levelError;
	
	private HttpStatus httpResponse;
	private StringCodeError scode;
	private ApiErrorResponseDto apiResponse;
	private static final String TO_BE_DEFINED = "TBD";

	/**
	 * The internal server error was be responsed.
	 * 
	 * @param levelError Provide
	 * @param errMsg
	 */
	public MissingRuleDevException(String technicalDetails) {
		super(new StringCodeError(LevelError.INTERNAL_KNOWN, 5), technicalDetails);
		this.scode = scode;
		this.httpResponse = HttpStatus.INTERNAL_SERVER_ERROR;
		this.apiResponse = ApiErrorResponseDto.builder().scode(this.scode.format()).resume(TO_BE_DEFINED)
				.technicalDetails(technicalDetails).build();
	}

	public MissingRuleDevException(HttpStatus httpResponse, String technicalDetails) {
		super(new StringCodeError(LevelError.INTERNAL_KNOWN, 5), httpResponse, technicalDetails);
		this.scode = scode;
		this.httpResponse = httpResponse;
		this.apiResponse = ApiErrorResponseDto.builder().scode(this.scode.format()).resume(TO_BE_DEFINED)
				.technicalDetails(technicalDetails).build();
	}
}
