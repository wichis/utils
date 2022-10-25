package mx.ryo.xoloit.amoxatli.beans.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the tc_tipo_division database table.
 * 
 */
@Entity
@Table(name="tc_tipo_division")
@NamedQuery(name="TipoDivision.findAll", query="SELECT t FROM TipoDivision t")
public class TipoDivision implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String description;

	//bi-directional many-to-one association to DivisionTerritorial
	@JsonIgnore
	@OneToMany(mappedBy="tcTipoDivision")
	private List<DivisionTerritorial> tcDivisionTerritorials;

	public TipoDivision() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<DivisionTerritorial> getTcDivisionTerritorials() {
		return this.tcDivisionTerritorials;
	}

	public void setTcDivisionTerritorials(List<DivisionTerritorial> tcDivisionTerritorials) {
		this.tcDivisionTerritorials = tcDivisionTerritorials;
	}

	public DivisionTerritorial addTcDivisionTerritorial(DivisionTerritorial tcDivisionTerritorial) {
		getTcDivisionTerritorials().add(tcDivisionTerritorial);
		tcDivisionTerritorial.setTcTipoDivision(this);

		return tcDivisionTerritorial;
	}

	public DivisionTerritorial removeTcDivisionTerritorial(DivisionTerritorial tcDivisionTerritorial) {
		getTcDivisionTerritorials().remove(tcDivisionTerritorial);
		tcDivisionTerritorial.setTcTipoDivision(null);

		return tcDivisionTerritorial;
	}

}