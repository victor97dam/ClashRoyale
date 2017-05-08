/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sergio
 */
@Entity
@Table(name = "carta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carta.findAll", query = "SELECT c FROM Carta c")
    , @NamedQuery(name = "Carta.findByNombre", query = "SELECT c FROM Carta c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Carta.findByVida", query = "SELECT c FROM Carta c WHERE c.vida = :vida")
    , @NamedQuery(name = "Carta.findByAtaque", query = "SELECT c FROM Carta c WHERE c.ataque = :ataque")
    , @NamedQuery(name = "Carta.findByVelocidad", query = "SELECT c FROM Carta c WHERE c.velocidad = :velocidad")
    , @NamedQuery(name = "Carta.findByElixir", query = "SELECT c FROM Carta c WHERE c.elixir = :elixir")
    , @NamedQuery(name = "Carta.findByCategoria", query = "SELECT c FROM Carta c WHERE c.categoria = :categoria")})
public class Carta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vida")
    private int vida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ataque")
    private int ataque;
    @Basic(optional = false)
    @NotNull
    @Column(name = "velocidad")
    private int velocidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "elixir")
    private int elixir;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "categoria")
    private String categoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carta1")
    private Collection<Baraja> barajaCollection;

    public Carta() {
    }

    public Carta(String nombre) {
        this.nombre = nombre;
    }

    public Carta(String nombre, int vida, int ataque, int velocidad, int elixir, String categoria) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.velocidad = velocidad;
        this.elixir = elixir;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getElixir() {
        return elixir;
    }

    public void setElixir(int elixir) {
        this.elixir = elixir;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @XmlTransient
    public Collection<Baraja> getBarajaCollection() {
        return barajaCollection;
    }

    public void setBarajaCollection(Collection<Baraja> barajaCollection) {
        this.barajaCollection = barajaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombre != null ? nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carta)) {
            return false;
        }
        Carta other = (Carta) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Carta[ nombre=" + nombre + " ]";
    }
    
}
