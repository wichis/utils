package mx.ryo.xoloit.amoxatli.beans.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the tc_lenguaje database table.
 * 
 */
@Entity
@Table(name="tc_lenguaje")
@NamedQuery(name="Lenguaje.findAll", query="SELECT l FROM Lenguaje l")
public class Lenguaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="alpha2_code")
	private String alpha2Code;

	@Column(name="alpha3_code")
	private String alpha3Code;

	private String description;


	public Lenguaje() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAlpha2Code() {
		return this.alpha2Code;
	}

	public void setAlpha2Code(String alpha2Code) {
		this.alpha2Code = alpha2Code;
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