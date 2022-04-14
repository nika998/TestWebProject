package it.engineering.web.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mesto database table.
 * 
 */
@Entity
@NamedQuery(name="Mesto.findAll", query="SELECT m FROM Mesto m")
public class Mesto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String naziv;
    
	@Id
	private int pttBroj;

	public Mesto() {
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getPttBroj() {
		return this.pttBroj;
	}

	public void setPttBroj(int pttBroj) {
		this.pttBroj = pttBroj;
	}

}