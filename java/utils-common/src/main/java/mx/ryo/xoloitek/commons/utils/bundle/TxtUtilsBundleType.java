package mx.ryo.xoloitek.commons.utils.bundle;

public enum TxtUtilsBundleType {
	/**
	 * String para definir que es un texto oculto
	 */
	OCULTAR_TXT("ocultar_texto");
	
	private String key;
	private TxtUtilsBundleType(String ky) {
		this.key = ky;
	}
	public String getKey() {
		return key;
	}
}
