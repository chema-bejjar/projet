package com.ProjetVoyage.entites;

import java.sql.Date;
import java.util.Objects;


public class Voyage {
	 String numeroVoyage;
	 Chauffeur chauffeur;
	 Bus bus;
	 Date dateVoyage;
	 int heureDepart;
	 int heureArriver;
	 
	public Voyage(String numeroVoyage, Chauffeur chauffeur, Bus bus, Date dateVoyage, int heureDepart, int heureArriver) {
		super();
		this.numeroVoyage = numeroVoyage;
		this.chauffeur = chauffeur;
		this.bus = bus;
		this.dateVoyage = dateVoyage;
		this.heureDepart = heureDepart;
		this.heureArriver = heureArriver;
	}
	public Voyage() {
		super();
	}
	public String getNumeroVoyage() {
		return numeroVoyage;
	}
	public void setNumeroVoyage(String numeroVoyage) {
		this.numeroVoyage = numeroVoyage;
	}
	public Chauffeur getChauffeur() {
		return chauffeur;
	}
	public void setChauffeur(Chauffeur chauffeur) {
		this.chauffeur = chauffeur;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	public Date getDateVoyage() {
		return dateVoyage;
	}
	public void setDateVoyage(Date dateVoyage) {
		this.dateVoyage = dateVoyage;
	}
	public int getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(int heureDepart) {
		this.heureDepart = heureDepart;
	}
	public int getHeureArriver() {
		return heureArriver;
	}
	public void setHeureArriver(int heureArriver) {
		this.heureArriver = heureArriver;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(numeroVoyage);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voyage other = (Voyage) obj;
		return Objects.equals(numeroVoyage, other.numeroVoyage);
	}
	@Override
	public String toString() {
		return "Voyage [numeroVoyage=" + numeroVoyage + ", chauffeur=" + chauffeur + ", bus=" + bus + ", dateVoyage="
				+ dateVoyage + ", heureDepart=" + heureDepart + ", heureArriver=" + heureArriver + "]";
	}
	 
	 
	
	
	


}
