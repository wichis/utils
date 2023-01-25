package mx.ryo.xoloitek.commons.exception.utils;

import lombok.Data;
import mx.ryo.xoloitek.commons.exception.type.LevelError;

@Data
public class StringCodeError  {
	private final static String PREFIX = "ERR";
	private LevelError levelError;
	private Integer serial;
	
	public StringCodeError(LevelError levelError, Integer serial) {
		super();
		this.levelError = levelError;
		this.serial = serial;
	}
	
	public String format() {
		final StringBuffer sb = new StringBuffer();
		sb.append(PREFIX).append(this.levelError.getAbrev()).append("-").append(String.format("%04d", this.serial));
		return sb.toString();
	}
}
