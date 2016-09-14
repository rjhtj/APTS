package com.APTS.web.dao;

import com.APTS.web.entity.CorporationInfo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Yu on 2016/8/16.
 */
@Repository
public class CorporationInfoDao {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    /*查询所有公司*/
    public List<CorporationInfo> getALL(){
        String hql = "from CorporationInfo";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        return query.list();
    }

    public List<CorporationInfo> getALLbyRole(int role) {
        String hql = "from CorporationInfo where role=:role";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("role",role);
        return query.list();
    }

    /*查询所有认证公司*/
    public List<CorporationInfo> getALLCorporationInfo(){
        String hql = "from CorporationInfo where authentic=1";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        return query.list();
    }
    /*根据类型查找公司*/
    public List<CorporationInfo> getCorporationInfobyrole(int role) {
        String hql = "from CorporationInfo where role=:role and authentic=1";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("role",role);
        return query.list();
    }

    /*查询公司*/
    public CorporationInfo getCorporationInfoById(int corp_id){
        String hql = "from CorporationInfo where corpId=:corp_id";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("corp_id",corp_id);
        return (CorporationInfo)query.uniqueResult();
    }

    /*增加公司种类*/
    public int addCorporationInfo(CorporationInfo corp){
        String hql = "select max(corpId) from CorporationInfo ";
        Session session = sessionFactory.getCurrentSession();
        session.save(corp);
        Query query = session.createQuery(hql);
        session.flush();
        int i = (Integer)query.uniqueResult();
        return i;
    }

    /*删除公司*/
    public void delCorporationInfo(int corp_id){
        String hql = "delete from CorporationInfo where corpId=:corp_id";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("corp_id", corp_id);
        int ret = query.executeUpdate();
    }

    /*更新公司信息*/
    public void updateCorporationInfo(CorporationInfo corporationInfo){
        Session session = sessionFactory.getCurrentSession();
        session.merge(corporationInfo);
        session.flush();
    }

}
