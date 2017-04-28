/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package royaleBeans;

import entities.Carta;
import entities.Jugador;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author DAM
 */
@Stateless
public class RoyaleEJB {

     @PersistenceUnit
    EntityManagerFactory emf;
     public boolean insertarJugador(Jugador c) {
            EntityManager em = emf.createEntityManager();
            em.persist(c);
//        em.flush();
            em.close();
            return true;
    }
     
     public boolean existeJugador(Jugador c) {
        EntityManager em = emf.createEntityManager();
        Jugador encontrada = em.find(Jugador.class, c.getNombre());
        em.close();
        return encontrada != null;
    }
     
       public Jugador getPlayerByName(String name) {
        return emf.createEntityManager().find(Jugador.class, name);
    }
       
        public Carta getCartaByName(String name) {
        return emf.createEntityManager().find(Carta.class, name);
    }
       
     
}
