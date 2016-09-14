package com.APTS.web.dao;

import com.APTS.web.entity.Fertilizer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Yu on 2016/8/9.
 */
@Repository
public class FertilizerDao {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    /*查询所有肥料*/
    public List<Fertilizer> getALLFertilizer(){
        String hql = "from Fertilizer ";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        return query.list();
    }

    /*查询化肥*/
    public Fertilizer getFertilizerById(int fert_id){
        String hql = "from Fertilizer where fertId=:fert_id";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("fert_id",fert_id);
        return (Fertilizer)query.uniqueResult();
    }

    /*增加化肥种类*/
    public int addFertilizer(Fertilizer fert){
        String hql = "select max(fertId) from Fertilizer ";
        Session session = sessionFactory.getCurrentSession();
        session.save(fert);
        Query query = session.createQuery(hql);
        session.flush();
        int i = (Integer)query.uniqueResult();
        return i;
    }

    /*删除化肥*/
    public void delFertilizer(int fert_id){
        String hql = "delete from Fertilizer where fertId=:fert_id";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("fert_id", fert_id);
        int ret = query.executeUpdate();
    }

    /*更新化肥*/
    public void updateFertilizer(Fertilizer fertilizer){
        Session session = sessionFactory.getCurrentSession();
        session.merge(fertilizer);
        session.flush();
    }

}
