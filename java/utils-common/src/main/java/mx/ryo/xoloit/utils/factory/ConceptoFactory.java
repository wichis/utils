package mx.ryo.xoloit.utils.factory;

public class ConceptoFactory {
	
	public static final String encodeIdUsuario(Long idUsuario) {
		return String.format("'U'%016d", idUsuario).toString();
	}
}
