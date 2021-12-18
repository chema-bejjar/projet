package com.ProjetVoyage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import com.ProjetVoyage.entites.Bus;



public class BusDao {
	Connection cnx = SConnection.getInstance();
	
	public Collection<Bus>findAllBus()
	{
		ArrayList<Bus>lesbus=new ArrayList<>();
		PreparedStatement stm ;
		try
		{
			String q1="select * from bus";
			stm=cnx.prepareStatement(q1);
			ResultSet rs=stm.executeQuery();
			Bus b=null;
			while(rs.next())
			{ 
				b = new Bus(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				lesbus.add(b);
			}
		}catch (SQLException e1) 
		{
			System.out.println(e1.getMessage());
		}
		
		return lesbus;
	}
	
	public Bus findByImmat(String immat)  
	{
		cnx = SConnection.getInstance();
		Bus pp = null;
		if (immat != null) 
		{
			try 
			{
				String q = "select * from BUS where trim(immatriculation)=?";
				PreparedStatement stm = cnx.prepareStatement(q);
				stm.setString(1, immat);
				ResultSet rs = stm.executeQuery();
				while (rs.next()) {
				pp = new Bus(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			} 
			
		}
		return pp;
	}
	
	
	public void ajouterBus(Bus b)
	{
		if (b == null)
			return;
		
		int r = 0;
		try 
		{
			String q1 = "insert into bus(immatriculation,marque,type,PrixAchat) values(?,?,?,?)";
			 PreparedStatement stm = cnx.prepareStatement(q1);
			stm.setString(1, b.getImmatriculation());
			stm.setString(2, b.getMarque());
			stm.setString(3, b.getType());
			stm.setInt(4, b.getPrixAchat());
			r = stm.executeUpdate();
			if (r != 0)
				System.out.println("Bus insérer avec succès");
		} 
		catch (SQLException e1) 
		{
			System.out.println("Ce Bus existe déjà");
			e1.getMessage();
		}
		}
	
	public void modifierBus(Bus b) 
	{
		if (b == null)
			return;
		int r = 0;
		try 
		{
			String q = "update bus set marque=?,type=?,PrixAchat=? where immatriculation=? ";
			PreparedStatement stm = cnx.prepareStatement(q);
			stm.setString(1,b.getMarque());
			stm.setString(2,b.getType());
			stm.setInt(3, b.getPrixAchat());
			stm.setString(4,b.getImmatriculation());
			r = stm.executeUpdate();
			if (r != 0)
				System.out.println("Mis à jour du bus effectuée avec succès");
		} 
		catch (SQLException e2) 
		{
			e2.printStackTrace();
		} 
		
	}
	
	public void supprimerBus(String immat) 
	{
		
		int r = 0;
		try 
		{
			String q = "DELETE FROM BUS WHERE  IMMATRICULATION=? ";
			PreparedStatement stm = cnx.prepareStatement(q);
			stm.setString(1, immat);
			r = stm.executeUpdate();
			if (r != 0)
				System.out.println("Bus supprimé avec succès");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
}
