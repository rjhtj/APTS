package com.APTS.web.service;

import com.APTS.web.dao.DistributionDao;
import com.APTS.web.entity.Distribution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yu on 2016/8/16.
 */
@Service
public class DistributionService {
    @Autowired
    private  DistributionDao distributionDao;

    public DistributionDao getDistributionDao() { return distributionDao; }

    public void setDistributionDao(DistributionDao distributionDao) { this.distributionDao = distributionDao; }

    public List<Distribution> getALLDistribution() {
        return distributionDao.getALLDistribution();
    }

    public int addDistribution(Distribution distribution){
       return distributionDao.addDistribution(distribution);
    }

    public void delDistribution(int distribution_id){
        distributionDao.delDistribution(distribution_id);
    }

    public Distribution getDistributionById(int distribution_id) {
        return distributionDao.getDistributionById(distribution_id);
    }

    public void updateDistribution(Distribution distribution){
        distributionDao.updateDistribution(distribution);
    }
}
