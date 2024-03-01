package com.academie_manager.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "matiere", catalog = "myiuc", schema = "")
@NamedQueries({
    @NamedQuery(name = "Matiere.findAll", query = "SELECT m FROM Matiere m"),
    @NamedQuery(name = "Matiere.findByCodeMat", query = "SELECT m FROM Matiere m WHERE m.codeMat = :codeMat"),
    @NamedQuery(name = "Matiere.findByLabelMat", query = "SELECT m FROM Matiere m WHERE m.labelMat = :labelMat"),
    @NamedQuery(name = "Matiere.findByCreditMat", query = "SELECT m FROM Matiere m WHERE m.creditMat = :creditMat"),
    @NamedQuery(name = "Matiere.findByVhMat", query = "SELECT m FROM Matiere m WHERE m.vhMat = :vhMat")})
public class Matiere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code_mat")
    private String codeMat;
    @Basic(optional = false)
    @Column(name = "label_mat")
    private String labelMat;
    @Basic(optional = false)
    @Column(name = "credit_mat")
    private int creditMat;
    @Basic(optional = false)
    @Column(name = "vh_mat")
    private int vhMat;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matiere")
    private List<Evaluation> evaluationList;
    @JoinColumn(name = "num_salle", referencedColumnName = "num_salle")
    @ManyToOne(optional = false)
    private Salle numSalle;

    public Matiere() {
    }

    public Matiere(String codeMat) {
        this.codeMat = codeMat;
    }

    public Matiere(String codeMat, String labelMat, int creditMat, int vhMat) {
        this.codeMat = codeMat;
        this.labelMat = labelMat;
        this.creditMat = creditMat;
        this.vhMat = vhMat;
    }

    public String getCodeMat() {
        return codeMat;
    }

    public void setCodeMat(String codeMat) {
        this.codeMat = codeMat;
    }

    public String getLabelMat() {
        return labelMat;
    }

    public void setLabelMat(String labelMat) {
        this.labelMat = labelMat;
    }

    public int getCreditMat() {
        return creditMat;
    }

    public void setCreditMat(int creditMat) {
        this.creditMat = creditMat;
    }

    public int getVhMat() {
        return vhMat;
    }

    public void setVhMat(int vhMat) {
        this.vhMat = vhMat;
    }

 

    public List<Evaluation> getEvaluationList() {
        return evaluationList;
    }

    public void setEvaluationList(List<Evaluation> evaluationList) {
        this.evaluationList = evaluationList;
    }

    public Salle getNumSalle() {
        return numSalle;
    }

    public void setNumSalle(Salle numSalle) {
        this.numSalle = numSalle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeMat != null ? codeMat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matiere)) {
            return false;
        }
        Matiere other = (Matiere) object;
        if ((this.codeMat == null && other.codeMat != null) || (this.codeMat != null && !this.codeMat.equals(other.codeMat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myiuc.entities.Matiere[ codeMat=" + codeMat + " ]";
    }
    
}
