package com.APTS.web.service;

import com.APTS.web.dao.StorageDao;
import com.APTS.web.entity.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yu on 2016/8/15.
 */
@Service
public class StorageService {
    @Autowired
    private  StorageDao storageDao;

    public StorageDao getStorageDao() { return storageDao; }

    public void setStorageDao(StorageDao storageDao) { this.storageDao = storageDao; }

    public List<Storage> getALLStorage() {
        return storageDao.getALLStorage();
    }

    public int addStorage(Storage storage){
        return storageDao.addStorage(storage);
    }

    public void delStorage(int storage_id){
        storageDao.delStorage(storage_id);
    }

    public Storage getStorageById(int storage_id) {
        return storageDao.getStorageById(storage_id);
    }

    public void updateStorage(Storage storage){
        storageDao.updateStorage(storage);
    }
}
