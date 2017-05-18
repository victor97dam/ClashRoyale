/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package royaleBeans;

import entities.Baraja;
import entities.BarajaPK;
import static entities.BarajaPK_.carta;
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
            c.setOro(250);
            EntityManager em = EntityManager.createEntityManager();
            em.persist(c);
            em.close();
            return true;
        } else {
            return false;
        }
    }

    public boolean insertarCarta(Carta c) {
        if (!existeCarta(c)) {
            EntityManager em = EntityManager.createEntityManager();
            em.persist(c);
            em.close();
            return true;
        } else {
            return false;
        }
    }

    public boolean mejorarCarta(String Cartamejorar, String Nombre, List cartasplayer) {
        EntityManager.getCache().evictAll();
        boolean resultado = false;
        Carta c = new Carta();
        c = getCartaByName(Cartamejorar);
        Jugador jugador = new Jugador();
        List<Baraja> lista = cartasplayer;
        for (Baraja barajas : lista) {
            if (barajas.getCarta1().equals(c)) {
                BarajaPK bpk = new BarajaPK();
                bpk.setCarta(Cartamejorar);
                bpk.setJugador(Nombre);
                barajas.getBarajaPK();
                barajas.getCantidad();
                barajas.getCarta1();
                barajas.getCantidad();
                barajas.getNivel();
                barajas.setCantidad(1);
                int OroActual = barajas.getJugador1().getOro();
                OroActual = OroActual - 25;
                barajas.getJugador1().setOro(OroActual);
                EntityManager em = EntityManager.createEntityManager();
                barajas.setNivel(barajas.getNivel() + 1);
                em.merge(barajas);
                resultado = true;
            }
        }
        return resultado;
    }

    public boolean insertarCarta(Carta c, String Nombre, String TipoCofre) {
        EntityManager.getCache().evictAll();
        boolean existe = false;
        String CartaName = c.getNombre();
        Jugador jugador = new Jugador();
        int coste = 0;
        switch (TipoCofre) {
            case "Cofre1":
                coste = 25;
                break;
            case "Cofre2":
                coste = 50;
                break;
            case "Cofre3":
                coste = 100;
                break;
        }
        jugador = getPlayerByName(Nombre);
        int OroActual = jugador.getOro();
        List<Baraja> lista = Cartas(Nombre);
        for (Baraja barajas : lista) {
            if (barajas.getCarta1().equals(c)) {
                BarajaPK bpk = new BarajaPK();
                bpk.setCarta(CartaName);
                bpk.setJugador(Nombre);
                barajas.getBarajaPK();
                barajas.getCantidad();
                barajas.getCarta1();
                barajas.getCantidad();
                if (coste == 50) {
                    barajas.setNivel(barajas.getNivel() + 2);
                } else if (coste == 100) {
                    barajas.setNivel(barajas.getNivel() + 3);
                } else if (coste == 50) {
                    barajas.setNivel(barajas.getNivel() + 1);
                }
                barajas.getNivel();
                int cantidadActual = barajas.getCantidad();
                barajas.setCantidad(cantidadActual + 1);
                OroActual = barajas.getJugador1().getOro();
                OroActual = OroActual - coste;
                barajas.getJugador1().setOro(OroActual);
                EntityManager em = EntityManager.createEntityManager();
                em.merge(barajas);
                existe = true;
                return true;
            }
        }
        if (existe == false) {

            BarajaPK bpk = new BarajaPK();
            bpk.setCarta(CartaName);
            bpk.setJugador(Nombre);
            Baraja BarajaJugador = new Baraja();
            BarajaJugador.setBarajaPK(bpk);
            BarajaJugador.setJugador1(jugador);
            BarajaJugador.setJugador1(jugador);
            BarajaJugador.setCarta1(c);
            OroActual = OroActual - coste;
            BarajaJugador.getJugador1().setOro(OroActual);
            BarajaJugador.setCantidad(1);
            if (coste == 50) {
                BarajaJugador.setNivel(BarajaJugador.getNivel() + 2);
            } else if (coste == 100) {
                BarajaJugador.setNivel(BarajaJugador.getNivel() + 3);
            } else if (coste == 25) {
                BarajaJugador.setNivel(1);

            }
            EntityManager em = EntityManager.createEntityManager();
            em.persist(BarajaJugador);
            return true;
        }
        return false;
    }

    //Cmprb if exist
    public boolean login(String nombre_usu, String pwd) {
        Jugador usu = EntityManager.createEntityManager().find(Jugador.class, nombre_usu);
        if (usu != null) {
            if (usu.getPassword().equals(pwd)) {
                return true;
            }
        }
        return false;

    }

    public boolean existeJugador(Jugador c) {
        EntityManager em = EntityManager.createEntityManager();
        Jugador encontrada = em.find(Jugador.class, c.getNombre());
        em.close();
        return encontrada != null;
    }

    public boolean existeCarta(Carta c) {
        EntityManager em = EntityManager.createEntityManager();
        Carta encontrada = em.find(Carta.class, c.getNombre());
        em.close();
        return encontrada != null;
    }

    public Jugador getPlayerByName(String name) {
        return EntityManager.createEntityManager().find(Jugador.class, name);
    }

    public Carta getCartaByName(String name) {
        return EntityManager.createEntityManager().find(Carta.class, name);
    }

    public List<Jugador> InfoJugador(String name) {
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

    public Carta rndmCard() {
        List<Carta> All = getAllCartas();
        Carta cartaselect = new Carta();
        int size = All.size();
        size = size + 1;
        int rndm = (int) (Math.random() * size);
        cartaselect = (Carta) All.get(rndm);
        return cartaselect;
    }

    public Carta findBarajaByCarta(Carta cartau) {
        Carta carta = (Carta) EntityManager.createEntityManager().createNamedQuery("").setParameter("carta", cartau).getSingleResult();
        return carta;
    }

    public List<Baraja> Cartas(String Player) {
        List<Baraja> BarajasdelJugador = EntityManager.createEntityManager().createNamedQuery("Baraja.findByJugador").setParameter("jugador", Player).getResultList();
        return BarajasdelJugador;
    }

}
