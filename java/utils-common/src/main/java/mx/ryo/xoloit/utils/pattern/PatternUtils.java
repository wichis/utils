package mx.ryo.xoloit.utils.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternUtils {

	/**
	 * Verifica que el texto coincida con el patron
	 * @param concepto Usar un patron de los conceptos predefinidos.
	 * @param str Texto que sera sometido a evalucion
	 * @return
	 */
	public static final boolean matches(String str, ConceptoType concepto) {
		if (str == null)
			return false;
		Pattern patt = Pattern.compile(concepto.getPattern());
		Matcher m = patt.matcher(str);
		return m.matches();
	}
	
	/**
	 * Verifica que el texto coincida con el patron
	 * @param pattern Patron
	 * @param str Texto que sera sometido a evalucion
	 * @return
	 */
	public static final boolean matches(String str, String pattern) {
		if (str == null)
			return false;
		Pattern patt = Pattern.compile(pattern);
		Matcher m = patt.matcher(str);
		return m.matches();
	}
}
