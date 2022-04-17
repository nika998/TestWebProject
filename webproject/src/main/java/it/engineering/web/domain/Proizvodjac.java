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
	@Id
	private String maticniBroj;

	@ManyToOne (cascade = CascadeType.PERSIST)
	@JoinColumn(name = "mesto")
	private Mesto mesto;
	
	private String pib;

	public Proizvodjac() {
	}

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getMaticniBroj() {
		return this.maticniBroj;
	}

	public void setMaticniBroj(String maticniBroj) {
		this.maticniBroj = maticniBroj;
	}

	public Mesto getMesto() {
		return this.mesto;
	}

	public void setMesto(Mesto mesto) {
		this.mesto = mesto;
	}

	public String getPib() {
		return this.pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public Proizvodjac(String maticniBroj, String pib, String adresa, Mesto mesto) {
		super();
		this.adresa = adresa;
		this.maticniBroj = maticniBroj;
		this.mesto = mesto;
		this.pib = pib;
	}
	
	


}