package com.APTS.web.service;

import com.APTS.web.dao.ProducerDao;
import com.APTS.web.entity.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yu on 2016/8/16.
 */
@Service
public class ProducerService {
    @Autowired
    private  ProducerDao producerDao;

    public ProducerDao getProducerDao() { return producerDao; }

    public void setProducerDao(ProducerDao producerDao) { this.producerDao = producerDao; }

    public List<Producer> getALLProducer() {
        return producerDao.getALLProducer();
    }

    public int addProducer(Producer producer){
        return producerDao.addProducer(producer);
    }

    public void delProducer(int producer_id){
        producerDao.delProducer(producer_id);
    }

    public Producer getProducerById(int producer_id) {
        return producerDao.getProducerById(producer_id);
    }

    public void updateProducer(Producer producer){
        producerDao.updateProducer(producer);
    }

}
