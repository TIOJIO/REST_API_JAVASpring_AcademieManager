package com.academie_manager.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "etudiant", catalog = "myiuc", schema = "")
@NamedQueries({
    @NamedQuery(name = "Etudiant.findAll", query = "SELECT e FROM Etudiant e"),
    @NamedQuery(name = "Etudiant.findByCodeEtud", query = "SELECT e FROM Etudiant e WHERE e.codeEtud = :codeEtud"),
    @NamedQuery(name = "Etudiant.findByAnnee", query = "SELECT e FROM Etudiant e WHERE e.annee = :annee"),
    @NamedQuery(name = "Etudiant.findByNomEtud", query = "SELECT e FROM Etudiant e WHERE e.nomEtud = :nomEtud"),
    @NamedQuery(name = "Etudiant.findByPrenomEtud", query = "SELECT e FROM Etudiant e WHERE e.prenomEtud = :prenomEtud"),
    @NamedQuery(name = "Etudiant.findByTelEtud", query = "SELECT e FROM Etudiant e WHERE e.telEtud = :telEtud"),
    @NamedQuery(name = "Etudiant.findByMailEtud", query = "SELECT e FROM Etudiant e WHERE e.mailEtud = :mailEtud")})
public class Etudiant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code_etud")
    private Short codeEtud;
    @Basic(optional = false)
    @Column(name = "annee")
    private int annee;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etudiant")
    private List<Evaluation> evaluationList;


    public Etudiant() {
    }

    public Etudiant(Short codeEtud) {
        this.codeEtud = codeEtud;
    }

    public Etudiant(Short codeEtud, int annee, String nomEtud, String telEtud) {
        this.codeEtud = codeEtud;
        this.annee = annee;
        this.nomEtud = nomEtud;
        this.telEtud = telEtud;
    }

    public Short getCodeEtud() {
        return codeEtud;
    }

    public void setCodeEtud(Short codeEtud) {
        this.codeEtud = codeEtud;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
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

    public List<Evaluation> getEvaluationList() {
        return evaluationList;
    }

    public void setEvaluationList(List<Evaluation> evaluationList) {
        this.evaluationList = evaluationList;
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
        if (!(object instanceof Etudiant)) {
            return false;
        }
        Etudiant other = (Etudiant) object;
        if ((this.codeEtud == null && other.codeEtud != null) || (this.codeEtud != null && !this.codeEtud.equals(other.codeEtud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myiuc.entities.Etudiant[ codeEtud=" + codeEtud + " ]";
    }
    
}
