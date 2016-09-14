package com.APTS.web.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by RuanJH on 2016/8/31.
 */
@Entity
public class Certificate {
    private int certificateId;
    private Integer detectorId;
    private Integer corpId;
    private Date detectDate;
    private Integer producerId;
    private String name;
    private Timestamp uploadDate;
    private String path;

    @Id
    @Column(name = "certificate_id")
    public int getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(int certificateId) {
        this.certificateId = certificateId;
    }

    @Basic
    @Column(name = "detector_id")
    public Integer getDetectorId() {
        return detectorId;
    }

    public void setDetectorId(Integer detectorId) {
        this.detectorId = detectorId;
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
    @Column(name = "detect_date")
    public Date getDetectDate() {
        return detectDate;
    }

    public void setDetectDate(Date detectDate) {
        this.detectDate = detectDate;
    }

    @Basic
    @Column(name = "producer_id")
    public Integer getProducerId() {
        return producerId;
    }

    public void setProducerId(Integer producerId) {
        this.producerId = producerId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "upload_date")
    public Timestamp getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Timestamp uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Basic
    @Column(name = "path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Certificate that = (Certificate) o;

        if (certificateId != that.certificateId) return false;
        if (detectorId != null ? !detectorId.equals(that.detectorId) : that.detectorId != null)
            return false;
        if (corpId != null ? !corpId.equals(that.corpId) : that.corpId != null) return false;
        if (detectDate != null ? !detectDate.equals(that.detectDate) : that.detectDate != null)
            return false;
        if (producerId != null ? !producerId.equals(that.producerId) : that.producerId != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (uploadDate != null ? !uploadDate.equals(that.uploadDate) : that.uploadDate != null)
            return false;
        if (path != null ? !path.equals(that.path) : that.path != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = certificateId;
        result = 31 * result + (detectorId != null ? detectorId.hashCode() : 0);
        result = 31 * result + (corpId != null ? corpId.hashCode() : 0);
        result = 31 * result + (detectDate != null ? detectDate.hashCode() : 0);
        result = 31 * result + (producerId != null ? producerId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (uploadDate != null ? uploadDate.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        return result;
    }
}
