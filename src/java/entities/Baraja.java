/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DAM
 */
@Entity
@Table(name = "Baraja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Baraja.findAll", query = "SELECT b FROM Baraja b"),
    @NamedQuery(name = "Baraja.findByJugador", query = "SELECT b FROM Baraja b WHERE b.barajaPK.jugador = :jugador"),
    @NamedQuery(name = "Baraja.findByCarta", query = "SELECT b FROM Baraja b WHERE b.barajaPK.carta = :carta"),
    @NamedQuery(name = "Baraja.findByNivel", query = "SELECT b FROM Baraja b WHERE b.nivel = :nivel"),
    @NamedQuery(name = "Baraja.findByCantidad", query = "SELECT b FROM Baraja b WHERE b.cantidad = :cantidad")})
public class Baraja implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BarajaPK barajaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nivel")
    private int nivel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "carta", referencedColumnName = "nombre", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Carta carta1;
    @JoinColumn(name = "jugador", referencedColumnName = "nombre", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Jugador jugador1;

    public Baraja() {
    }

    public Baraja(BarajaPK barajaPK) {
        this.barajaPK = barajaPK;
    }

    public Baraja(BarajaPK barajaPK, int nivel, int cantidad) {
        this.barajaPK = barajaPK;
        this.nivel = nivel;
        this.cantidad = cantidad;
    }

    public Baraja(String jugador, String carta) {
        this.barajaPK = new BarajaPK(jugador, carta);
    }

    public BarajaPK getBarajaPK() {
        return barajaPK;
    }

    public void setBarajaPK(BarajaPK barajaPK) {
        this.barajaPK = barajaPK;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Carta getCarta1() {
        return carta1;
    }

    public void setCarta1(Carta carta1) {
        this.carta1 = carta1;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (barajaPK != null ? barajaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Baraja)) {
            return false;
        }
        Baraja other = (Baraja) object;
        if ((this.barajaPK == null && other.barajaPK != null) || (this.barajaPK != null && !this.barajaPK.equals(other.barajaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Baraja{" + "barajaPK=" + barajaPK + ", nivel=" + nivel + ", cantidad=" + cantidad + ", carta1=" + carta1 + ", jugador1=" + jugador1 + '}';
    }

    
    
    
}
