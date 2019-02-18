/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PizzaDao;

import PizzaEntity.Pizza;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mehtab
 */
@Stateless
public class PizzaDao {
    
    @PersistenceContext (name="PizzaRestPU")
    EntityManager em;
    
    public void addPizza(Pizza p){
        em.persist(p);
    }
    
    public void deletePizza (Integer id){
        em.remove(em.find(Pizza.class, id));
    }
    
    public List<Pizza> listAllPizza(){
        return em.createQuery("Select p From Pizza p").getResultList();
    }
    
    public Pizza findById(Integer id){
       return em.find(Pizza.class, id);
    }
   
    
    
}

