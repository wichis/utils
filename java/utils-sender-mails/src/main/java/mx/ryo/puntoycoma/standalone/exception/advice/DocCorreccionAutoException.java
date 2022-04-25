package mx.ryo.puntoycoma.standalone.exception.advice;

import mx.edumex.dti.utils.exception.NegocioException;

public class DocCorreccionAutoException extends NegocioException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static String DEFAULT_INFO_MSG = "No se generó completamente el comprobante. Inténtalo una vez más, aplicamos algunas correcciones. Si el problema persiste, repórtalo de inmediato.";
	public DocCorreccionAutoException() {
		super(DEFAULT_INFO_MSG);
	}
	public DocCorreccionAutoException(String errMsg) {
		super(errMsg);
	}
}
