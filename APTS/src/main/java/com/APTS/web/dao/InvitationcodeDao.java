package com.APTS.web.dao;

import com.APTS.web.entity.Invitationcode;
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
public class InvitationcodeDao {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }
    
    /*查询所有邀请码*/
    public List<Invitationcode> getALLInvitationcode(){
        String hql = "from Invitationcode where isdeleted=0";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        return query.list();
    }

    /*根据用户查询邀请码*/
    public List<Invitationcode> getInvitationcodebyCreator(int creator){
        String hql = "from Invitationcode where isdeleted=0 and creator=:creator";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("creator",creator);
        return query.list();
    }

    /*查询邀请码*/
    public Invitationcode getInvitationcodeById(int id){
        String hql = "from Invitationcode where id=:id";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("id",id);
        return (Invitationcode)query.uniqueResult();
    }

    /*增加邀请码*/
    public int addInvitationcode(Invitationcode invitationcode){
        String hql = "select max(id) from Invitationcode ";
        Session session = sessionFactory.getCurrentSession();
        session.save(invitationcode);
        Query query = session.createQuery(hql);
        session.flush();
        int i = (Integer)query.uniqueResult();
        return i;
    }

    /*删除邀请码*/
    public void delInvitationcode(int id){
        String hql = "update Invitationcode SET isdeleted=1 where id=:id";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        int ret = query.executeUpdate();
    }

    /*更新邀请码*/
    public void updateInvitationcode(Invitationcode invitationcode){
        Session session = sessionFactory.getCurrentSession();
        session.merge(invitationcode);
        session.flush();
    }

    public Invitationcode verify(String invitationCode){
        String hql ="from Invitationcode where invitationCode=:invitationCode and isdeleted=0";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("invitationCode", invitationCode);
        return (Invitationcode)query.uniqueResult();
    }
}
