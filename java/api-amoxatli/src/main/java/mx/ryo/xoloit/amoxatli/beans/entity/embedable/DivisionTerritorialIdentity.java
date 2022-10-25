package mx.ryo.xoloit.amoxatli.beans.entity.embedable;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class DivisionTerritorialIdentity implements Serializable {
	@NotNull
	private Long idPais;

	@NotNull
	private Long idDivision;

	public DivisionTerritorialIdentity() {
		super();
		this.idPais = null;
		this.idDivision = null;
	}

	public DivisionTerritorialIdentity(Long idPais, Long idDivisionTerritorial) {
		super();
		this.idPais = idPais;
		this.idDivision = idDivisionTerritorial;
	}

	public Long getIdPais() {
		return idPais;
	}

	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}

	public Long getIdDivision() {
		return idDivision;
	}

	public void setIdDivision(Long idDivisionTerritorial) {
		this.idDivision = idDivisionTerritorial;
	}

}
