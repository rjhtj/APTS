package com.APTS.web.service;

import com.APTS.web.dao.InvitationcodeDao;
import com.APTS.web.entity.Invitationcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ruanjianhong on 2016/8/27.
 */
@Service
public class InvitationcodeService {
    @Autowired
    private InvitationcodeDao invitationcodeDao;

    public InvitationcodeDao getInvitationcodeDao() { return invitationcodeDao; }

    public void setInvitationcodeDao(InvitationcodeDao invitationcodeDao) { this.invitationcodeDao = invitationcodeDao; }

    public List<Invitationcode> getALLInvitationcode() {
        return invitationcodeDao.getALLInvitationcode();
    }

    /*根据用户查询邀请码*/
    public List<Invitationcode> getInvitationcodebyCreator(int creator){
        return invitationcodeDao.getInvitationcodebyCreator(creator);
    }

    public int addInvitationcode(Invitationcode invitationcode){
        return invitationcodeDao.addInvitationcode(invitationcode);
    }

    public void delInvitationcode(int id){
        invitationcodeDao.delInvitationcode(id);
    }

    public Invitationcode getInvitationcodeById(int id) {
        return invitationcodeDao.getInvitationcodeById(id);
    }

    public void updateInvitationcode(Invitationcode invitationcode){
        invitationcodeDao.updateInvitationcode(invitationcode);
    }
    public Invitationcode verify(String invitationCode){
        return invitationcodeDao.verify(invitationCode);
    }
}
