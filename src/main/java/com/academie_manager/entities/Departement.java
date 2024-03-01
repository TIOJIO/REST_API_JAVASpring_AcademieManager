package com.academie_manager.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "departement", catalog = "myiuc", schema = "")
@NamedQueries({
    @NamedQuery(name = "Departement.findAll", query = "SELECT d FROM Departement d"),
    @NamedQuery(name = "Departement.findByCodeDepart", query = "SELECT d FROM Departement d WHERE d.codeDepart = :codeDepart"),
    @NamedQuery(name = "Departement.findByLabelDepart", query = "SELECT d FROM Departement d WHERE d.labelDepart = :labelDepart")})
public class Departement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code_depart")
    private String codeDepart;
    @Basic(optional = false)
    @Column(name = "label_depart")
    private String labelDepart;
    @JoinColumn(name = "site", referencedColumnName = "site")
    @ManyToOne(optional = false)
    private College site;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeDepart")
    private List<Enseignant> enseignantList;
    @OneToMany(mappedBy = "codeDepartContenir")
    private List<Enseignant> enseignantList1;

    public Departement() {
    }

    public Departement(String codeDepart) {
        this.codeDepart = codeDepart;
    }

    public Departement(String codeDepart, String labelDepart) {
        this.codeDepart = codeDepart;
        this.labelDepart = labelDepart;
    }

    public String getCodeDepart() {
        return codeDepart;
    }

    public void setCodeDepart(String codeDepart) {
        this.codeDepart = codeDepart;
    }

    public String getLabelDepart() {
        return labelDepart;
    }

    public void setLabelDepart(String labelDepart) {
        this.labelDepart = labelDepart;
    }

    public College getSite() {
        return site;
    }

    public void setSite(College site) {
        this.site = site;
    }

    public List<Enseignant> getEnseignantList() {
        return enseignantList;
    }

    public void setEnseignantList(List<Enseignant> enseignantList) {
        this.enseignantList = enseignantList;
    }

    public List<Enseignant> getEnseignantList1() {
        return enseignantList1;
    }

    public void setEnseignantList1(List<Enseignant> enseignantList1) {
        this.enseignantList1 = enseignantList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeDepart != null ? codeDepart.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departement)) {
            return false;
        }
        Departement other = (Departement) object;
        if ((this.codeDepart == null && other.codeDepart != null) || (this.codeDepart != null && !this.codeDepart.equals(other.codeDepart))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myiuc.entities.Departement[ codeDepart=" + codeDepart + " ]";
    }
    
}
