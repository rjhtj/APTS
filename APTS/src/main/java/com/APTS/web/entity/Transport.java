package com.APTS.web.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by RuanJH on 2016/8/25.
 */
@Entity
public class Transport {
    private int transportId;
    private Integer corpId;
    private Date transDate;
    private String transMethod;
    private String transAmount;
    private String destination;
    private Integer batchNum;

    @Id
    @Column(name = "transport_id")
    public int getTransportId() {
        return transportId;
    }

    public void setTransportId(int transportId) {
        this.transportId = transportId;
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
    @Column(name = "trans_date")
    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    @Basic
    @Column(name = "trans_method")
    public String getTransMethod() {
        return transMethod;
    }

    public void setTransMethod(String transMethod) {
        this.transMethod = transMethod;
    }

    @Basic
    @Column(name = "trans_amount")
    public String getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(String transAmount) {
        this.transAmount = transAmount;
    }

    @Basic
    @Column(name = "destination")
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Basic
    @Column(name = "batch_num")
    public Integer getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(Integer batchNum) {
        this.batchNum = batchNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transport transport = (Transport) o;

        if (transportId != transport.transportId) return false;
        if (corpId != null ? !corpId.equals(transport.corpId) : transport.corpId != null)
            return false;
        if (transDate != null ? !transDate.equals(transport.transDate) : transport.transDate !=
                null)
            return false;
        if (transMethod != null ? !transMethod.equals(transport.transMethod) : transport
                .transMethod != null)
            return false;
        if (transAmount != null ? !transAmount.equals(transport.transAmount) : transport
                .transAmount != null)
            return false;
        if (destination != null ? !destination.equals(transport.destination) : transport
                .destination != null)
            return false;
        if (batchNum != null ? !batchNum.equals(transport.batchNum) : transport.batchNum != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = transportId;
        result = 31 * result + (corpId != null ? corpId.hashCode() : 0);
        result = 31 * result + (transDate != null ? transDate.hashCode() : 0);
        result = 31 * result + (transMethod != null ? transMethod.hashCode() : 0);
        result = 31 * result + (transAmount != null ? transAmount.hashCode() : 0);
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + (batchNum != null ? batchNum.hashCode() : 0);
        return result;
    }
}
