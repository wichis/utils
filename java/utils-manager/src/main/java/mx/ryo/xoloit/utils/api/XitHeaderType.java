package mx.ryo.xoloit.utils.api;

public enum XitHeaderType {
	/**
	 * Con Respuesta Oculta
	 */
	CRO("X_CRO"),
	/**
	 * Identificador del usuario
	 */
	USER("X_USER"), 
	/**
	 * Identificador del grupo
	 */
	GROUP("X_GROUP"), 
	/**
	 * Identificador de la aplicacion
	 */
	APP("X_APP");

	public String key;

	private XitHeaderType(String k) {
		this.key = k;
	}

	public String getKey() {
		return key;
	}

}
