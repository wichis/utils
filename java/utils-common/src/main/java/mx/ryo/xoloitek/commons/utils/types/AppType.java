package mx.ryo.xoloitek.common.utils.types;

/**
 * Catalogo de aplicaciones
 * 
 * <ul>
 * <li>La clave debe tener 4 caracteres</li>
 * </ul>
 * @author wichi
 *
 */
public enum AppType {
	AMOXATLI("AMOX"),
	TLACATL("TLAC"),
	POCHTEKATL("POCH");

	private String cve;

	private AppType(String cve) {
		this.cve = cve;
	}

	public String getCve() {
		return cve;
	}
	

}
