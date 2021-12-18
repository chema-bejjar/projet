package com.ProjetVoyage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.ProjetVoyage.entites.Chauffeur;


public class ChauffeurDao {
	Connection cnx = SConnection.getInstance();
	
	public Collection<Chauffeur>findAllChauffeur()
	{
		ArrayList<Chauffeur>leschauffeur=new ArrayList<>();
	  
		try
		{
			String q1="select * from chauffeur";
			PreparedStatement stm=cnx.prepareStatement(q1);
			ResultSet rs=stm.executeQuery();
			while(rs.next())
			{ 
				Chauffeur b = new Chauffeur(rs.getString(1), rs.getString(2), rs.getInt(3));
				leschauffeur.add(b);
			}
		}catch (SQLException e1) 
		{
			System.out.println(e1.getMessage());
		}
		
		return leschauffeur;
	}
	
	public Chauffeur findById(String cin)  {
		Chauffeur c = null;
		try {
			String q = "select * from chauffeur where cin=?";
			PreparedStatement stm = cnx.prepareStatement(q);
			stm.setString(1, cin);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				c = new Chauffeur(rs.getString(1), rs.getString(2),rs.getInt(3));
			}
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());}
		
		return c;
	}
	
	public void save(Chauffeur c) {
		if (c == null)
			return;
		int r = 0;
		try {
			PreparedStatement stm;

			String q1 = "insert into chauffeur(cin,nomPrenom,age) values(?,?,?)";
			stm = cnx.prepareStatement(q1);
			stm.setString(1, c.getCin());
			stm.setString(2, c.getNomPrenom());
			stm.setInt(3,c.getAge());
			r = stm.executeUpdate();
			if (r != 0)
				System.out.println("Chauffeur insérer avec succès");
		} catch (SQLException e1) {
			System.out.println("Ce Chauffeur existe déjà");
			e1.getMessage();
		} 

	}
	
	public void updateChauffeur(Chauffeur c) {
		int r = 0;
		try {
			String q1 = " UPDATE chauffeur SET nomPrenom=?,age=? WHERE cin=?";

			PreparedStatement stm1 = cnx.prepareStatement(q1);
			stm1.setString(1, c.getNomPrenom());
			stm1.setInt(2,c.getAge());
			stm1.setString(3, c.getCin());
			r = stm1.executeUpdate();
			if (r != 0)
				System.out.println("Chauffeur mofifié avec succès");
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		} 

	}
	
	
	public void delete(String cin) {
		int r = 0;
		try {
			String q = "DELETE FROM chauffeur WHERE cin=? ";
			PreparedStatement stm = cnx.prepareStatement(q);
			stm.setString(1, cin);
			r = stm.executeUpdate();
			if (r != 0) {
				System.out.println("Chauffeur supprimé avec succès");
			}
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		} 
	}

}
