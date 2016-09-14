package com.APTS.web.dao;

import com.APTS.web.entity.Admin;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hwq on 2015/10/20.
 */
@Repository
public class AdminDao {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /*查询所有管理员*/
    public List<Admin> getAllAdmin(){
        String hql ="from Admin";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        /*System.out.print(query.list());*/
        return query.list();
    }

    /*查询管理员*/
    public Admin getAdminById(int id){
        String hql ="from Admin where userId=:id";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("id",id);
        /*System.out.print(query.list());*/
        return (Admin)query.uniqueResult();
    }

    /*修改密码*/
    public void changePassword(int id, String password){
        String hql ="update Admin admin set admin.password=:password  where admin.userId=:id";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("id",id);
        query.setParameter("password", password);
        /*System.out.print(query.list());*/
        int ret = query.executeUpdate();
    }


    /*增加管理员*/
    public int addAdmin(Admin admin){
        String hql = "select max(userId) from Admin";
        Session session = sessionFactory.getCurrentSession();
        session.save(admin);
        Query query = session.createQuery(hql);
        session.flush();
        int i = (Integer)query.uniqueResult();
        return i;
    }


    /*删除管理员*/
    public void delAdmin(int id){
        String hql = "delete from Admin where userId=:id";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        int ret = query.executeUpdate();
    }

    public  Admin getadminbyUsername(String username, String password) {
        String hql = "from Admin where username=:username and password=:password";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return (Admin)query.uniqueResult();
    }

    public void update(Admin admin){
        String hql ="update Admin admin set admin.loginTime=:loginTime  where admin.userId=:id";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("id",admin.getUserId());
        query.setParameter("loginTime", admin.getLoginTime());
        /*System.out.print(query.list());*/
        int ret = query.executeUpdate();
    }

    public void updateAdmin(Admin admin){
        Session session = sessionFactory.getCurrentSession();
        session.merge(admin);
        session.flush();
    }

    public Admin verify(String username){
        String hql ="from Admin where username=:username";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("username", username);
        return (Admin)query.uniqueResult();
    }
}
