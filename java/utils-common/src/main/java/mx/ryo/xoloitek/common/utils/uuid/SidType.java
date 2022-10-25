package mx.ryo.xoloitek.common.utils.uuid;

public enum SidType {
	USER("UUSR"), 
	PERSON("PRSN");

	// Len = 4
	private String prefix;

	private SidType(String prefix) {
		this.prefix = prefix;
	}

	public String getPrefix() {
		return prefix;
	}

}
