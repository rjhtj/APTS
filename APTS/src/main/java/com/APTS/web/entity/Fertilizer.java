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
public class Fertilizer {
    private int fertId;
    private String fertName;
    private String fertProd;
    private String fertEffect;
    private String fertElement;
    private Date fertProdDate;
    private Date fertLimitDate;

    @Id
    @Column(name = "fert_id")
    public int getFertId() {
        return fertId;
    }

    public void setFertId(int fertId) {
        this.fertId = fertId;
    }

    @Basic
    @Column(name = "fert_name")
    public String getFertName() {
        return fertName;
    }

    public void setFertName(String fertName) {
        this.fertName = fertName;
    }

    @Basic
    @Column(name = "fert_prod")
    public String getFertProd() {
        return fertProd;
    }

    public void setFertProd(String fertProd) {
        this.fertProd = fertProd;
    }

    @Basic
    @Column(name = "fert_effect")
    public String getFertEffect() {
        return fertEffect;
    }

    public void setFertEffect(String fertEffect) {
        this.fertEffect = fertEffect;
    }

    @Basic
    @Column(name = "fert_element")
    public String getFertElement() {
        return fertElement;
    }

    public void setFertElement(String fertElement) {
        this.fertElement = fertElement;
    }

    @Basic
    @Column(name = "fert_prod_date")
    public Date getFertProdDate() {
        return fertProdDate;
    }

    public void setFertProdDate(Date fertProdDate) {
        this.fertProdDate = fertProdDate;
    }

    @Basic
    @Column(name = "fert_limit_date")
    public Date getFertLimitDate() {
        return fertLimitDate;
    }

    public void setFertLimitDate(Date fertLimitDate) {
        this.fertLimitDate = fertLimitDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fertilizer that = (Fertilizer) o;

        if (fertId != that.fertId) return false;
        if (fertName != null ? !fertName.equals(that.fertName) : that.fertName != null)
            return false;
        if (fertProd != null ? !fertProd.equals(that.fertProd) : that.fertProd != null)
            return false;
        if (fertEffect != null ? !fertEffect.equals(that.fertEffect) : that.fertEffect != null)
            return false;
        if (fertElement != null ? !fertElement.equals(that.fertElement) : that.fertElement != null)
            return false;
        if (fertProdDate != null ? !fertProdDate.equals(that.fertProdDate) : that.fertProdDate !=
                null)
            return false;
        if (fertLimitDate != null ? !fertLimitDate.equals(that.fertLimitDate) : that
                .fertLimitDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fertId;
        result = 31 * result + (fertName != null ? fertName.hashCode() : 0);
        result = 31 * result + (fertProd != null ? fertProd.hashCode() : 0);
        result = 31 * result + (fertEffect != null ? fertEffect.hashCode() : 0);
        result = 31 * result + (fertElement != null ? fertElement.hashCode() : 0);
        result = 31 * result + (fertProdDate != null ? fertProdDate.hashCode() : 0);
        result = 31 * result + (fertLimitDate != null ? fertLimitDate.hashCode() : 0);
        return result;
    }
}
