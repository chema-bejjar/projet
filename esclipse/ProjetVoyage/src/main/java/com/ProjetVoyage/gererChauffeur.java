package com.ProjetVoyage;

import java.util.Collection;

import com.ProjetVoyage.dao.ChauffeurDao;
import com.ProjetVoyage.entites.Chauffeur;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;

@Path("chauffeur")
public class gererChauffeur {
  ChauffeurDao cdao = new ChauffeurDao();
  
  @GET
  @Produces("application/json")
   public Collection<Chauffeur> findAll() {
  System.out.println("findAll");
  return cdao.findAllChauffeur();
 }
  
  @GET
  @Path("{cin}")
  @Produces("application/json")
  public Chauffeur findById(@PathParam("cin") String cin){
  	 return cdao.findById(cin) ;
  }
	
  @POST
  @Path("create")
  @Produces("application/json")
  public Collection<Chauffeur> createChauffeur(@QueryParam("cin") String cin,@QueryParam("nomPrenom") String nomPrenom, @QueryParam("age") int age){
  	
  cdao.save(new Chauffeur(cin, nomPrenom, age));
  	return cdao.findAllChauffeur();
  }
  
  @PUT
  @Path("modifier/{cin}")
  @Produces("application/json")
  public Collection<Chauffeur> modifierChauffeur(@PathParam("cin") String immat,@QueryParam("nomPrenom") String nomPrenom ,@QueryParam("age") int age)
  {
  	cdao.updateChauffeur(new Chauffeur(immat,nomPrenom,age)) ;
  	return cdao.findAllChauffeur();
  }
  
  @DELETE
  @Path("delete/{cin}")
  @Produces("application/json")
  public Collection<Chauffeur> deleteChauffeur(@PathParam("cin") String cin)
  {
  	cdao.delete(cin);
  	return cdao.findAllChauffeur();
  }
  
}
