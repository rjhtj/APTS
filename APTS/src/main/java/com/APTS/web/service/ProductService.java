package com.APTS.web.service;

import com.APTS.web.dao.ProducerDao;
import com.APTS.web.dao.ProductDao;
import com.APTS.web.dao.StorageDao;
import com.APTS.web.dao.TransportDao;
import com.APTS.web.entity.Producer;
import com.APTS.web.entity.Product;
import com.APTS.web.entity.Storage;
import com.APTS.web.entity.Transport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 * Created by Yu on 2016/8/16.
 */
@Service
public class ProductService {
    @Autowired
    private  ProductDao productDao;
    @Autowired
    private ProducerDao producerDao;
    @Autowired
    private StorageDao storageDao;
    @Autowired
    private TransportDao transportDao;

    public ProductDao getProductDao() { return productDao; }

    public void setProductDao(ProductDao productDao) { this.productDao = productDao; }

    public List<Product> getALLProduct(int all) {
        if(all==1){
            return productDao.getALLProduct();
        }
        else{
            return productDao.getProducts();
        }
    }
    public int addProduct(Product product){
        return productDao.addProduct(product);
    }

    public void delProduct(int product_id){
        productDao.delProduct(product_id);
    }

    public Product getProductById(int product_id) {
        return productDao.getProductById(product_id);
    }

    public void updateProduct(Product product){
        productDao.updateProduct(product);
    }

    /*搜索*/
    public List<Product> searchbyIden(String identifier){
        return productDao.searchbyIden(identifier);
    }

    public List<Product> search(int type,int corp,int batch,Date logmin,Date logmax){
        List<Integer> producerList = new ArrayList<Integer>();
        List<Integer> storageList = new ArrayList<Integer>();
        List<Integer> transportList = new ArrayList<Integer>();
        List<Product> productList = new ArrayList<Product>();
        if(type==1){
            producerList = producerDao.search(corp,batch,logmin,logmax);
            if(producerList!=null && !producerList.isEmpty()){
                productList = productDao.search1(producerList);
            }
        }
        if(type==2){
            storageList = storageDao.search(corp, batch, logmin, logmax);
            if(storageList!=null && !storageList.isEmpty()){
                productList = productDao.search2(storageList);
            }
        }
        if(type==3){
            transportList = transportDao.search(corp, batch, logmin, logmax);
            if(transportList!=null && !transportList.isEmpty()){
                productList = productDao.search3(transportList);
            }
        }
        return productList;
    }

    public Product getProductByIden(String identifier) {
        return productDao.getProductByIden(identifier);
    }

}
