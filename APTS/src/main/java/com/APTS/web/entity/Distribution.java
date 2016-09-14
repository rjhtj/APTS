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
public class Distribution {
    private int distributionId;
    private Integer corpId;
    private String customer;
    private Date distributionTime;
    private int batchNum;
    private String distributionMethod;


    @Id
    @Column(name = "distribution_id")
    public int getDistributionId() {
        return distributionId;
    }

    public void setDistributionId(int distributionId) {
        this.distributionId = distributionId;
    }

    @Basic
    @Column(name = "corp_id")
    public Integer getCorpId() {
        return corpId;
    }

    public void setCorpId(Integer corpId) {
        this.corpId = corpId;
    }

    @Basic
    @Column(name = "customer")
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Basic
    @Column(name = "distribution_time")
    public Date getDistributionTime(){
        return distributionTime;
    }

    public void setDistributionTime(Date distributionTime){
        this.distributionTime = distributionTime;
    }

    @Basic
    @Column(name = "batch_num")
    public int getBatchNum(){
        return batchNum;
    }

    public void setBatchNum(int batchNum){
        this.batchNum = batchNum;
    }

    @Basic
    @Column(name = "distribution_method")
    public String getDistributionMethod(){
        return distributionMethod;
    }

    public void setDistributionMethod(String distributionMethod){
        this.distributionMethod = distributionMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Distribution that = (Distribution) o;

        if (distributionId != that.distributionId) return false;
        if (corpId != null ? !corpId.equals(that.corpId) : that.corpId != null) return false;
        if (customer != null ? !customer.equals(that.customer) : that.customer != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = distributionId;
        result = 31 * result + (corpId != null ? corpId.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        return result;
    }
}
