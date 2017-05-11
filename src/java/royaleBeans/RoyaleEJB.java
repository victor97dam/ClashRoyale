/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Pokemon;
import entities.Trainer;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

/**
 *
 * @author DAM
 */
@Stateless
public class StukemonEJB {

    @PersistenceUnit
    EntityManagerFactory emf;

    public boolean insertarEntrenador(Trainer t) {
        if (!TrainerExists(t)) {
            EntityManager em = emf.createEntityManager();
            em.persist(t);
            em.close();
            return true;
        }
        return false;
    }

    public Trainer getTrainerByName(String name) {
        return emf.createEntityManager().find(Trainer.class, name);
    }

    public Pokemon getPokemonByName(String name) {
        return emf.createEntityManager().find(Pokemon.class, name);
    }

    public boolean TrainerExists(Trainer T) {
        EntityManager em = emf.createEntityManager();
        Trainer search = em.find(Trainer.class, T.getName());
        em.close();
        return search != null;
    }

    public boolean PokemonExists(Pokemon P) {
        EntityManager em = emf.createEntityManager();
        Trainer search = em.find(Trainer.class, P.getName());
        em.close();
        return search != null;
    }

    public boolean insertarPokemon(Pokemon P) {
        if (!PokemonExists(P)) {
            EntityManager em = emf.createEntityManager();
            em.persist(P);
            em.close();
            return true;
        }
        return false;
    }

    public List<Trainer> SelectAllTrainers() {
        EntityManager em = emf.createEntityManager();
        List<Trainer> entrenadores = emf.createEntityManager().createNamedQuery("Trainer.findAll").getResultList();
        List<Trainer> filterTrainers = new ArrayList<>();
        for (Trainer t : entrenadores) {
            if (t.getPokemonCollection().size() < 6) {
                filterTrainers.add(t);
            }
        }
        em.close();
        return filterTrainers;
    }

    public List<Pokemon> SelectAllPokemon() {

        EntityManager em = emf.createEntityManager();
        List<Pokemon> pokemon = emf.createEntityManager().createNamedQuery("Pokemon.findAll").getResultList();
        em.close();
        return pokemon;
    }

    public boolean BorrarPokemon(Pokemon p) {
        EntityManager em = emf.createEntityManager();
        Pokemon pokemon = em.find(Pokemon.class, p.getName());
        boolean ok = false;
        if (pokemon != null) {
            em.remove(pokemon);
            ok = true;
        }
        em.close();
        return ok;
    }

    public Object FindTrainerByName(String name) {

        return emf.createEntityManager().createNamedQuery("Trainer.findByName").setParameter("name", name).getSingleResult();

    }

    public Pokemon SelectPokemonByName(String name) {

        return (Pokemon) emf.createEntityManager().createNamedQuery("Pokemon.findByName").setParameter("name", name).getSingleResult();
    }

    public List<Pokemon> SelectPokemonByTrainer(Trainer name) {
        EntityManager em = emf.createEntityManager();
        List<Pokemon> allPokemons = em.createNamedQuery("Pokemon.findAll").getResultList();
        List<Pokemon> pokemonsOk = new ArrayList<>();
        for (Pokemon pokemon : allPokemons) {
            if (pokemon.getTrainer().equals(name)) {
                pokemonsOk.add(pokemon);
            }
        }
        return pokemonsOk;
    }

    public void updatePokemon(Pokemon p) {
        EntityManager em = emf.createEntityManager();
        em.merge(p);
    }

    public void updateTrainer(Trainer t) {
        EntityManager em = emf.createEntityManager();
        em.merge(t);
    }

    public boolean CompraPociones(Trainer t, int pociones) {

        try {
            EntityManager em = emf.createEntityManager();
            Trainer trainer = em.find(Trainer.class, t.getName());
            trainer.setPoints(trainer.getPoints() - (pociones * 10));
            trainer.setPotions(trainer.getPoints() + pociones);
            em.persist(trainer);
            em.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Trainer> TrainerPotion() {
        EntityManager em = emf.createEntityManager();
        List<Trainer> entrenadores = emf.createEntityManager().createNamedQuery("Trainer.findAll").getResultList();
        List<Trainer> entrenadoresconpociones = new ArrayList<>();
        for (Trainer t : entrenadores) {
            if (t.getPotions() > 0 && t.getPokemonCollection().size() > 0) {
                entrenadoresconpociones.add(t);
            }
        }
        return entrenadoresconpociones;
    }

    public boolean RestarPocion(Trainer t) {
        if (TrainerExists(t)) {
            EntityManager em = emf.createEntityManager();
            Trainer trainer = em.find(Trainer.class, t.getName());
            trainer.setPoints(trainer.getPotions() - 1);
            em.persist(trainer);
            em.close();
            return true;
        } else {
            return false;
        }
    }

    public void EfectoPocion(Pokemon pokemon) {

        EntityManager em = emf.createEntityManager();
        Pokemon p = em.find(Pokemon.class, pokemon.getName());

        p.setLife(pokemon.getLife() + 50);
        Trainer trainer = em.find(Trainer.class, p.getTrainer().getName());
        trainer.setPotions(trainer.getPoints() - 1);
        em.persist(trainer);

        em.close();

    }

    public List<Pokemon> getPokemonList() {
        EntityManager em = emf.createEntityManager();
        Query pokemon = em.createQuery("SELECT p From  Pokemon p ORDER BY p.level DESC, p.life DESC");
        return pokemon.getResultList();
    }

    public List<Trainer> getEntrenadorList() {
        EntityManager em = emf.createEntityManager();
        Query entrenadores = em.createQuery("SELECT t FROM Trainer t ORDER BY t.points DESC");
        return entrenadores.getResultList();
    }
}
