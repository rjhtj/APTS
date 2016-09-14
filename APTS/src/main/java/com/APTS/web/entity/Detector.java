package com.APTS.web.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by RuanJH on 2016/8/20.
 */
@Entity
public class Detector {
    private int detectorId;
    private String name;
    private String address;

    @Id
    @Column(name = "detector_id")
    public int getDetectorId() {
        return detectorId;
    }

    public void setDetectorId(int detectorId) {
        this.detectorId = detectorId;
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
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Detector detector = (Detector) o;

        if (detectorId != detector.detectorId) return false;
        if (name != null ? !name.equals(detector.name) : detector.name != null) return false;
        if (address != null ? !address.equals(detector.address) : detector.address != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = detectorId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
