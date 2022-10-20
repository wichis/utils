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
	APP("X_APP"),
	/**
	 * Identificador de la opcion
	 */	
	PAGE("X_PAGE"),
	/**
	 * Mensaje que se podra msotrar en la notificacion
	 */	
	MSG("X_MSG"),
	/**
	 * Modo de notificacion
	 * {modal, tip, toast}
	 */	
	NOTIFY("X_NOTIFY"),
	/**
	 * Siguiente accion
	 * {continue, confirm, warn, info, error}
	 */	
	NACTION("X_NACTION"),;

	public String key;

	private XitHeaderType(String k) {
		this.key = k;
	}

	public String getKey() {
		return key;
	}

}
