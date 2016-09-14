package com.APTS.web.dao;

import com.APTS.web.entity.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yu on 2016/8/16.
 */
@Repository
public class ProductDao {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    /*查询所有产源地信息*/
    public List<Product> getALLProduct(){
        String hql = "from Product";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        return query.list();
    }

    /*查询未完成产品*/
    public List<Product> getProducts(){
        String hql = "from Product where isDisted=0";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        return query.list();
    }

    /*查询产源地*/
    public Product getProductById(int product_id){
        String hql = "from Product where productId=:product_id";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("product_id",product_id);
        Product product = (Product)query.uniqueResult();
        return product;
    }

    /*增加产源地信息*/
    public int addProduct(Product product){
        String hql = "select max(productId) from Product ";
        Session session = sessionFactory.getCurrentSession();
        session.clear();
        session.save(product);
        Query query = session.createQuery(hql);
        session.flush();
        int i = (Integer)query.uniqueResult();
        return i;
    }

    /*删除产源地信息*/
    public void delProduct(int product_id){
        String hql = "delete from Product where productId=:product_id";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("product_id", product_id);
        int ret = query.executeUpdate();
    }

    /*更新产品信息*/
    public void updateProduct(Product product){
        Session session = sessionFactory.getCurrentSession();
        session.merge(product);
        session.flush();
    }

    /*搜索*/
    public List<Product> searchbyIden(String identifier){
        String hql = "from Product where identifier=:identifier";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("identifier", identifier);
        return query.list();
    }

    /*搜索*/
    public List<Product> search1(List<Integer> list){
        String hql = "from Product";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        if(list!=null && !list.isEmpty()){
            hql = "from Product where producerId in(:list) and isDisted=0";
            query = session.createQuery(hql);
            query.setParameterList("list", list);
        }
        return query.list();
    }
    public List<Product> search2(List<Integer> list){
        String hql = "from Product";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        if(list!=null && !list.isEmpty()){
            hql = "from Product where storageId in(:list) and isDisted=0";
            query = session.createQuery(hql);
            query.setParameterList("list", list);
        }
        return query.list();
    }
    public List<Product> search3(List<Integer> list){
        String hql = "from Product";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        if(list!=null && !list.isEmpty()){
            hql = "from Product where transportId in(:list) and isDisted=0";
            query = session.createQuery(hql);
            query.setParameterList("list", list);
        }
        return query.list();
    }

    /*序列号查询*/
    public Product getProductByIden(String identifier) {
        String hql = "from Product where identifier=:identifier";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("identifier",identifier);
        Product product = (Product)query.uniqueResult();
        return product;
    }
}
