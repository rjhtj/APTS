package com.APTS.web.vo;

import com.APTS.web.entity.*;

/**
 * Created by RuanJH on 2016/8/24.
 */
public class ProductVo {
    private Product product;
    private Producer producer;
    private Storage storage;
    private Transport transport;
    private Distribution distribution;
    private PlantMethod plantMethod;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public PlantMethod getPlantMethod() {
        return plantMethod;
    }

    public void setPlantMethod(PlantMethod plantMethod) {
        this.plantMethod = plantMethod;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Distribution getDistribution() {
        return distribution;
    }

    public void setDistribution(Distribution distribution) {
        this.distribution = distribution;
    }

}
