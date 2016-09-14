package com.APTS.web.service;

import com.APTS.web.dao.TransportDao;
import com.APTS.web.entity.Transport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yu on 2016/8/16.
 */
@Service
public class TransportService {
    @Autowired
    private  TransportDao transportDao;

    public TransportDao getTransportDao() { return transportDao; }

    public void setTransportDao(TransportDao transportDao) { this.transportDao = transportDao; }

    public List<Transport> getALLTransport() {
        return transportDao.getALLTransport();
    }

    public int addTransport(Transport transport){
        return transportDao.addTransport(transport);
    }

    public void delTransport(int transport_id){
        transportDao.delTransport(transport_id);
    }

    public Transport getTransportById(int transport_id) {
        return transportDao.getTransportById(transport_id);
    }
    public void updateTransport(Transport transport){
        transportDao.updateTransport(transport);
    }
}
