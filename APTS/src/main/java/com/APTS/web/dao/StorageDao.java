package com.APTS.web.dao;

import com.APTS.web.entity.Storage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

/**
 * Created by Yu on 2016/8/15.
 */
@Repository
public class StorageDao {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    /*查询所有存储信息*/
    public List<Storage> getALLStorage(){
        String hql = "from Storage ";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        return query.list();
    }

    /*查询存储信息*/
    public Storage getStorageById(int storage_id){
        String hql = "from Storage where storageId=:storage_id";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("storage_id",storage_id);
        return (Storage)query.uniqueResult();
    }

    /*增加存储信息种类*/
    public int addStorage(Storage storage){
        String hql = "select max(storageId) from Storage ";
        Session session = sessionFactory.getCurrentSession();
        session.save(storage);
        Query query = session.createQuery(hql);
        session.flush();
        int i = (Integer)query.uniqueResult();
        return i;
    }

    /*删除存储信息*/
    public void delStorage(int storage_id){
        String hql = "delete from Storage where storageId=:storage_id";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("storage_id", storage_id);
        int ret = query.executeUpdate();
    }

    /*更新存储信息*/
    public void updateStorage(Storage storage){
        Session session = sessionFactory.getCurrentSession();
        session.merge(storage);
        session.flush();
    }
    /*搜索*/
    public List<Integer> search(Integer corp,Integer batch,Date logmin,Date logmax){
        String hql = "select storageId from Storage where storageId>=0 ";
        if(corp!=null && corp!=-1) {
            hql = hql + "and corpId=" + corp + " ";
        }
        if(batch!=null && batch!=-1) {
            hql = hql + "and batchNum=" + batch +" ";
        }
        if(logmin!=null){
            hql = hql + "and storeTime>='" + logmin +"' ";
        }
        if(logmax!=null){
            hql = hql + "and storeTime<='" + logmax +"' ";
        }


        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        return query.list();
    }
}
