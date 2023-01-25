package mx.ryo.xoloitek.commons.exception.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiErrorResponseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8851112067804044677L;

	private String scode;
	private String resume;
	private String technicalDetails;
	private Object extra;

}
