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
public class Storage {
    private int storageId;
    private Integer corpId;
    private Date storeTime;
    private Integer batchNum;
    private String storeMethod;

    @Id
    @Column(name = "storage_id")
    public int getStorageId() {
        return storageId;
    }

    public void setStorageId(int storageId) {
        this.storageId = storageId;
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
    @Column(name = "store_time")
    public Date getStoreTime() {
        return storeTime;
    }

    public void setStoreTime(Date storeTime) {
        this.storeTime = storeTime;
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
    @Column(name = "store_method")
    public String getStoreMethod(){
        return storeMethod;
    }

    public void setStoreMethod(String storeMethod){
        this.storeMethod = storeMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Storage storage = (Storage) o;

        if (storageId != storage.storageId) return false;
        if (corpId != null ? !corpId.equals(storage.corpId) : storage.corpId != null) return false;
        if (storeTime != null ? !storeTime.equals(storage.storeTime) : storage.storeTime != null)
            return false;
        if (batchNum != null ? !batchNum.equals(storage.batchNum) : storage.batchNum != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = storageId;
        result = 31 * result + (corpId != null ? corpId.hashCode() : 0);
        result = 31 * result + (storeTime != null ? storeTime.hashCode() : 0);
        result = 31 * result + (batchNum != null ? batchNum.hashCode() : 0);
        return result;
    }

}
