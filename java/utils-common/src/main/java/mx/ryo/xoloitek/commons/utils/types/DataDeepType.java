package mx.ryo.xoloitek.commons.utils.types;

/**
 * Cataloga la profundidad de de los datos que se estan solicitando.
 * @author wichi
 *
 */
public enum DataDeepType {
	/**
	 * Unicamente extae informacion de los objetos String, Integer, Long, etc.
	 */
	BASIC,
	/**
	 * Extrae todos los valores de los objetos.
	 */
	COMPLETE, 
	/**
	 * Especifica que tipo de informacion quiere que sea extraida .
	 */
	ADVANCED,
	/**
	 * Extrae valores de una forma especial.
	 */
	SPECIAL;
}
