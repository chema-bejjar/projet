package com.ProjetVoyage;

import java.util.Collection;

import com.ProjetVoyage.dao.BusDao;
import com.ProjetVoyage.entites.Bus;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
//import jakarta.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("bus")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
   // @GET
   // @Produces(MediaType.TEXT_PLAIN)
   // public String getIt() {
  //      return "Got it!";
   // }
    
    BusDao bdao = new BusDao();
    
    @GET
    @Produces("application/json")
     public Collection<Bus> findAll() {
    System.out.println("findAll");
    return bdao.findAllBus();
   }
    
    @GET
    @Path("{immat}")
    @Produces("application/json")
    public Bus findById(@PathParam("immat") String immat){
    	 return bdao.findByImmat(immat) ;
    }
    
    
    @POST
    @Path("create")
    @Produces("application/json")
    public Collection<Bus> createBus(@QueryParam("immat") String immat,@QueryParam("marque") String marque ,@QueryParam("type") String type , @QueryParam("PrixAchat") int PrixAchat)
    {
    	bdao.ajouterBus(new Bus(immat,marque,type,PrixAchat)) ;
    	return bdao.findAllBus() ;
    }
    
    @PUT
    @Path("modifier/{immat}")
    @Produces("application/json")
    public Collection<Bus> mofifierBus(@PathParam("immat") String immat,@QueryParam("marque") String marque ,@QueryParam("type") String type , @QueryParam("PrixAchat") int PrixAchat)
    {
    	bdao.modifierBus(new Bus(immat, marque, type, PrixAchat)) ;
    	return bdao.findAllBus();
    }
    
    @DELETE
    @Path("delete/{immat}")
    @Produces("application/json")
    public Collection<Bus> deleteBus(@PathParam("immat") String immat)
    {
    	bdao.supprimerBus(immat);
    	return bdao.findAllBus();
    }
    
    
    
    
    
    
}
