package com.ProjetVoyage;

import java.sql.Date;
import java.util.Collection;

import com.ProjetVoyage.dao.BusDao;
import com.ProjetVoyage.dao.ChauffeurDao;
import com.ProjetVoyage.dao.VoyageDao;
import com.ProjetVoyage.entites.Bus;
import com.ProjetVoyage.entites.Chauffeur;
import com.ProjetVoyage.entites.Voyage;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;

@Path("voyage")
public class GererVoyage {
   
	VoyageDao vdao = new VoyageDao();
	 BusDao bdao = new BusDao();
	 ChauffeurDao cdao = new ChauffeurDao();
	
	@GET
    @Produces("application/json")
     public Collection<Voyage> findAll() {
    System.out.println("findAll");
    return vdao.findAllVoyage();
   }
	
	@GET
    @Path("{num}")
    @Produces("application/json")
    public Voyage findByNum(@PathParam("num") String num){
    	 return vdao.findByNum(num);
    }
	
	 @POST
	    @Path("create")
	    @Produces("application/json")
	    public Collection<Voyage> createVoyage(@QueryParam("num") String num,@QueryParam("idchauffeur") String idchauffeur ,@QueryParam("idbus") String idbus , @QueryParam("dateVoyage") Date dateVoyage,@QueryParam("heureDep") int heureDep,@QueryParam("heureAriv") int heureAriv){
	    	
		 Chauffeur f = cdao.findById(idchauffeur) ;
		 Bus b= bdao.findByImmat(idbus);
	    	vdao.save(new Voyage(num, f, b, dateVoyage, heureDep, heureAriv)) ;
	    	return vdao.findAllVoyage() ;
	    }
	 
	 @PUT
	    @Path("modifier/{num}")
	    @Produces("application/json")
	    public Collection<Voyage> modifierVoyage(@PathParam("num") String num,@QueryParam("idchauffeur") String idchauffeur ,@QueryParam("idbus") String idbus , @QueryParam("dateVoyage") Date dateVoyage,@QueryParam("heureDep") int heureDep,@QueryParam("heureAriv") int heureAriv)
	    {
		 Chauffeur f = cdao.findById(idchauffeur) ;
		 Bus b= bdao.findByImmat(idbus);
	    	vdao.updateVoyage(new Voyage(num, f, b, dateVoyage, heureDep, heureAriv)) ;
	    	return vdao.findAllVoyage() ;
	    }
	 
	 @DELETE
	    @Path("delete/{num}")
	    @Produces("application/json")
	    public Collection<Voyage> deleteVoyage(@PathParam("num") String num)
	    {
	    	vdao.deleteVoyage(num) ;
	    	return vdao.findAllVoyage();
	    }
}
