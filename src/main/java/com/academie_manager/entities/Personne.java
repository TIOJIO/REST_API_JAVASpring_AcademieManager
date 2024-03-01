package com.academie_manager.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "personne", catalog = "myiuc", schema = "")
@NamedQueries({
    @NamedQuery(name = "Personne.findAll", query = "SELECT p FROM Personne p"),
    @NamedQuery(name = "Personne.findByCodeEtud", query = "SELECT p FROM Personne p WHERE p.codeEtud = :codeEtud"),
    @NamedQuery(name = "Personne.findByNomEtud", query = "SELECT p FROM Personne p WHERE p.nomEtud = :nomEtud"),
    @NamedQuery(name = "Personne.findByPrenomEtud", query = "SELECT p FROM Personne p WHERE p.prenomEtud = :prenomEtud"),
    @NamedQuery(name = "Personne.findByTelEtud", query = "SELECT p FROM Personne p WHERE p.telEtud = :telEtud"),
    @NamedQuery(name = "Personne.findByMailEtud", query = "SELECT p FROM Personne p WHERE p.mailEtud = :mailEtud")})
public class Personne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code_etud")
    private Short codeEtud;
    @Basic(optional = false)
    @Column(name = "nom_etud")
    private String nomEtud;
    @Column(name = "prenom_etud")
    private String prenomEtud;
    @Basic(optional = false)
    @Column(name = "tel_etud")
    private String telEtud;
    @Column(name = "mail_etud")
    private String mailEtud;


    public Personne() {
    }

    public Personne(Short codeEtud) {
        this.codeEtud = codeEtud;
    }

    public Personne(Short codeEtud, String nomEtud, String telEtud) {
        this.codeEtud = codeEtud;
        this.nomEtud = nomEtud;
        this.telEtud = telEtud;
    }

    public Short getCodeEtud() {
        return codeEtud;
    }

    public void setCodeEtud(Short codeEtud) {
        this.codeEtud = codeEtud;
    }

    public String getNomEtud() {
        return nomEtud;
    }

    public void setNomEtud(String nomEtud) {
        this.nomEtud = nomEtud;
    }

    public String getPrenomEtud() {
        return prenomEtud;
    }

    public void setPrenomEtud(String prenomEtud) {
        this.prenomEtud = prenomEtud;
    }

    public String getTelEtud() {
        return telEtud;
    }

    public void setTelEtud(String telEtud) {
        this.telEtud = telEtud;
    }

    public String getMailEtud() {
        return mailEtud;
    }

    public void setMailEtud(String mailEtud) {
        this.mailEtud = mailEtud;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeEtud != null ? codeEtud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personne)) {
            return false;
        }
        Personne other = (Personne) object;
        if ((this.codeEtud == null && other.codeEtud != null) || (this.codeEtud != null && !this.codeEtud.equals(other.codeEtud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myiuc.entities.Personne[ codeEtud=" + codeEtud + " ]";
    }
    
}
