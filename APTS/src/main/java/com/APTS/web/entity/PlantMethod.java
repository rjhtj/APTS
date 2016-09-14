package com.APTS.web.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by RuanJH on 2016/8/20.
 */
@Entity
@javax.persistence.Table(name = "plant_method", schema = "", catalog = "apts")
public class PlantMethod {
    private int pltMthId;

    @Id
    @javax.persistence.Column(name = "plt_mth_id")
    public int getPltMthId() {
        return pltMthId;
    }

    public void setPltMthId(int pltMthId) {
        this.pltMthId = pltMthId;
    }

    private Date seedDate;

    @Basic
    @javax.persistence.Column(name = "seed_date")
    public Date getSeedDate() {
        return seedDate;
    }

    public void setSeedDate(Date seedDate) {
        this.seedDate = seedDate;
    }

    private String seedWeather;

    @Basic
    @javax.persistence.Column(name = "seed_weather")
    public String getSeedWeather() {
        return seedWeather;
    }

    public void setSeedWeather(String seedWeather) {
        this.seedWeather = seedWeather;
    }

    private Date plowDate;

    @Basic
    @javax.persistence.Column(name = "plow_date")
    public Date getPlowDate() {
        return plowDate;
    }

    public void setPlowDate(Date plowDate) {
        this.plowDate = plowDate;
    }

    private String machine;

    @Basic
    @javax.persistence.Column(name = "machine")
    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    private Date growDate;

    @Basic
    @javax.persistence.Column(name = "grow_date")
    public Date getGrowDate() {
        return growDate;
    }

    public void setGrowDate(Date growDate) {
        this.growDate = growDate;
    }

    private String growMethod;

    @Basic
    @javax.persistence.Column(name = "grow_method")
    public String getGrowMethod() {
        return growMethod;
    }

    public void setGrowMethod(String growMethod) {
        this.growMethod = growMethod;
    }

    private Date transDate;

    @Basic
    @javax.persistence.Column(name = "trans_date")
    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    private String waterDate;

    @Basic
    @javax.persistence.Column(name = "water_date")
    public String getWaterDate() {
        return waterDate;
    }

    public void setWaterDate(String waterDate) {
        this.waterDate = waterDate;
    }

    private String waterMethod;

    @Basic
    @javax.persistence.Column(name = "water_method")
    public String getWaterMethod() {
        return waterMethod;
    }

    public void setWaterMethod(String waterMethod) {
        this.waterMethod = waterMethod;
    }

    private Date gatherDate;

    @Basic
    @javax.persistence.Column(name = "gather_date")
    public Date getGatherDate() {
        return gatherDate;
    }

    public void setGatherDate(Date gatherDate) {
        this.gatherDate = gatherDate;
    }

    private String gatherMethod;

    @Basic
    @javax.persistence.Column(name = "gather_method")
    public String getGatherMethod() {
        return gatherMethod;
    }

    public void setGatherMethod(String gatherMethod) {
        this.gatherMethod = gatherMethod;
    }

    private Date packDate;

    @Basic
    @javax.persistence.Column(name = "pack_date")
    public Date getPackDate() {
        return packDate;
    }

    public void setPackDate(Date packDate) {
        this.packDate = packDate;
    }

    private String packMethod;

    @Basic
    @javax.persistence.Column(name = "pack_method")
    public String getPackMethod() {
        return packMethod;
    }

    public void setPackMethod(String packMethod) {
        this.packMethod = packMethod;
    }

    private Integer pestId;

    @Basic
    @javax.persistence.Column(name = "pest_id")
    public Integer getPestId() {
        return pestId;
    }

    public void setPestId(Integer pestId) {
        this.pestId = pestId;
    }

    private Date pestDate;

    @Basic
    @javax.persistence.Column(name = "pest_date")
    public Date getPestDate() {
        return pestDate;
    }

    public void setPestDate(Date pestDate) {
        this.pestDate = pestDate;
    }

    private String pestMethod;

    @Basic
    @javax.persistence.Column(name = "pest_method")
    public String getPestMethod() {
        return pestMethod;
    }

    public void setPestMethod(String pestMethod) {
        this.pestMethod = pestMethod;
    }

    private String pestAmount;

    @Basic
    @javax.persistence.Column(name = "pest_amount")
    public String getPestAmount() {
        return pestAmount;
    }

    public void setPestAmount(String pestAmount) {
        this.pestAmount = pestAmount;
    }

    private Integer fertId;

    @Basic
    @javax.persistence.Column(name = "fert_id")
    public Integer getFertId() {
        return fertId;
    }

    public void setFertId(Integer fertId) {
        this.fertId = fertId;
    }

    private Date fertDate;

    @Basic
    @javax.persistence.Column(name = "fert_date")
    public Date getFertDate() {
        return fertDate;
    }

    public void setFertDate(Date fertDate) {
        this.fertDate = fertDate;
    }

    private String fertMethod;

    @Basic
    @javax.persistence.Column(name = "fert_method")
    public String getFertMethod() {
        return fertMethod;
    }

    public void setFertMethod(String fertMethod) {
        this.fertMethod = fertMethod;
    }

    private String fertAmount;

    @Basic
    @javax.persistence.Column(name = "fert_amount")
    public String getFertAmount() {
        return fertAmount;
    }

    public void setFertAmount(String fertAmount) {
        this.fertAmount = fertAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlantMethod that = (PlantMethod) o;

        if (pltMthId != that.pltMthId) return false;
        if (seedDate != null ? !seedDate.equals(that.seedDate) : that.seedDate != null)
            return false;
        if (seedWeather != null ? !seedWeather.equals(that.seedWeather) : that.seedWeather != null)
            return false;
        if (plowDate != null ? !plowDate.equals(that.plowDate) : that.plowDate != null)
            return false;
        if (machine != null ? !machine.equals(that.machine) : that.machine != null) return false;
        if (growDate != null ? !growDate.equals(that.growDate) : that.growDate != null)
            return false;
        if (growMethod != null ? !growMethod.equals(that.growMethod) : that.growMethod != null)
            return false;
        if (transDate != null ? !transDate.equals(that.transDate) : that.transDate != null)
            return false;
        if (waterDate != null ? !waterDate.equals(that.waterDate) : that.waterDate != null)
            return false;
        if (waterMethod != null ? !waterMethod.equals(that.waterMethod) : that.waterMethod != null)
            return false;
        if (gatherDate != null ? !gatherDate.equals(that.gatherDate) : that.gatherDate != null)
            return false;
        if (gatherMethod != null ? !gatherMethod.equals(that.gatherMethod) : that.gatherMethod !=
                null)
            return false;
        if (packDate != null ? !packDate.equals(that.packDate) : that.packDate != null)
            return false;
        if (packMethod != null ? !packMethod.equals(that.packMethod) : that.packMethod != null)
            return false;
        if (pestId != null ? !pestId.equals(that.pestId) : that.pestId != null) return false;
        if (pestDate != null ? !pestDate.equals(that.pestDate) : that.pestDate != null)
            return false;
        if (pestMethod != null ? !pestMethod.equals(that.pestMethod) : that.pestMethod != null)
            return false;
        if (pestAmount != null ? !pestAmount.equals(that.pestAmount) : that.pestAmount != null)
            return false;
        if (fertId != null ? !fertId.equals(that.fertId) : that.fertId != null) return false;
        if (fertDate != null ? !fertDate.equals(that.fertDate) : that.fertDate != null)
            return false;
        if (fertMethod != null ? !fertMethod.equals(that.fertMethod) : that.fertMethod != null)
            return false;
        if (fertAmount != null ? !fertAmount.equals(that.fertAmount) : that.fertAmount != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pltMthId;
        result = 31 * result + (seedDate != null ? seedDate.hashCode() : 0);
        result = 31 * result + (seedWeather != null ? seedWeather.hashCode() : 0);
        result = 31 * result + (plowDate != null ? plowDate.hashCode() : 0);
        result = 31 * result + (machine != null ? machine.hashCode() : 0);
        result = 31 * result + (growDate != null ? growDate.hashCode() : 0);
        result = 31 * result + (growMethod != null ? growMethod.hashCode() : 0);
        result = 31 * result + (transDate != null ? transDate.hashCode() : 0);
        result = 31 * result + (waterDate != null ? waterDate.hashCode() : 0);
        result = 31 * result + (waterMethod != null ? waterMethod.hashCode() : 0);
        result = 31 * result + (gatherDate != null ? gatherDate.hashCode() : 0);
        result = 31 * result + (gatherMethod != null ? gatherMethod.hashCode() : 0);
        result = 31 * result + (packDate != null ? packDate.hashCode() : 0);
        result = 31 * result + (packMethod != null ? packMethod.hashCode() : 0);
        result = 31 * result + (pestId != null ? pestId.hashCode() : 0);
        result = 31 * result + (pestDate != null ? pestDate.hashCode() : 0);
        result = 31 * result + (pestMethod != null ? pestMethod.hashCode() : 0);
        result = 31 * result + (pestAmount != null ? pestAmount.hashCode() : 0);
        result = 31 * result + (fertId != null ? fertId.hashCode() : 0);
        result = 31 * result + (fertDate != null ? fertDate.hashCode() : 0);
        result = 31 * result + (fertMethod != null ? fertMethod.hashCode() : 0);
        result = 31 * result + (fertAmount != null ? fertAmount.hashCode() : 0);
        return result;
    }
}
