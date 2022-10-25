package mx.ryo.xoloit.amoxatli.beans.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the tc_moneda database table.
 * 
 */
@Entity
@Table(name="tc_moneda")
@NamedQuery(name="Moneda.findAll", query="SELECT m FROM Moneda m")
public class Moneda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="alpha3_code")
	private String alpha3Code;

	private String description;



	public Moneda() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAlpha3Code() {
		return this.alpha3Code;
	}

	public void setAlpha3Code(String alpha3Code) {
		this.alpha3Code = alpha3Code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}