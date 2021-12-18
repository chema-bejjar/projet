package com.ProjetVoyage.entites;

import java.util.Objects;

public class Bus {

	private String immatriculation;
	private String marque;
	private String type;
	private int prixAchat;
	
	public Bus(String immatriculation, String marque, String type, int prixAchat) 
	{
		super();
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.type = type;
		this.prixAchat = prixAchat;
	}
	

	@Override
	public String toString() {
		return "Bus [immatriculation=" + immatriculation + ", marque=" + marque + ", type=" + type + ", dateAchat="
				+ prixAchat + ", etat=" +  "]";
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(int prixAchat) {
		this.prixAchat = prixAchat;
	}

	@Override
	public int hashCode() {
		return Objects.hash(immatriculation);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bus other = (Bus) obj;
		return Objects.equals(immatriculation, other.immatriculation);
	}
	
}
