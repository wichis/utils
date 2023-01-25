package mx.ryo.xoloitek.commons.exception.business;

import org.springframework.http.HttpStatus;

import mx.ryo.xoloitek.commons.exception.BusinessLogicException;
import mx.ryo.xoloitek.commons.exception.dto.ApiErrorResponseDto;
import mx.ryo.xoloitek.commons.exception.type.LevelError;
import mx.ryo.xoloitek.commons.exception.utils.MsgBundleUtils;
import mx.ryo.xoloitek.commons.exception.utils.StringCodeError;

public class MissingRuleBusException extends BusinessLogicException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HttpStatus httpResponse;
	private StringCodeError scode;
	private ApiErrorResponseDto apiResponse;
	private static final String TO_BE_DEFINED = "TBD";

	public MissingRuleBusException() {
		super(new StringCodeError(LevelError.INTERNAL_UNKNOWN, 1), MsgBundleUtils.useResponse("missing_rule.default.technical"));
		this.scode = new StringCodeError(LevelError.INTERNAL_UNKNOWN, 1);
		this.httpResponse = HttpStatus.INTERNAL_SERVER_ERROR;
		this.apiResponse = ApiErrorResponseDto.builder().scode(this.scode.format()).resume(TO_BE_DEFINED)
				.technicalDetails(MsgBundleUtils.useResponse("missing_rule.default.technical")).build();
	}

	/**
	 * The internal server error was be responsed.
	 * 
	 * @param levelError Provide
	 * @param errMsg
	 */
	public MissingRuleBusException(StringCodeError scode, String technicalDetails) {
		super(scode, technicalDetails);
		this.scode = scode;
		this.httpResponse = HttpStatus.INTERNAL_SERVER_ERROR;
		this.apiResponse = ApiErrorResponseDto.builder().scode(this.scode.format()).resume(TO_BE_DEFINED)
				.technicalDetails(technicalDetails).build();
	}

	public MissingRuleBusException(StringCodeError scode, HttpStatus httpResponse, String technicalDetails) {
		super(scode, httpResponse, technicalDetails);
		this.scode = scode;
		this.httpResponse = httpResponse;
		this.apiResponse = ApiErrorResponseDto.builder().scode(this.scode.format()).resume(TO_BE_DEFINED)
				.technicalDetails(technicalDetails).build();
	}
}
