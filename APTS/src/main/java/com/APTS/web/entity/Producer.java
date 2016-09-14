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
public class Producer {
    private int producerId;
    private Integer corpId;
    private Date produceTime;
    private Integer batchNum;
    private String producerMap;

    @Id
    @Column(name = "producer_id")
    public int getProducerId() {
        return producerId;
    }

    public void setProducerId(int producerId) {
        this.producerId = producerId;
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
    @Column(name = "produce_time")
    public Date getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(Date produceTime) {
        this.produceTime = produceTime;
    }

    @Basic
    @Column(name = "batch_num")
    public Integer getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(Integer batchNum) {
        this.batchNum = batchNum;
    }

    @Basic
    @Column(name = "producer_map")
    public String getProducerMap() {
        return producerMap;
    }

    public void setProducerMap(String producerMap) {
        this.producerMap = producerMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Producer producer = (Producer) o;

        if (producerId != producer.producerId) return false;
        if (corpId != null ? !corpId.equals(producer.corpId) : producer.corpId != null)
            return false;
        if (produceTime != null ? !produceTime.equals(producer.produceTime) : producer
                .produceTime != null)
            return false;
        if (batchNum != null ? !batchNum.equals(producer.batchNum) : producer.batchNum != null)
            return false;
        if (producerMap != null ? !producerMap.equals(producer.producerMap) : producer
                .producerMap != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = producerId;
        result = 31 * result + (corpId != null ? corpId.hashCode() : 0);
        result = 31 * result + (produceTime != null ? produceTime.hashCode() : 0);
        result = 31 * result + (batchNum != null ? batchNum.hashCode() : 0);
        result = 31 * result + (producerMap != null ? producerMap.hashCode() : 0);
        return result;
    }
}
