package mx.ryo.xoloitek.commons.exception.devel;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import mx.ryo.xoloitek.commons.exception.DevelLogicException;
import mx.ryo.xoloitek.commons.exception.dto.ApiErrorResponseDto;
import mx.ryo.xoloitek.commons.exception.type.LevelError;
import mx.ryo.xoloitek.commons.exception.utils.StringCodeError;

@Getter
public class CaseNotImplementedException extends DevelLogicException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	public CaseNotImplementedException( String technicalDetails) {
		super(new StringCodeError(LevelError.INTERNAL_KNOWN, 1), technicalDetails);
		this.scode = super.getScode();
		this.httpResponse = HttpStatus.INTERNAL_SERVER_ERROR;
		this.apiResponse = ApiErrorResponseDto.builder().scode(this.scode.format()).resume(TO_BE_DEFINED)
				.technicalDetails(technicalDetails).build();
	}

	public CaseNotImplementedException( HttpStatus httpResponse, String technicalDetails) {
		super(new StringCodeError(LevelError.INTERNAL_KNOWN, 1), httpResponse, technicalDetails);
		this.scode = super.getScode();
		this.httpResponse = httpResponse;
		this.apiResponse = ApiErrorResponseDto.builder().scode(this.scode.format()).resume(TO_BE_DEFINED)
				.technicalDetails(technicalDetails).build();
	}
}
