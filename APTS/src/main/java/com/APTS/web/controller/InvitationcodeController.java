package com.APTS.web.controller;

import com.APTS.web.entity.Admin;
import com.APTS.web.entity.CorporationInfo;
import com.APTS.web.entity.Invitationcode;
import com.APTS.web.service.AdminService;
import com.APTS.web.service.CorporationInfoService;
import com.APTS.web.service.InvitationcodeService;
import com.APTS.web.util.CodecUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Ruanjianhong on 2016/8/27.
 */
@Controller
public class InvitationcodeController {
    @Autowired
    private InvitationcodeService invitationcodeService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private CorporationInfoService corporationInfoService;

    @RequestMapping("/getAllInvitationcode.do")
    public String getAllInvitationcode(HttpServletRequest request,
                                       HttpServletResponse response,Model model){
        List<Invitationcode> list = new ArrayList<Invitationcode>();
        if((Integer)request.getSession().getAttribute("role")==0){
            list = invitationcodeService.getALLInvitationcode();
        }else {
            list = invitationcodeService.getInvitationcodebyCreator((Integer) request.getSession().getAttribute("id"));
        }
        List<Admin> adminlist = adminService.getAllAdmin();
        Map map1 = new HashMap();
        for(Admin admin:adminlist){
            map1.put(admin.getUserId(),admin.getUsername());
        }
        List<CorporationInfo> corplist = corporationInfoService.getALLCorporationInfo();
        Map map2 = new HashMap();
        for(CorporationInfo corporationInfo:corplist){
            map2.put(corporationInfo.getCorpId(),corporationInfo.getName());
        }
        model.addAttribute("list",list);
        model.addAttribute("map1", map1);
        model.addAttribute("map2", map2);
        return "invitationcode-list";
    }

    @RequestMapping("/toaddinvitationcode.do")
    public String toaddinvitationcode(HttpServletRequest request,
                                      HttpServletResponse response,Model model){
        Admin admin = adminService.getAdminById((Integer) request.getSession().getAttribute("id"));
        List<CorporationInfo> corplist = corporationInfoService.getALLCorporationInfo();
        model.addAttribute("user",admin);
        model.addAttribute("corplist",corplist);
        return "/invitationcode-add";
    }

    @RequestMapping("/addInvitationcode.do")
    public String addInvitationcode(HttpServletRequest request,
                                    HttpServletResponse response,int type, Integer corpId) {
        Date date = new Date();
        long code = date.getTime();
        String inv_code = CodecUtil.md5Hex(Long.toString(code));
        Integer creator = (Integer) request.getSession().getAttribute("id");
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd=sf.format(new Date());
        Timestamp timestamp = Timestamp.valueOf(sd);
        int corp_id;
        Invitationcode invitationcode = new Invitationcode();
        invitationcode.setInvitationCode(inv_code);
        invitationcode.setType(type);
        invitationcode.setIsdeleted(0);;
        invitationcode.setCreator(creator);
        invitationcode.setCreateTime(timestamp);
        if((Integer) request.getSession().getAttribute("role")==0){
            corp_id = corpId;
        }else{
            corp_id = adminService.getAdminById((Integer) request.getSession().getAttribute("id")).getCorpId();
        }
        invitationcode.setCorpId(corp_id);
        invitationcodeService.addInvitationcode(invitationcode);
        return "redirect:/getAllInvitationcode.do";
    }

    @RequestMapping("/delInvitationcode.do")
    public String delInvitationcode(Integer id){
        invitationcodeService.delInvitationcode(id);
        return "redirect:/getAllInvitationcode.do";
    }

    @RequestMapping("/getInvitationcodeById.do")
    public String getInvitationcodeById(Integer id, Model model){
        Invitationcode invitationcode = invitationcodeService.getInvitationcodeById(id);
        model.addAttribute("invitationcode", invitationcode);
        return "invitationcode-update";
    }

    @RequestMapping("/updateInvitationcode.do/{id}")
    public  String updateInvitationcode(@ModelAttribute Invitationcode invitationcode, @PathVariable int id){
        invitationcode.setId(id);
        invitationcodeService.updateInvitationcode(invitationcode);
        return "redirect:/getAllInvitationcode.do";
    }
}
