package com.APTS.web.dao;

import com.APTS.web.entity.Producer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

/**
 * Created by Yu on 2016/8/16.
 */
@Repository
public class ProducerDao {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    /*查询所有产源地信息*/
    public List<Producer> getALLProducer(){
        String hql = "from Producer ";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        return query.list();
    }

    /*查询产源地*/
    public Producer getProducerById(int producer_id){
        String hql = "from Producer where producerId=:producer_id";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("producer_id",producer_id);
        return (Producer)query.uniqueResult();
    }

    /*增加产源地信息*/
    public int addProducer(Producer producer){

        String hql = "select max(producerId) from Producer ";
        Session session = sessionFactory.getCurrentSession();
        session.save(producer);
        Query query = session.createQuery(hql);
        session.flush();
        int i = (Integer)query.uniqueResult();
        return i;
    }

    /*删除产源地信息*/
    public void delProducer(int producer_id){
        String hql = "delete from Producer where producerId=:producer_id";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("producer_id", producer_id);
        int ret = query.executeUpdate();
    }

    /*更新生产信息*/
    public void updateProducer(Producer producer){
        Session session = sessionFactory.getCurrentSession();
        session.merge(producer);
        session.flush();
    }

    /*搜索*/
    public List<Integer> search(Integer corp,Integer batch,Date logmin,Date logmax){
        String hql = "select producerId from Producer where producerId>=0 ";
        if(corp!=null && corp!=-1) {
            hql = hql + "and corpId=" + corp + " ";
        }
        if(batch!=null && batch!=-1) {
            hql = hql + "and batchNum=" + batch +" ";
        }
        if(logmin!=null){
            hql = hql + "and produceTime>='" + logmin +"' ";
        }
        if(logmax!=null){
                hql = hql + "and produceTime<='" + logmax +"' ";
            }


        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);

        return query.list();
    }
}
