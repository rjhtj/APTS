package com.APTS.web.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by RuanJH on 2016/8/25.
 */
@Entity
public class Product {
    private int productId;

    @Id
    @javax.persistence.Column(name = "product_id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    private String name;

    @Basic
    @javax.persistence.Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String isIdentified;

    @Basic
    @javax.persistence.Column(name = "is_identified")
    public String getIsIdentified() {
        return isIdentified;
    }

    public void setIsIdentified(String isIdentified) {
        this.isIdentified = isIdentified;
    }

    private String brand;

    @Basic
    @javax.persistence.Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    private String seedSourProd;

    @Basic
    @javax.persistence.Column(name = "seed_sour_prod")
    public String getSeedSourProd() {
        return seedSourProd;
    }

    public void setSeedSourProd(String seedSourProd) {
        this.seedSourProd = seedSourProd;
    }

    private Date marketDate;

    @Basic
    @javax.persistence.Column(name = "market_date")
    public Date getMarketDate() {
        return marketDate;
    }

    public void setMarketDate(Date marketDate) {
        this.marketDate = marketDate;
    }

    private String isTransgene;

    @Basic
    @javax.persistence.Column(name = "is_transgene")
    public String getIsTransgene() {
        return isTransgene;
    }

    public void setIsTransgene(String isTransgene) {
        this.isTransgene = isTransgene;
    }

    private Date limitDate;

    @Basic
    @javax.persistence.Column(name = "limit_date")
    public Date getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(Date limitDate) {
        this.limitDate = limitDate;
    }

    private String varieties;

    @Basic
    @javax.persistence.Column(name = "varieties")
    public String getVarieties() {
        return varieties;
    }

    public void setVarieties(String varieties) {
        this.varieties = varieties;
    }

    private Integer plantMethodId;

    @Basic
    @javax.persistence.Column(name = "plant_method_id")
    public Integer getPlantMethodId() {
        return plantMethodId;
    }

    public void setPlantMethodId(Integer plantMethodId) {
        this.plantMethodId = plantMethodId;
    }

    private Integer producerId;

    @Basic
    @javax.persistence.Column(name = "producer_id")
    public Integer getProducerId() {
        return producerId;
    }

    public void setProducerId(Integer producerId) {
        this.producerId = producerId;
    }

    private Integer storageId;

    @Basic
    @javax.persistence.Column(name = "storage_id")
    public Integer getStorageId() {
        return storageId;
    }

    public void setStorageId(Integer storageId) {
        this.storageId = storageId;
    }

    private Integer transportId;

    @Basic
    @javax.persistence.Column(name = "transport_id")
    public Integer getTransportId() {
        return transportId;
    }

    public void setTransportId(Integer transportId) {
        this.transportId = transportId;
    }

    private Integer distributionId;

    @Basic
    @javax.persistence.Column(name = "distribution_id")
    public Integer getDistributionId() {
        return distributionId;
    }

    public void setDistributionId(Integer distributionId) {
        this.distributionId = distributionId;
    }

    private String identifier;

    @Basic
    @javax.persistence.Column(name = "identifier")
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    private Date produceTime;

    @Basic
    @javax.persistence.Column(name = "produce_time")
    public Date getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(Date produceTime) {
        this.produceTime = produceTime;
    }

    private Integer isProded;

    @Basic
    @javax.persistence.Column(name = "is_proded")
    public Integer getIsProded() {
        return isProded;
    }

    public void setIsProded(Integer isProded) {
        this.isProded = isProded;
    }

    private Integer isStored;

    @Basic
    @javax.persistence.Column(name = "is_stored")
    public Integer getIsStored() {
        return isStored;
    }

    public void setIsStored(Integer isStored) {
        this.isStored = isStored;
    }

    private Integer isTransed;

    @Basic
    @javax.persistence.Column(name = "is_transed")
    public Integer getIsTransed() {
        return isTransed;
    }

    public void setIsTransed(Integer isTransed) {
        this.isTransed = isTransed;
    }

    private Integer isDisted;

    @Basic
    @javax.persistence.Column(name = "is_disted")
    public Integer getIsDisted() {
        return isDisted;
    }

    public void setIsDisted(Integer isDisted) {
        this.isDisted = isDisted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productId != product.productId) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (isIdentified != null ? !isIdentified.equals(product.isIdentified) : product
                .isIdentified != null)
            return false;
        if (brand != null ? !brand.equals(product.brand) : product.brand != null) return false;
        if (seedSourProd != null ? !seedSourProd.equals(product.seedSourProd) : product
                .seedSourProd != null)
            return false;
        if (marketDate != null ? !marketDate.equals(product.marketDate) : product.marketDate !=
                null)
            return false;
        if (isTransgene != null ? !isTransgene.equals(product.isTransgene) : product.isTransgene
                != null)
            return false;
        if (limitDate != null ? !limitDate.equals(product.limitDate) : product.limitDate != null)
            return false;
        if (varieties != null ? !varieties.equals(product.varieties) : product.varieties != null)
            return false;
        if (plantMethodId != null ? !plantMethodId.equals(product.plantMethodId) : product
                .plantMethodId != null)
            return false;
        if (producerId != null ? !producerId.equals(product.producerId) : product.producerId !=
                null)
            return false;
        if (storageId != null ? !storageId.equals(product.storageId) : product.storageId != null)
            return false;
        if (transportId != null ? !transportId.equals(product.transportId) : product.transportId
                != null)
            return false;
        if (distributionId != null ? !distributionId.equals(product.distributionId) : product
                .distributionId != null)
            return false;
        if (identifier != null ? !identifier.equals(product.identifier) : product.identifier !=
                null)
            return false;
        if (produceTime != null ? !produceTime.equals(product.produceTime) : product.produceTime
                != null)
            return false;
        if (isProded != null ? !isProded.equals(product.isProded) : product.isProded != null)
            return false;
        if (isStored != null ? !isStored.equals(product.isStored) : product.isStored != null)
            return false;
        if (isTransed != null ? !isTransed.equals(product.isTransed) : product.isTransed != null)
            return false;
        if (isDisted != null ? !isDisted.equals(product.isDisted) : product.isDisted != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (isIdentified != null ? isIdentified.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (seedSourProd != null ? seedSourProd.hashCode() : 0);
        result = 31 * result + (marketDate != null ? marketDate.hashCode() : 0);
        result = 31 * result + (isTransgene != null ? isTransgene.hashCode() : 0);
        result = 31 * result + (limitDate != null ? limitDate.hashCode() : 0);
        result = 31 * result + (varieties != null ? varieties.hashCode() : 0);
        result = 31 * result + (plantMethodId != null ? plantMethodId.hashCode() : 0);
        result = 31 * result + (producerId != null ? producerId.hashCode() : 0);
        result = 31 * result + (storageId != null ? storageId.hashCode() : 0);
        result = 31 * result + (transportId != null ? transportId.hashCode() : 0);
        result = 31 * result + (distributionId != null ? distributionId.hashCode() : 0);
        result = 31 * result + (identifier != null ? identifier.hashCode() : 0);
        result = 31 * result + (produceTime != null ? produceTime.hashCode() : 0);
        result = 31 * result + (isProded != null ? isProded.hashCode() : 0);
        result = 31 * result + (isStored != null ? isStored.hashCode() : 0);
        result = 31 * result + (isTransed != null ? isTransed.hashCode() : 0);
        result = 31 * result + (isDisted != null ? isDisted.hashCode() : 0);
        return result;
    }
}
