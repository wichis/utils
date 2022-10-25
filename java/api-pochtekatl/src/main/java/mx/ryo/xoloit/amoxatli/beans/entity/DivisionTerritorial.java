package mx.ryo.xoloit.amoxatli.beans.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import mx.ryo.xoloit.amoxatli.beans.entity.embedable.DivisionTerritorialIdentity;


/**
 * The persistent class for the tc_division_territorial database table.
 * 
 */
@Entity
@Table(name="tc_division_territorial")
@NamedQuery(name="DivisionTerritorial.findAll", query="SELECT d FROM DivisionTerritorial d")
public class DivisionTerritorial implements Serializable {
	private static final long serialVersionUID = 1L;

    @EmbeddedId
    private DivisionTerritorialIdentity divisionTerritorialIdentity;

	private String description;

	private Boolean iscapital;

	//bi-directional many-to-one association to TipoDivision
	@ManyToOne
	@JoinColumn(name="id_tipo_division")
	private TipoDivision tcTipoDivision;

	public DivisionTerritorial() {
	}

	public DivisionTerritorialIdentity getDivisionTerritorialIdentity() {
		return divisionTerritorialIdentity;
	}

	public void setDivisionTerritorialIdentity(DivisionTerritorialIdentity divisionTerritorialIdentity) {
		this.divisionTerritorialIdentity = divisionTerritorialIdentity;
	}



	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIscapital() {
		return this.iscapital;
	}

	public void setIscapital(Boolean iscapital) {
		this.iscapital = iscapital;
	}

	public TipoDivision getTcTipoDivision() {
		return this.tcTipoDivision;
	}

	public void setTcTipoDivision(TipoDivision tcTipoDivision) {
		this.tcTipoDivision = tcTipoDivision;
	}

}