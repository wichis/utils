package mx.ryo.xoloitek.commons.exception.type;

public enum LevelError {
	CLIENT("C"), INTERNAL_UNKNOWN("U"), INTERNAL_KNOWN("K"), LOCAL_DEPENDENCY("L"), EXTERNAL_DEPENDENCY("E");

	private String abrev;

	private LevelError(String abrev) {
		this.abrev = abrev;
	}

	public String getAbrev() {
		return abrev;
	}

}
