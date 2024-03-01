package com.academie_manager.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "salle", catalog = "myiuc", schema = "")
@NamedQueries({
    @NamedQuery(name = "Salle.findAll", query = "SELECT s FROM Salle s"),
    @NamedQuery(name = "Salle.findByNumSalle", query = "SELECT s FROM Salle s WHERE s.numSalle = :numSalle"),
    @NamedQuery(name = "Salle.findByNbPlaceSalle", query = "SELECT s FROM Salle s WHERE s.nbPlaceSalle = :nbPlaceSalle")})
public class Salle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "num_salle")
    private Short numSalle;
    @Basic(optional = false)
    @Column(name = "nb_place_salle")
    private int nbPlaceSalle;
    

    public Salle() {
    }

    public Salle(Short numSalle) {
        this.numSalle = numSalle;
    }

    public Salle(Short numSalle, int nbPlaceSalle) {
        this.numSalle = numSalle;
        this.nbPlaceSalle = nbPlaceSalle;
    }

    public Short getNumSalle() {
        return numSalle;
    }

    public void setNumSalle(Short numSalle) {
        this.numSalle = numSalle;
    }

    public int getNbPlaceSalle() {
        return nbPlaceSalle;
    }

    public void setNbPlaceSalle(int nbPlaceSalle) {
        this.nbPlaceSalle = nbPlaceSalle;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numSalle != null ? numSalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salle)) {
            return false;
        }
        Salle other = (Salle) object;
        if ((this.numSalle == null && other.numSalle != null) || (this.numSalle != null && !this.numSalle.equals(other.numSalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myiuc.entities.Salle[ numSalle=" + numSalle + " ]";
    }
    
}
