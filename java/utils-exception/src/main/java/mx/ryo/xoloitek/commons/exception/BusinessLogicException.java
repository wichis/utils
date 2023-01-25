package mx.ryo.xoloitek.commons.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import mx.ryo.xoloitek.commons.exception.dto.ApiErrorResponseDto;
import mx.ryo.xoloitek.commons.exception.type.LevelError;
import mx.ryo.xoloitek.commons.exception.utils.MsgBundleUtils;
import mx.ryo.xoloitek.commons.exception.utils.StringCodeError;

@Getter
public class BusinessLogicException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StringCodeError scode;
	private HttpStatus httpResponse;
	private ApiErrorResponseDto apiResponse;
	private static final String TO_BE_DEFINED = "TBD";

	public BusinessLogicException() {
		super(MsgBundleUtils.useResponse("business_logic.default.resume"));
		this.scode = new StringCodeError(LevelError.INTERNAL_UNKNOWN, 0);
		this.httpResponse = HttpStatus.INTERNAL_SERVER_ERROR;
		this.apiResponse = ApiErrorResponseDto.builder().scode(this.scode.format()).resume(TO_BE_DEFINED)
				.technicalDetails(MsgBundleUtils.useResponse("business_logic.default.technical")).build();
	}

	/**
	 * The internal server error was be responsed.
	 * 
	 * @param levelError Provide
	 * @param errMsg
	 */
	public BusinessLogicException(StringCodeError scode, String technicalDetails) {
		super(technicalDetails);
		this.scode = scode;
		this.httpResponse = HttpStatus.INTERNAL_SERVER_ERROR;
		this.apiResponse = ApiErrorResponseDto.builder().scode(this.scode.format()).resume(TO_BE_DEFINED)
				.technicalDetails(technicalDetails).build();
	}

	public BusinessLogicException(StringCodeError scode, HttpStatus httpResponse, String technicalDetails) {
		super(technicalDetails);
		this.scode = scode;
		this.httpResponse = httpResponse;
		this.apiResponse = ApiErrorResponseDto.builder().scode(this.scode.format()).resume(TO_BE_DEFINED)
				.technicalDetails(technicalDetails).build();
	}

}
