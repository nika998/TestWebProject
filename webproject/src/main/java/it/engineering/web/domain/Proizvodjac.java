package it.engineering.web.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the proizvodjac database table.
 * 
 */
@Entity
@NamedQuery(name="Proizvodjac.findAll", query="SELECT p FROM Proizvodjac p")
public class Proizvodjac implements Serializable {
	private static final long serialVersionUID = 1L;

	private String adresa;

	private int maticniBroj;

	private int mesto;
	@Id
	private int pib;

	public Proizvodjac() {
	}

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public int getMaticniBroj() {
		return this.maticniBroj;
	}

	public void setMaticniBroj(int maticniBroj) {
		this.maticniBroj = maticniBroj;
	}

	public int getMesto() {
		return this.mesto;
	}

	public void setMesto(int mesto) {
		this.mesto = mesto;
	}

	public int getPib() {
		return this.pib;
	}

	public void setPib(int pib) {
		this.pib = pib;
	}

}