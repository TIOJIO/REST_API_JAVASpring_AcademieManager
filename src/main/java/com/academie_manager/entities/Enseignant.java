package com.academie_manager.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "enseignant", catalog = "myiuc", schema = "")
@NamedQueries({
    @NamedQuery(name = "Enseignant.findAll", query = "SELECT e FROM Enseignant e"),
    @NamedQuery(name = "Enseignant.findByCodeEtud", query = "SELECT e FROM Enseignant e WHERE e.codeEtud = :codeEtud"),
    @NamedQuery(name = "Enseignant.findByDatePriseEns", query = "SELECT e FROM Enseignant e WHERE e.datePriseEns = :datePriseEns"),
    @NamedQuery(name = "Enseignant.findByIndice", query = "SELECT e FROM Enseignant e WHERE e.indice = :indice"),
    @NamedQuery(name = "Enseignant.findByNomEtud", query = "SELECT e FROM Enseignant e WHERE e.nomEtud = :nomEtud"),
    @NamedQuery(name = "Enseignant.findByPrenomEtud", query = "SELECT e FROM Enseignant e WHERE e.prenomEtud = :prenomEtud"),
    @NamedQuery(name = "Enseignant.findByTelEtud", query = "SELECT e FROM Enseignant e WHERE e.telEtud = :telEtud"),
    @NamedQuery(name = "Enseignant.findByMailEtud", query = "SELECT e FROM Enseignant e WHERE e.mailEtud = :mailEtud")})
public class Enseignant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code_etud")
    private Short codeEtud;
    @Basic(optional = false)
    @Column(name = "date_prise_ens")
    @Temporal(TemporalType.DATE)
    private Date datePriseEns;
    @Basic(optional = false)
    @Column(name = "indice")
    private int indice;
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
    @JoinTable(name = "enseigant_matiere", joinColumns = {
        @JoinColumn(name = "code_etud", referencedColumnName = "code_etud")}, inverseJoinColumns = {
        @JoinColumn(name = "code_mat", referencedColumnName = "code_mat")})
    @ManyToMany
    private List<Matiere> matiereList;
    @JoinColumn(name = "code_depart", referencedColumnName = "code_depart")
    @ManyToOne(optional = false)
    private Departement codeDepart;
    @JoinColumn(name = "code_depart_contenir", referencedColumnName = "code_depart")
    @ManyToOne
    private Departement codeDepartContenir;


    public Enseignant() {
    }

    public Enseignant(Short codeEtud) {
        this.codeEtud = codeEtud;
    }

    public Enseignant(Short codeEtud, Date datePriseEns, int indice, String nomEtud, String telEtud) {
        this.codeEtud = codeEtud;
        this.datePriseEns = datePriseEns;
        this.indice = indice;
        this.nomEtud = nomEtud;
        this.telEtud = telEtud;
    }

    public Short getCodeEtud() {
        return codeEtud;
    }

    public void setCodeEtud(Short codeEtud) {
        this.codeEtud = codeEtud;
    }

    public Date getDatePriseEns() {
        return datePriseEns;
    }

    public void setDatePriseEns(Date datePriseEns) {
        this.datePriseEns = datePriseEns;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
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

    public List<Matiere> getMatiereList() {
        return matiereList;
    }

    public void setMatiereList(List<Matiere> matiereList) {
        this.matiereList = matiereList;
    }

    public Departement getCodeDepart() {
        return codeDepart;
    }

    public void setCodeDepart(Departement codeDepart) {
        this.codeDepart = codeDepart;
    }

    public Departement getCodeDepartContenir() {
        return codeDepartContenir;
    }

    public void setCodeDepartContenir(Departement codeDepartContenir) {
        this.codeDepartContenir = codeDepartContenir;
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
        if (!(object instanceof Enseignant)) {
            return false;
        }
        Enseignant other = (Enseignant) object;
        if ((this.codeEtud == null && other.codeEtud != null) || (this.codeEtud != null && !this.codeEtud.equals(other.codeEtud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myiuc.entities.Enseignant[ codeEtud=" + codeEtud + " ]";
    }
    
}
