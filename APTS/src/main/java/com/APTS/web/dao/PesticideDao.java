package com.APTS.web.dao;

import com.APTS.web.entity.Pesticide;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Yu on 2016/8/10.
 */
@Repository
public class PesticideDao {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    /*查询所有农药*/
    public List<Pesticide> getALLPesticide(){
        String hql = "from Pesticide ";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        return query.list();
    }

    /*查询农药*/
    public Pesticide getPesticideById(int pest_id){
        String hql = "from Pesticide where pestId=:pest_id";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("pest_id",pest_id);
        return (Pesticide)query.uniqueResult();
    }

    /*增加农药种类*/
    public int addPesticide(Pesticide pest){
        String hql = "select max(pestId) from Pesticide ";
        Session session = sessionFactory.getCurrentSession();
        session.save(pest);
        Query query = session.createQuery(hql);
        session.flush();
        int i = (Integer)query.uniqueResult();
        return i;
    }

    /*删除农药*/
    public void delPesticide(int pest_id){
        String hql = "delete from Pesticide where pestId=:pest_id";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("pest_id", pest_id);
        int ret = query.executeUpdate();
    }

    /*更新农药*/
    public void updatePesticide(Pesticide pesticide){
        Session session = sessionFactory.getCurrentSession();
        session.merge(pesticide);
        session.flush();
    }
}
