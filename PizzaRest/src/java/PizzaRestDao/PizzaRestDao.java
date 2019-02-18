/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PizzaRestDao;

import PizzaDao.PizzaDao;
import PizzaEntity.Pizza;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author mehtab
 */
@Stateless
@Path("entity.pizza")
public class PizzaRestDao {
    
    @Inject
    PizzaDao pDao;
    
    @POST
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public void createPizza(Pizza p){
        pDao.addPizza(p);
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public List<Pizza> getAllPizza(){
       return pDao.listAllPizza();
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Pizza findById(@PathParam("id")Integer id){
        return pDao.findById(id);
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id")Integer id){
        pDao.deletePizza(id);
    }
    
}
