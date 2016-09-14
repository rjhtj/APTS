package com.APTS.web.dao;

import com.APTS.web.entity.PlantMethod;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Yu on 2016/8/15.
 */
@Repository
public class PlantMethodDao {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    /*查询所有生产方式*/
    public List<PlantMethod> getALLPlantMethod(){
        String hql = "from PlantMethod ";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        return query.list();
    }

    /*查询生产方式*/
    public PlantMethod getPlantMethodById(int plt_mth_id){
        String hql = "from PlantMethod where pltMthId=:plt_mth_id";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("plt_mth_id",plt_mth_id);
        return (PlantMethod)query.uniqueResult();
    }

    /*增加生产方式*/
    public int addPlantMethod(PlantMethod plantMethod){
        String hql = "select max(pltMthId) from PlantMethod ";
        Session session = sessionFactory.getCurrentSession();
        session.save(plantMethod);
        Query query = session.createQuery(hql);
        session.flush();
        int i = (Integer)query.uniqueResult();
        return i;
    }

    /*删除生产方式*/
    public void delPlantMethod(int plt_mth_id){
        String hql = "delete from PlantMethod where pltMthId=:plt_mth_id";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("plt_mth_id", plt_mth_id);
        int ret = query.executeUpdate();
    }

    /*更新生产信息*/
    public void updatePlantMethod(PlantMethod plantMethod){
        Session session = sessionFactory.getCurrentSession();
        session.merge(plantMethod);
        session.flush();
    }
}
