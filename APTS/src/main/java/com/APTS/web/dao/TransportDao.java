package com.APTS.web.dao;

import com.APTS.web.entity.Transport;
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
public class TransportDao {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    /*查询所有流通信息*/
    public List<Transport> getALLTransport(){
        String hql = "from Transport ";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        return query.list();
    }

    /*查询流通信息*/
    public Transport getTransportById(int transport_id){
        String hql = "from Transport where transportId=:transport_id";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("transport_id",transport_id);
        return (Transport)query.uniqueResult();
    }

    /*增加流通信息*/
    public int addTransport(Transport transport){
        String hql = "select max(transportId) from Transport ";
        Session session = sessionFactory.getCurrentSession();
        session.save(transport);
        Query query = session.createQuery(hql);
        session.flush();
        int i = (Integer)query.uniqueResult();
        return i;
    }

    /*删除流通信息*/
    public void delTransport(int transport_id){
        String hql = "delete from Transport where transportId=:transport_id";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("transport_id", transport_id);
        int ret = query.executeUpdate();
    }

    /*更新存储信息*/
    public void updateTransport(Transport transport){
        Session session = sessionFactory.getCurrentSession();
        session.merge(transport);
        session.flush();
    }
    /*搜索*/
    public List<Integer> search(Integer corp,Integer batch,Date logmin,Date logmax){
        String hql = "select transportId from Transport where transportId>=0 ";
        if(corp!=null && corp!=-1) {
            hql = hql + "and corpId=" + corp + " ";
        }
        if(batch!=null && batch!=-1) {
            hql = hql + "and batchNum=" + batch +" ";
        }
        if(logmin!=null){
            hql = hql + "and transDate>='" + logmin +"' ";
        }
        if(logmax!=null){
            hql = hql + "and transDate<='" + logmax +"' ";
        }


        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);

        return query.list();
    }
}
