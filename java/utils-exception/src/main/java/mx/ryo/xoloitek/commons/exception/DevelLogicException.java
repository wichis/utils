package mx.ryo.xoloitek.commons.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import mx.ryo.xoloitek.commons.exception.dto.ApiErrorResponseDto;
import mx.ryo.xoloitek.commons.exception.type.LevelError;
import mx.ryo.xoloitek.commons.exception.utils.MsgBundleUtils;
import mx.ryo.xoloitek.commons.exception.utils.StringCodeError;

@Getter
public class DevelLogicException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StringCodeError scode;
	private HttpStatus httpResponse;
	private ApiErrorResponseDto apiResponse;
	private static final String TO_BE_DEFINED = "TBD";
	private static final Integer CODE_SERIE = 1;

	/**
	 * 
	 */
	public DevelLogicException() {
		super(MsgBundleUtils.useResponse("business_logic.default.technical"));
		this.scode = new StringCodeError(LevelError.INTERNAL_UNKNOWN, CODE_SERIE);
		this.httpResponse = HttpStatus.INTERNAL_SERVER_ERROR;
		this.apiResponse = ApiErrorResponseDto.builder().scode(this.scode.format()).resume(TO_BE_DEFINED)
				.technicalDetails(MsgBundleUtils.useResponse("development_logic.default.technical")).build();
	}

	/**
	 * 
	 * @param lvlError 
	 * @param technicalDetails
	 */
	public DevelLogicException(LevelError lvlError, String technicalDetails) {
		super(technicalDetails);
		this.scode = new StringCodeError(lvlError, CODE_SERIE);
		this.httpResponse = HttpStatus.INTERNAL_SERVER_ERROR;
		this.apiResponse = ApiErrorResponseDto.builder().scode(this.scode.format()).resume(TO_BE_DEFINED)
				.technicalDetails(technicalDetails).build();
	}

	/**
	 * 
	 * @param lvlError
	 * @param httpResponse
	 * @param technicalDetails
	 */
	public DevelLogicException(LevelError lvlError, HttpStatus httpResponse, String technicalDetails) {
		super(technicalDetails);
		this.scode = new StringCodeError(lvlError, CODE_SERIE);
		this.httpResponse = httpResponse;
		this.apiResponse = ApiErrorResponseDto.builder().scode(this.scode.format()).resume(TO_BE_DEFINED)
				.technicalDetails(technicalDetails).build();
	}
}
