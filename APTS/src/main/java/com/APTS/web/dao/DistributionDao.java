package com.APTS.web.dao;

import com.APTS.web.entity.Distribution;
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
public class DistributionDao {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    /*查询所有经销信息*/
    public List<Distribution> getALLDistribution(){
        String hql = "from Distribution ";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        return query.list();
    }

    /*查询经销信息*/
    public Distribution getDistributionById(int distribution_id){
        String hql = "from Distribution where distributionId=:distribution_id";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("distribution_id",distribution_id);
        return (Distribution)query.uniqueResult();
    }

    /*增加经销信息种类*/
    public int addDistribution(Distribution distribution){
        String hql = "select max(distributionId) from Distribution ";
        Session session = sessionFactory.getCurrentSession();
        session.save(distribution);
        Query query = session.createQuery(hql);
        session.flush();
        int i = (Integer)query.uniqueResult();
        return i;
    }

    /*删除经销信息*/
    public void delDistribution(int distribution_id){
        String hql = "delete from Distribution where distributionId=:distribution_id";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("distribution_id", distribution_id);
        int ret = query.executeUpdate();
    }

    /*更新公司信息*/
    public void updateDistribution(Distribution distribution){
        Session session = sessionFactory.getCurrentSession();
        session.merge(distribution);
        session.flush();
    }
}
