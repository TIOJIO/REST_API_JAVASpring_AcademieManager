package com.academie_manager.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
@Embeddable
public class EvaluationPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "code_etud")
    private short codeEtud;
    @Basic(optional = false)
    @Column(name = "code_mat")
    private String codeMat;

    public EvaluationPK() {
    }

    public EvaluationPK(short codeEtud, String codeMat) {
        this.codeEtud = codeEtud;
        this.codeMat = codeMat;
    }

    public short getCodeEtud() {
        return codeEtud;
    }

    public void setCodeEtud(short codeEtud) {
        this.codeEtud = codeEtud;
    }

    public String getCodeMat() {
        return codeMat;
    }

    public void setCodeMat(String codeMat) {
        this.codeMat = codeMat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codeEtud;
        hash += (codeMat != null ? codeMat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluationPK)) {
            return false;
        }
        EvaluationPK other = (EvaluationPK) object;
        if (this.codeEtud != other.codeEtud) {
            return false;
        }
        if ((this.codeMat == null && other.codeMat != null) || (this.codeMat != null && !this.codeMat.equals(other.codeMat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myiuc.entities.EvaluationPK[ codeEtud=" + codeEtud + ", codeMat=" + codeMat + " ]";
    }
    
}
