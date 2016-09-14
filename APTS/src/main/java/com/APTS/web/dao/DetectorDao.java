package com.APTS.web.dao;

import com.APTS.web.entity.Detector;
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
public class DetectorDao {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    /*查询所有检测机构*/
    public List<Detector> getALLDetector(){
        String hql = "from Detector ";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        return query.list();
    }

    /*查询检测机构*/
    public Detector getDetectorById(int id){
        String hql = "from Detector where detectorId=:id";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("id",id);
        return (Detector)query.uniqueResult();
    }

    /*增加检测机构*/
    public int addDetector(Detector detector){
        String hql = "select max(detectorId) from Detector ";
        Session session = sessionFactory.getCurrentSession();
        session.save(detector);
        Query query = session.createQuery(hql);
        session.flush();
        int i = (Integer)query.uniqueResult();
        return i;
    }

    /*删除检测机构*/
    public void delDetector(int id){
        String hql = "delete from Detector where detectorId=:id";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        int ret = query.executeUpdate();
    }

    /*更新检测机构*/
    public void updateDetector(Detector detector){
        Session session = sessionFactory.getCurrentSession();
        session.merge(detector);
        session.flush();
    }

}
