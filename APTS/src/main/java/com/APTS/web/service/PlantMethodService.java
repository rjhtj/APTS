package com.APTS.web.service;

import com.APTS.web.dao.PlantMethodDao;
import com.APTS.web.entity.PlantMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yu on 2016/8/15.
 */
@Service
public class PlantMethodService {
    @Autowired
    private  PlantMethodDao plantMethodDao;

    public PlantMethodDao getPlantMethodDao() { return plantMethodDao; }

    public void setPlantMethodDao(PlantMethodDao plantMethodDao) { this.plantMethodDao = plantMethodDao; }

    public List<PlantMethod> getALLPlantMethod() {
        return plantMethodDao.getALLPlantMethod();
    }

    public int addPlantMethod(PlantMethod plantMethod){
       return plantMethodDao.addPlantMethod(plantMethod);
    }

    public void delPlantMethod(int plt_mth_id){
        plantMethodDao.delPlantMethod(plt_mth_id);
    }

    public PlantMethod getPlantMethodById(int plt_mth_id) {
        return plantMethodDao.getPlantMethodById(plt_mth_id);
    }
    public void updatePlantMethod(PlantMethod plantMethod){
        plantMethodDao.updatePlantMethod(plantMethod);
    }
}
