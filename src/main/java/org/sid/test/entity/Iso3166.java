package org.sid.test.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Iso3166 implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private String pays;	
	private String a2;
	private String a3;
	private int number;
	private String url;
	
	@ManyToOne
	private User user;
	
	public Iso3166() {
		super();
	}

	public Iso3166(String pays, String a2, String a3, int number) {
		super();
		this.pays = pays;
		this.a2 = a2;
		this.a3 = a3;
		this.number = number;
	}	

	public Iso3166(String pays, String a2, String a3, int number, String url) {
		super();
		this.pays = pays;
		this.a2 = a2;
		this.a3 = a3;
		this.number = number;
		this.url = url;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getA2() {
		return a2;
	}

	public void setA2(String a2) {
		this.a2 = a2;
	}

	public String getA3() {
		return a3;
	}

	public void setA3(String a3) {
		this.a3 = a3;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Iso3166 [pays=" + pays + ", a2=" + a2 + ", a3=" + a3 + ", number=" + number + "]";
	}
	
	

}
