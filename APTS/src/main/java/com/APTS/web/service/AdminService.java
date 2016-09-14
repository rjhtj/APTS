package com.APTS.web.service;

import com.APTS.web.dao.AdminDao;
import com.APTS.web.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.APTS.web.util.CodecUtil;
import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by hwq on 2015/10/20.
 */
@Service
public class AdminService {
    @Resource
    private AdminDao adminDao;

    public List<Admin> getAllAdmin(){
        return adminDao.getAllAdmin();
    }

    public int addAdmin(Admin admin){
        String password = CodecUtil.md5Hex(admin.getPassword());
        admin.setPassword(password);
        return adminDao.addAdmin(admin);
    }

    public void delAdmin(int id){
        adminDao.delAdmin(id);
    }

    public Admin getAdminById(int id){
        return adminDao.getAdminById(id);
    }

    public void changePassword(int id, String password){
        password = CodecUtil.md5Hex(password);
        adminDao.changePassword(id, password);
    }

    public Admin login(String username, String password){
        password = CodecUtil.md5Hex(password);
        Admin admin = adminDao.getadminbyUsername(username, password);
        return admin;
    }

    public Admin update(Admin admin){
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd=sf.format(new Date());
        Timestamp timestamp = Timestamp.valueOf(sd);
        admin.setLoginTime(timestamp);
        adminDao.update(admin);
        return admin;
    }

    public void updateAdmin(Admin admin){
        adminDao.updateAdmin(admin);
    }

    public Admin verify(String username){
        return adminDao.verify(username);
    }
}
