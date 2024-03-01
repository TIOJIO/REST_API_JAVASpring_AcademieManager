package com.academie_manager.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "college", catalog = "myiuc", schema = "")
@NamedQueries({
    @NamedQuery(name = "College.findAll", query = "SELECT c FROM College c"),
    @NamedQuery(name = "College.findBySite", query = "SELECT c FROM College c WHERE c.site = :site")})
public class College implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "site")
    private String site;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "site")
    private List<Departement> departementList;

    public College() {
    }

    public College(String site) {
        this.site = site;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public List<Departement> getDepartementList() {
        return departementList;
    }

    public void setDepartementList(List<Departement> departementList) {
        this.departementList = departementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (site != null ? site.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof College)) {
            return false;
        }
        College other = (College) object;
        if ((this.site == null && other.site != null) || (this.site != null && !this.site.equals(other.site))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myiuc.entities.College[ site=" + site + " ]";
    }
    
}
