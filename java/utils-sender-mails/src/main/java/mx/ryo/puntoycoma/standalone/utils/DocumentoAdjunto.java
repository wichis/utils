package mx.ryo.puntoycoma.standalone.utils;

import java.io.Serializable;
import java.util.Date;

/**
 * The persistent class for the TW_ALUMNODOCUMENTOS database table.
 * 
 */

public class DocumentoAdjunto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String azureRelativeFileName;

	private String nombre;

	private Date fecha;

	private byte[] adjunto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public byte[] getAdjunto() {
		return adjunto;
	}

	public void setAdjunto(byte[] adjunto) {
		this.adjunto = adjunto;
	}

	public String getAzureRelativeFileName() {
		return azureRelativeFileName;
	}

	public void setAzureRelativeFileName(String azureRelativeFileName) {
		this.azureRelativeFileName = azureRelativeFileName;
	}

}