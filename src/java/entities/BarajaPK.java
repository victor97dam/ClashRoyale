/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Sergio
 */
@Embeddable
public class BarajaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "jugador")
    private String jugador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "carta")
    private String carta;

    public BarajaPK() {
    }

    public BarajaPK(String jugador, String carta) {
        this.jugador = jugador;
        this.carta = carta;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public String getCarta() {
        return carta;
    }

    public void setCarta(String carta) {
        this.carta = carta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jugador != null ? jugador.hashCode() : 0);
        hash += (carta != null ? carta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BarajaPK)) {
            return false;
        }
        BarajaPK other = (BarajaPK) object;
        if ((this.jugador == null && other.jugador != null) || (this.jugador != null && !this.jugador.equals(other.jugador))) {
            return false;
        }
        if ((this.carta == null && other.carta != null) || (this.carta != null && !this.carta.equals(other.carta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BarajaPK[ jugador=" + jugador + ", carta=" + carta + " ]";
    }
    
}
