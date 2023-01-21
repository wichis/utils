package mx.ryo.xoloitek.commons.utils.bundle;

public enum MsgBundleType {
	/**
	 * Operacion fallida
	 */
	OP_FALLIDA("operacion_fallida");
	
	private String key;
	private MsgBundleType(String ky) {
		this.key = ky;
	}
	public String getKey() {
		return key;
	}
}
