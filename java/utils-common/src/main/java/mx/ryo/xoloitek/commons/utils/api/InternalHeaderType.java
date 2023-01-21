package mx.ryo.xoloitek.common.utils.api;

public enum InternalHeaderType {
	/**
	 * Con Respuesta Oculta
	 */
	CRO("X-XOLO-CRO"),
	/**
	 * Identificador del usuario
	 */
	USER("X-XOLO-User"), 
	/**
	 * Identificador del role
	 */
	ROLE("X-XOLO-Role"), 
	/**
	 * Identificador de la aplicacion
	 */
	APP("X-XOLO-App"),
	/**
	 * Identificador de la pantalla
	 */	
	REQUEST_ID("X-XOLO-Request-Id"),
	/**
	 * Mensaje que se podra msotrar en la notificacion
	 */	
	SESSION_ID("X-XOLO-Session-Id"),
	/**
	 * Modo de notificacion
	 * {modal, tip, toast}
	 */	
	USER_DEVICE_ID("X-XOLO-User-Device-Id"),
	/**
	 * Siguiente accion
	 * {continue, confirm, warn, info, error}
	 */	
	REQUEST_TIME("X-XOLO-Request-Time"),;

	private String key;

	private InternalHeaderType(String k) {
		this.key = k;
	}

	public String getKey() {
		return key;
	}

}
