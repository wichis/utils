package mx.ryo.xoloitek.commons.utils.types;

/**
 * Catalogo de aplicaciones
 * 
 * <ul>
 * <li>La clave debe tener 4 caracteres</li>
 * </ul>
 * 
 * @author wichi
 *
 */
public enum AppType {
	AMOXATLI("AMOX"), TLACATL("TLAC"), POCHTEKATL("POCH");

	private String ennum;

	private AppType(String ennum) {
		this.ennum = ennum;
	}

	public String getEnnum() {
		return ennum;
	}

}
