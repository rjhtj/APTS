package com.APTS.web.service;

import com.APTS.web.dao.DetectorDao;
import com.APTS.web.dao.DistributionDao;
import com.APTS.web.entity.Detector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ruanjianhong on 2016/8/27.
 */
@Service
public class DetectorService {

    @Autowired
    private DetectorDao detectorDao;

    public DetectorDao getDetectorDao() { return detectorDao; }

    public void setDetectorDao(DetectorDao detectorDao) { this.detectorDao = detectorDao; }

    public List<Detector> getALLDetector() {
        return detectorDao.getALLDetector();
    }

    public int addDetector(Detector detector){
        return detectorDao.addDetector(detector);
    }

    public void delDetector(int id){
        detectorDao.delDetector(id);
    }

    public Detector getDetectorById(int id) {
        return detectorDao.getDetectorById(id);
    }

    public void updateDetector(Detector detector){
        detectorDao.updateDetector(detector);
    }

}
