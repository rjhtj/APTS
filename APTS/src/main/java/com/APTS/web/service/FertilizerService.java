package com.APTS.web.service;

import com.APTS.web.dao.FertilizerDao;
import com.APTS.web.entity.Fertilizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yu on 2016/8/9.
 */
@Service
public class FertilizerService {
    @Autowired
    private  FertilizerDao fertilizerDao;

    public FertilizerDao getFertilizerDao() { return fertilizerDao; }

    public void setFertilizerDao(FertilizerDao fertilizerDao) { this.fertilizerDao = fertilizerDao; }

    public List<Fertilizer> getALLFertilizer() {
        return fertilizerDao.getALLFertilizer();
    }

    public int addFertilizer(Fertilizer fertilizer){
        return fertilizerDao.addFertilizer(fertilizer);
    }

    public void delFertilizer(int fert_id){
        fertilizerDao.delFertilizer(fert_id);
    }

    public Fertilizer getFertilizerById(int fert_id) {
        return fertilizerDao.getFertilizerById(fert_id);
    }

    public void updateFertilizer(Fertilizer fertilizer){
        fertilizerDao.updateFertilizer(fertilizer);
    }

}
