package com.APTS.web.service;

import com.APTS.web.dao.CertificateDao;
import com.APTS.web.entity.Certificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Ruanjianhong on 2016/8/27.
 */
@Service
public class CertificateService {
    @Autowired
    private CertificateDao certificateDao;

    public CertificateDao getCertificateDao() { return certificateDao; }

    public void setCertificateDao(CertificateDao certificateDao) { this.certificateDao = certificateDao; }

    public List<Certificate> getCertificatesbyCorpId(Integer corpId){
        return certificateDao.getCertificatesbyCorpId(corpId);
    }

    public List<Certificate> getCertificatesbyProducerId(Integer producerId){
        return certificateDao.getCertificatesbyProducerId(producerId);
    }

    public List<Certificate> getAllCertificates(){
        return certificateDao.getAllCertificates();
    }

    public int addCertificate(Certificate certificate){
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd=sf.format(new Date());
        Timestamp timestamp = Timestamp.valueOf(sd);
        certificate.setUploadDate(timestamp);
        return certificateDao.addCertificate(certificate);
    }

    public void delCertificate(int id){
        certificateDao.delCertificate(id);
    }

    public Certificate getCertificateById(int id) {
        return certificateDao.getCertificateById(id);
    }

    public void updateCertificate(Certificate certificate){
        certificateDao.updateCertificate(certificate);
    }
}
