package mx.ryo.xoloitek.commons.utils.api;

public enum InternalHeaderType {
	/**
	 * Cuando un servicio envié un 204-No Content como respuesta, podrá enviarse
	 * este header para proporcionar mayor información.
	 */
	X_CRO("X-XOLO-Cro"),
	/**
	 * Identificador del usuario
	 */
	X_USER("X-XOLO-User"),
	/**
	 * Identificador del role
	 */
	X_ROLE("X-XOLO-Role"),
	/**
	 * Identificador de la aplicacion
	 */
	X_APP("X-XOLO-App"),
	/**
	 * Request UUID to track operation on log files.
	 */
	X_REQUEST_ID("X-XOLO-Request-Id"),
	/**
	 * Request UUID to identify and specific session opened on a sytem, this session
	 * has no relation with login session open.
	 */
	X_SESSION_ID("X-XOLO-Session-Id"),
	/**
	 * Request device name for identify it.
	 */
	X_USER_DEVICE_ID("X-XOLO-User-Device-Id"),
	/**
	 * Request UUID to identify and specific session opened on a sytem, this session
	 * has no relation with login session open.
	 */
	X_REQUEST_TIME("X-XOLO-Request-Time");

	private String key;

	private InternalHeaderType(String k) {
		this.key = k;
	}

	public String getKey() {
		return key;
	}

}
