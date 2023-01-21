package mx.ryo.xoloitek.commons.utils.pattern;

/**
 * Formatos de los conceptos usados en el manejo de datos, 
 * @author wichi
 *
 */
public enum ConceptoType {
	CODIGO_POSTAL("^[0-9]{5}"),
	USUARIO("^(U)[0-9]{16}"),
	TICKET_ISSUE("^[A-Z]{4}[0-9]{8}(T)[0-9]{9}(U)[0-9]{16}");
	
	private String pattern;
	
	private ConceptoType(String patt) {
		this.pattern = patt;
	}

	public String getPattern() {
		return pattern;
	}

}
