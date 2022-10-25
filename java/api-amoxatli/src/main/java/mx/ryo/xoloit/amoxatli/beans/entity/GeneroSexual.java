package mx.ryo.xoloit.amoxatli.beans.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the tc_genero_sexual database table.
 * 
 */
@Entity
@Table(name="tc_genero_sexual")
@NamedQuery(name="GeneroSexual.findAll", query="SELECT g FROM GeneroSexual g")
public class GeneroSexual implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="alpha1_gender")
	private String alpha1Gender;

	@Column(name="alpha1_sex")
	private String alpha1Sex;

	private String gender;

	private String sex;

	public GeneroSexual() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAlpha1Gender() {
		return this.alpha1Gender;
	}

	public void setAlpha1Gender(String alpha1Gender) {
		this.alpha1Gender = alpha1Gender;
	}

	public String getAlpha1Sex() {
		return this.alpha1Sex;
	}

	public void setAlpha1Sex(String alpha1Sex) {
		this.alpha1Sex = alpha1Sex;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}