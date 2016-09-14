package com.APTS.web.dao;

import com.APTS.web.entity.Certificate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ruanjianhong on 2016/8/27.
 */
@Repository
public class CertificateDao {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    public List<Certificate> getAllCertificates(){
        String hql = "from Certificate";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        return query.list();
    }

    /*查询证书*/
    public List<Certificate> getCertificatesbyCorpId(Integer corpId){
        String hql = "from Certificate where corpId=:corpId";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("corpId",corpId);
        return query.list();
    }

    public List<Certificate> getCertificatesbyProducerId(Integer producerId){
        String hql = "from Certificate where producerId=:producerId";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("producerId",producerId);
        return query.list();
    }

    /*查询证书*/
    public Certificate getCertificateById(int id){
        String hql = "from Certificate where certificateId=:id";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("id",id);
        return (Certificate)query.uniqueResult();
    }

    /*增加证书*/
    public int addCertificate(Certificate certificate){
        String hql = "select max(certificateId) from Certificate ";
        Session session = sessionFactory.getCurrentSession();
        session.clear();
        session.save(certificate);
        Query query = session.createQuery(hql);
        session.flush();
        int i = (Integer)query.uniqueResult();
        return i;
    }

    /*删除证书*/
    public void delCertificate(int id){
        String hql = "delete from Certificate where certificateId=:id";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        int ret = query.executeUpdate();
    }

    /*更新证书*/
    public void updateCertificate(Certificate certificate){
        Session session = sessionFactory.getCurrentSession();
        session.merge(certificate);
        session.flush();
    }
}
