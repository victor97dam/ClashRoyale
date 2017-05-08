/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package royaleBeans;

import entities.Baraja;
import entities.Carta;
import entities.Jugador;
import java.util.List;
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
    EntityManagerFactory EntityManager;

    public boolean insertarJugador(Jugador c) {
        if (!existeJugador(c)) {
            EntityManager em = EntityManager.createEntityManager();
            em.persist(c);
            em.close();
            return true;
        } else {
            return false;
        }
    }

    public boolean login(String nombre_usu, String pwd) {
        Jugador usu = EntityManager.createEntityManager().find(Jugador.class, nombre_usu);
        if (usu == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean existeJugador(Jugador c) {
        EntityManager em = EntityManager.createEntityManager();
        Jugador encontrada = em.find(Jugador.class, c.getNombre());
        em.close();
        return encontrada != null;
    }

    public Jugador getPlayerByName(String name) {
        return EntityManager.createEntityManager().find(Jugador.class, name);
    }

    public Carta getCartaByName(String name) {
        return EntityManager.createEntityManager().find(Carta.class, name);
        }
    public List<Jugador> InfoJugador (String name){
        List<Jugador> Info = EntityManager.createEntityManager().createNamedQuery("Jugador.findByNombre").setParameter("nombre", name).getResultList();
        return Info;
    }

    public List<Carta> getAllCartas() {
        List<Carta> TodaslasCartas = EntityManager.createEntityManager().createNamedQuery("Carta.findAll").getResultList();
        return TodaslasCartas;
    }
    

    public List<Baraja> Cartas(Jugador Player) {
        return null;
    }
    

 
    public List<Baraja> Cartas(String Player) {
        List<Baraja> BarajasdelJugador = EntityManager.createEntityManager().createNamedQuery("Baraja.findByJugador").setParameter("jugador", Player).getResultList();
        return BarajasdelJugador;
    }

}
