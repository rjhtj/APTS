package com.APTS.web.service;

import com.APTS.web.dao.CorporationInfoDao;
import com.APTS.web.entity.CorporationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yu on 2016/8/16.
 */
@Service
public class CorporationInfoService {
    @Autowired
    private  CorporationInfoDao corporationInfoDao;

    public CorporationInfoDao getCorporationInfoDao() { return corporationInfoDao; }

    public void setCorporationInfoDao(CorporationInfoDao corporationInfoDao) { this.corporationInfoDao = corporationInfoDao; }

    public List<CorporationInfo> getALL(){
        return corporationInfoDao.getALL();
    }

    public List<CorporationInfo> getALLbyRole(int role) {
        return corporationInfoDao.getALLbyRole(role);
    }

    public List<CorporationInfo> getALLCorporationInfo() {
        return corporationInfoDao.getALLCorporationInfo();
    }

    public List<CorporationInfo> getCorporationInfobyrole(int role) {
        return corporationInfoDao.getCorporationInfobyrole(role);
    }

    public int addCorporationInfo(CorporationInfo corporationInfo){
        return corporationInfoDao.addCorporationInfo(corporationInfo);
    }

    public void delCorporationInfo(int corp_id){
        corporationInfoDao.delCorporationInfo(corp_id);
    }

    public CorporationInfo getCorporationInfoById(int corp_id) {
        return corporationInfoDao.getCorporationInfoById(corp_id);
    }

    public void updateCorporationInfo(CorporationInfo corporationInfo){
        corporationInfoDao.updateCorporationInfo(corporationInfo);
    }
}
