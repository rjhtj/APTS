package com.APTS.web.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by RuanJH on 2016/8/30.
 */
@Entity
@Table(name = "corporation_info", schema = "", catalog = "apts")
public class CorporationInfo {
    private int corpId;
    private String registrationNum;
    private String name;
    private Integer role;
    private String representative;
    private Integer registeredAssets;
    private Date setUpDate;
    private String field;
    private String registrationAuthority;
    private String address;
    private String telNum;
    private String webUrl;
    private Integer authentic;

    @Id
    @Column(name = "corp_id")
    public int getCorpId() {
        return corpId;
    }

    public void setCorpId(int corpId) {
        this.corpId = corpId;
    }

    @Basic
    @Column(name = "registration_num")
    public String getRegistrationNum() {
        return registrationNum;
    }

    public void setRegistrationNum(String registrationNum) {
        this.registrationNum = registrationNum;
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
    @Column(name = "role")
    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Basic
    @Column(name = "representative")
    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    @Basic
    @Column(name = "registered_assets")
    public Integer getRegisteredAssets() {
        return registeredAssets;
    }

    public void setRegisteredAssets(Integer registeredAssets) {
        this.registeredAssets = registeredAssets;
    }

    @Basic
    @Column(name = "set_up_date")
    public Date getSetUpDate() {
        return setUpDate;
    }

    public void setSetUpDate(Date setUpDate) {
        this.setUpDate = setUpDate;
    }

    @Basic
    @Column(name = "field")
    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Basic
    @Column(name = "registration_authority")
    public String getRegistrationAuthority() {
        return registrationAuthority;
    }

    public void setRegistrationAuthority(String registrationAuthority) {
        this.registrationAuthority = registrationAuthority;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "tel_num")
    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    @Basic
    @Column(name = "web_url")
    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    @Basic
    @Column(name = "authentic")
    public Integer getAuthentic() {
        return authentic;
    }

    public void setAuthentic(Integer authentic) {
        this.authentic = authentic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CorporationInfo that = (CorporationInfo) o;

        if (corpId != that.corpId) return false;
        if (registrationNum != null ? !registrationNum.equals(that.registrationNum) : that
                .registrationNum != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        if (representative != null ? !representative.equals(that.representative) : that
                .representative != null)
            return false;
        if (registeredAssets != null ? !registeredAssets.equals(that.registeredAssets) : that
                .registeredAssets != null)
            return false;
        if (setUpDate != null ? !setUpDate.equals(that.setUpDate) : that.setUpDate != null)
            return false;
        if (field != null ? !field.equals(that.field) : that.field != null) return false;
        if (registrationAuthority != null ? !registrationAuthority.equals(that
                .registrationAuthority) : that.registrationAuthority != null)
            return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (telNum != null ? !telNum.equals(that.telNum) : that.telNum != null) return false;
        if (webUrl != null ? !webUrl.equals(that.webUrl) : that.webUrl != null) return false;
        if (authentic != null ? !authentic.equals(that.authentic) : that.authentic != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = corpId;
        result = 31 * result + (registrationNum != null ? registrationNum.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (representative != null ? representative.hashCode() : 0);
        result = 31 * result + (registeredAssets != null ? registeredAssets.hashCode() : 0);
        result = 31 * result + (setUpDate != null ? setUpDate.hashCode() : 0);
        result = 31 * result + (field != null ? field.hashCode() : 0);
        result = 31 * result + (registrationAuthority != null ? registrationAuthority.hashCode()
                : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (telNum != null ? telNum.hashCode() : 0);
        result = 31 * result + (webUrl != null ? webUrl.hashCode() : 0);
        result = 31 * result + (authentic != null ? authentic.hashCode() : 0);
        return result;
    }
}
