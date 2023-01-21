package mx.ryo.xoloitek.common.utils.factory;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import mx.ryo.xoloitek.common.utils.exceptions.CurpException;


public class CurpFactory {
	public final static Pattern SEXO_REGEX = Pattern.compile("^(H|M)$");
	public final static Pattern ENT_NAC_REGEX = Pattern.compile("^((AS)|(BC)|(BS)|CC|CL|CM|CS|CH|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)$");
	
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private LocalDate fechaNac;
	private String sexo;
	private String entidadNacimiento;
	
	public CurpFactory(String nombre, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNac) throws CurpException {
		super();
		if(StringUtils.isBlank(nombre)) throw new CurpException("El nombre es obligatorio");
		this.nombre = nombre;
		if(StringUtils.isBlank(apellidoPaterno)) throw new CurpException("El primer apellido es obligatorio");
		this.apellidoPaterno = apellidoPaterno;
		if(StringUtils.isBlank(apellidoMaterno)) throw new CurpException("El segundo apellido es obligatorio");
		this.apellidoMaterno = apellidoMaterno;
		if(fechaNac == null) throw new CurpException("La fecha de nacimiento es obligatorio");
		this.fechaNac = fechaNac;
	}
	
	public CurpFactory(String nombre, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNac, String sexo) throws CurpException {
		super();
		if(StringUtils.isBlank(nombre)) throw new CurpException("El nombre es obligatorio");
		this.nombre = nombre;
		if(StringUtils.isBlank(apellidoPaterno)) throw new CurpException("El primer apellido es obligatorio");
		this.apellidoPaterno = apellidoPaterno;
		if(StringUtils.isBlank(apellidoMaterno)) throw new CurpException("El segundo apellido es obligatorio");
		this.apellidoMaterno = apellidoMaterno;
		if(fechaNac == null) throw new CurpException("La fecha de nacimiento es obligatorio");
		this.fechaNac = fechaNac;
		if(StringUtils.isBlank(sexo)) throw new CurpException("El sexo de nacimiento es obligatorio");
		this.sexo = sexo;
	}
	
	public CurpFactory(String nombre, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNac, String sexo,
			String entidadNacimiento) throws CurpException {
		super();
		if(StringUtils.isBlank(nombre)) throw new CurpException("El nombre es obligatorio");
		this.nombre = nombre;
		if(StringUtils.isBlank(apellidoPaterno)) throw new CurpException("El primer apellido es obligatorio");
		this.apellidoPaterno = apellidoPaterno;
		if(StringUtils.isBlank(apellidoMaterno)) throw new CurpException("El segundo apellido es obligatorio");
		this.apellidoMaterno = apellidoMaterno;
		if(fechaNac == null) throw new CurpException("La fecha de nacimiento es obligatorio");
		this.fechaNac = fechaNac;
		if(StringUtils.isBlank(sexo)) throw new CurpException("El sexo de nacimiento es obligatorio");
		this.sexo = sexo;
		if(StringUtils.isBlank(entidadNacimiento)) throw new CurpException("La entidad de nacimiento es obligatorio");
		this.entidadNacimiento = entidadNacimiento;
	}

	/**
	 * Construye una parte del CURP. Solo hasta el dato del sexo.
	 * Resumen 11 digitos.
	 * @param nombre
	 * @param apellidoPaterno
	 * @param apellidoMaterno
	 * @param fechaNac
	 * @param sexo
	 * @return
	 * @throws CurpException 
	 */
	public String generarHastaSexo() throws CurpException {
		if(StringUtils.isBlank(this.sexo)) throw new CurpException("El sexo es obligatorio");

		final StringBuilder curpPart = new StringBuilder();
		//RFC segmento
		String rfcPart = RfcFactory.generarSinHomoclave(nombre, apellidoPaterno, apellidoMaterno, fechaNac);
		curpPart.append(rfcPart);
		// Sexo segmento
		Matcher mat = CurpFactory.SEXO_REGEX.matcher(sexo);
		if (!mat.matches())throw new IllegalArgumentException("El valor del sexo es invalido");
		curpPart.append(sexo);
		return curpPart.toString();
	}
	
	public String generarHastaEntNac() throws CurpException {
		if(StringUtils.isBlank(this.sexo)) throw new CurpException("El sexo es obligatorio");
		if(StringUtils.isBlank(this.entidadNacimiento)) throw new IllegalArgumentException("La entidad de nacimiento es obligatorio");
		final StringBuilder curpPart = new StringBuilder();
		curpPart.append(this.generarHastaSexo());
		// Entidad de nacimiento segmento
		Matcher mat = CurpFactory.ENT_NAC_REGEX.matcher(this.entidadNacimiento);
		if (!mat.matches()) throw new CurpException("El valor de la entidad de nacimiento no es invalido");
		curpPart.append(this.entidadNacimiento);
		return curpPart.toString();
	}

}
