package com.ProjetVoyage.entites;

import java.util.Objects;

public class Chauffeur {
	private String cin;
	private String nomPrenom;
	private int age;
	
	public Chauffeur(String cin, String nomPrenom, int age) {
		super();
		this.cin = cin;
		this.nomPrenom = nomPrenom;
		this.age=age ;
	}

	@Override
	public String toString() {
		return "Chauffeur [cin=" + cin + ", nomPrenom=" + nomPrenom + ",age=" + age + "]";
	}

	public String getCin() {
		return cin;
	}
	
	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNomPrenom() {
		return nomPrenom;
	}

	public void setNomPrenom(String nomPrenom) {
		this.nomPrenom = nomPrenom;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cin);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chauffeur other = (Chauffeur) obj;
		return Objects.equals(cin, other.cin);
	}

}
