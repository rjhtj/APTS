package com.APTS.web.service;

import com.APTS.web.dao.PesticideDao;
import com.APTS.web.entity.Pesticide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yu on 2016/8/10.
 */
@Service
public class PesticideService {
    @Autowired
    private  PesticideDao pesticideDao;

    public PesticideDao getPesticideDao() { return pesticideDao; }

    public void setPesticideDao(PesticideDao pesticideDao) { this.pesticideDao = pesticideDao; }

    public List<Pesticide> getALLPesticide() {
        return pesticideDao.getALLPesticide();
    }

    public int addPesticide(Pesticide pesticide){
        return pesticideDao.addPesticide(pesticide);
    }

    public void delPesticide(int pest_id){
        pesticideDao.delPesticide(pest_id);
    }

    public Pesticide getPesticideById(int pest_id) {
        return pesticideDao.getPesticideById(pest_id);
    }

    public void updatePesticide(Pesticide pesticide){
        pesticideDao.updatePesticide(pesticide);
    }
}
