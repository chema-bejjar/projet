package com.ProjetVoyage.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import com.ProjetVoyage.entites.Bus;
import com.ProjetVoyage.entites.Chauffeur;
import com.ProjetVoyage.entites.Voyage;



public class VoyageDao {
	Connection cnx = SConnection.getInstance();

	public Collection<Voyage> findAllVoyage()  {
		Collection<Voyage> lesVoyage = new ArrayList<Voyage>();

		try {
			String q1 = "select * from voyage";
			PreparedStatement stm = cnx.prepareStatement(q1);
			ResultSet rs = stm.executeQuery();
			Voyage v = null;
			while (rs.next()) {
				Chauffeur ch = new ChauffeurDao().findById(rs.getString(2));
				Bus b = new BusDao().findByImmat(rs.getString(3));
				Date dateVoyage = rs.getDate(4);
				v = new Voyage(rs.getString(1), ch, b,dateVoyage,rs.getInt(5),rs.getInt(6));
				lesVoyage.add(v);
			}
			stm.close();
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}
		return lesVoyage;
	}
	
	public Voyage findByNum(String num)  {
		Voyage v = null;
		Chauffeur ch = null;
		Bus b = null;
		try {
		String q = "select * from voyage where numeroVoyage=?";
		PreparedStatement stm = cnx.prepareStatement(q);
		stm.setString(1, num);
		ResultSet rs = stm.executeQuery();
		while (rs.next()) {
			ch = new ChauffeurDao().findById(rs.getString(2));
			b = new BusDao().findByImmat(rs.getString(3));
			Date dateVoyage = rs.getDate(4);
			v = new Voyage(rs.getString(1), ch, b,dateVoyage,rs.getInt(5),rs.getInt(6));
			
		}
		}catch(SQLException e1) {
			System.out.println(e1.getMessage());
		}
		return v;
	}

	public void save(Voyage v) {

		Voyage v1 = null;
		 v1 = findByNum(v.getNumeroVoyage());
		 try {
				
		if (v1 == null) {
			 
        String q1 = "insert into voyage(numeroVoyage,chauffeur,bus,dateVoyage,heureDepart,heureArriver) values(?,?,?,?,?,?)";
			PreparedStatement stm = cnx.prepareStatement(q1);
			stm.setString(1, v.getNumeroVoyage());
			stm.setString(2, v.getChauffeur().getCin());
			stm.setString(3, v.getBus().getImmatriculation());
			stm.setDate(4, v.getDateVoyage());
			stm.setInt(5, v.getHeureDepart());
			stm.setInt(6, v.getHeureArriver());
			stm.executeUpdate();
		} else {
			System.out.println("le voyage existe deja");
		}
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	
	public void updateVoyage(Voyage v) {

		try {
			String q1 = " UPDATE voyage SET chauffeur,bus,dateVoyage,heureDepart,heureArriver WHERE numeroVoyage=?";

			PreparedStatement stm1 = cnx.prepareStatement(q1);
			stm1.setString(1, v.getChauffeur().getCin());
			stm1.setString(2, v.getBus().getImmatriculation());
			stm1.setDate(3, v.getDateVoyage());
			stm1.setInt(4, v.getHeureDepart());
			stm1.setInt(5, v.getHeureArriver());
			stm1.setString(6, v.getNumeroVoyage());
			int r = stm1.executeUpdate();
			if (r != 0)
				System.out.println("voyage mofifié avec succès");
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}

	}

	public void deleteVoyage(String num) {
		int r = 0;
		try {
			String q = "DELETE FROM voyage WHERE numeroVoyage=? ";
			PreparedStatement stm = cnx.prepareStatement(q);
			stm.setString(1, num);
			r = stm.executeUpdate();
			if (r != 0) {
				System.out.println("voyage supprimé avec succès");
			}
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}

	}
	
}
