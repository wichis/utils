package mx.ryo.xoloitek.common.utils.factory;

import java.text.Normalizer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RfcFactory {

	public static String generarSinHomoclave(String nombre, String apellidoPaterno, String apellidoMaterno,
			LocalDate fechaNac) {
		// Eliminar acentos y convertir a mayúsculas
		nombre = eliminarAcentosYSimbolos(nombre);
		apellidoPaterno = eliminarAcentosYSimbolos(apellidoPaterno);
		apellidoMaterno = eliminarAcentosYSimbolos(apellidoMaterno);

		// Nombre: Omitir palabras que no se utilizan, MARIA, JOSE y compuestos, y
		// obtener las 2 primeras letras
		Pattern pattern = Pattern.compile(
				"\\A(?:(?:MARIA|JOSE) )?+(?:(?:DEL?|L(?:AS?|OS)|M(?:AC|[CI])|V[AO]N|Y)\\b ?)*+([A-Z&]?)([A-Z&]?)");
		final Matcher matcherNom = pattern.matcher(nombre);
		matcherNom.find();

		// Apellido: Omitir palabras que no se utilizan, y obtener la primera letra y la
		// vocal interna (si el apellido tiene más de 2 letras)
		pattern = Pattern.compile(
				"\\A(?:(?:DEL?|L(?:AS?|OS)|M(?:AC|[CI])|V[AO]N|Y)\\b ?)*+(([A-Z&]?)[B-DF-HJ-NP-TV-Z&]*([AEIOU]?)[A-Z&]?)");
		final Matcher matcherPat = pattern.matcher(apellidoPaterno);
		matcherPat.find();

		final Matcher matcherMat = pattern.matcher(apellidoMaterno);
		matcherMat.find();

		// LETRAS
		// Obtener vocal de apellido paterno y letra(s) del nombre
		String letraPat = matcherPat.group(2);
		String letraMat = matcherMat.group(2);
		String letraNom = matcherNom.group(1);
		String rfc;
		if (letraPat.isEmpty() || letraMat.isEmpty()) {
			// Si no tiene alguno de los apellidos (paterno o materno), se toma la primera y
			// segunda letra del apellido que tiene
			// y el 4to caracter será la segunda letra del nombre.
			rfc = (matcherPat.group(1) + matcherMat.group(1)).substring(0, 2) + letraNom + matcherNom.group(2);
		} else if (matcherPat.group(1).length() > 2) {
			String vocal = matcherPat.group(3);
			// Cuando el apellido paterno no tiene vocales, se utiliza una X.
			if (vocal.isEmpty())
				vocal = "X";
			rfc = letraPat + vocal + letraMat + letraNom;
		} else {
			// Si el apellido paterno tiene 1 o 2 letras, no se toma la primera vocal, y el
			// 4to caracter es la segunda letra del nombre.
			rfc = letraPat + letraMat + letraNom + matcherNom.group(2);
		}

		// Cuando las 4 letras resulten en una palabra inconveniente (regla 9), se
		// modifica la última letra a una X
		if (rfc.matches(
				"BUE[IY]|C(?:A[CGK][AO]|O(?:GE|J[AEIO])|ULO)|FETO|GUEY|JOTO|K(?:A(?:[CG][AO]|KA)|O(?:GE|JO)|ULO)|M(?:AM[EO]|E(?:A[RS]|ON)|ION|OCO|ULA)|P(?:E(?:D[AO]|NE)|UT[AO])|QULO|R(?:ATA|UIN)"))
			rfc = rfc.substring(0, 3) + "X";
		// AGREGAMOS ANIO, MES Y DIA
		rfc = rfc.concat(fechaNac.format(DateTimeFormatter.ofPattern("yyMMdd")));
		return rfc;
	}

	public static String eliminarAcentosYSimbolos(String s) {
		s = Normalizer.normalize(s.replaceAll("[Ññ]", "&"), Normalizer.Form.NFD);
		s = s.replaceAll("[^&A-Za-z ]", "");
		return s.trim().toUpperCase();
	}
}
