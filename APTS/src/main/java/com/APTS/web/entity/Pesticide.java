package com.APTS.web.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by RuanJH on 2016/8/20.
 */
@Entity
public class Pesticide {
    private int pestId;
    private String pestName;
    private String pestProd;
    private String pestEffect;
    private String pestElement;
    private Date pestProdDate;
    private Date pestLimitDate;

    @Id
    @Column(name = "pest_id")
    public int getPestId() {
        return pestId;
    }

    public void setPestId(int pestId) {
        this.pestId = pestId;
    }

    @Basic
    @Column(name = "pest_name")
    public String getPestName() {
        return pestName;
    }

    public void setPestName(String pestName) {
        this.pestName = pestName;
    }

    @Basic
    @Column(name = "pest_prod")
    public String getPestProd() {
        return pestProd;
    }

    public void setPestProd(String pestProd) {
        this.pestProd = pestProd;
    }

    @Basic
    @Column(name = "pest_effect")
    public String getPestEffect() {
        return pestEffect;
    }

    public void setPestEffect(String pestEffect) {
        this.pestEffect = pestEffect;
    }

    @Basic
    @Column(name = "pest_element")
    public String getPestElement() {
        return pestElement;
    }

    public void setPestElement(String pestElement) {
        this.pestElement = pestElement;
    }

    @Basic
    @Column(name = "pest_prod_date")
    public Date getPestProdDate() {
        return pestProdDate;
    }

    public void setPestProdDate(Date pestProdDate) {
        this.pestProdDate = pestProdDate;
    }

    @Basic
    @Column(name = "pest_limit_date")
    public Date getPestLimitDate() {
        return pestLimitDate;
    }

    public void setPestLimitDate(Date pestLimitDate) {
        this.pestLimitDate = pestLimitDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pesticide pesticide = (Pesticide) o;

        if (pestId != pesticide.pestId) return false;
        if (pestName != null ? !pestName.equals(pesticide.pestName) : pesticide.pestName != null)
            return false;
        if (pestProd != null ? !pestProd.equals(pesticide.pestProd) : pesticide.pestProd != null)
            return false;
        if (pestEffect != null ? !pestEffect.equals(pesticide.pestEffect) : pesticide.pestEffect
                != null)
            return false;
        if (pestElement != null ? !pestElement.equals(pesticide.pestElement) : pesticide
                .pestElement != null)
            return false;
        if (pestProdDate != null ? !pestProdDate.equals(pesticide.pestProdDate) : pesticide
                .pestProdDate != null)
            return false;
        if (pestLimitDate != null ? !pestLimitDate.equals(pesticide.pestLimitDate) : pesticide
                .pestLimitDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pestId;
        result = 31 * result + (pestName != null ? pestName.hashCode() : 0);
        result = 31 * result + (pestProd != null ? pestProd.hashCode() : 0);
        result = 31 * result + (pestEffect != null ? pestEffect.hashCode() : 0);
        result = 31 * result + (pestElement != null ? pestElement.hashCode() : 0);
        result = 31 * result + (pestProdDate != null ? pestProdDate.hashCode() : 0);
        result = 31 * result + (pestLimitDate != null ? pestLimitDate.hashCode() : 0);
        return result;
    }
}
