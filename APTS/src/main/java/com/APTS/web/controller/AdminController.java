package com.APTS.web.controller;

import com.APTS.web.entity.Admin;
import com.APTS.web.entity.CorporationInfo;
import com.APTS.web.entity.Invitationcode;
import com.APTS.web.service.AdminService;
import com.APTS.web.service.CorporationInfoService;
import com.APTS.web.service.InvitationcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hwq on 2015/10/20.
 */
@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private CorporationInfoService corporationInfoService;
    @Autowired
    private InvitationcodeService invitationcodeService;

    @RequestMapping("/login.do")
    public String login(HttpServletRequest request,
                        HttpServletResponse response,String username,String password,Model model){
        Admin admin =adminService.login(username, password);
        if(admin == null) {
            JOptionPane.showMessageDialog(null,
                    "用户名或密码错误！", "提示信息", JOptionPane.ERROR_MESSAGE);
            return "login";
        }
        else {
            adminService.update(admin);
            HttpSession session = request.getSession();
            session.setAttribute("id",admin.getUserId());
            session.setAttribute("role",admin.getRole());
            model.addAttribute("admin", admin);
            return "home";
        }
    }

    @RequestMapping("/register.do")
    public String register(HttpServletRequest request,
                        HttpServletResponse response,String username,String password, String invitationcode, Model model, RedirectAttributes redirectAttributes){
        Admin user =adminService.verify(username);
        Invitationcode code_entity = invitationcodeService.verify(invitationcode);
        if(user != null) {
            JOptionPane.showMessageDialog(null,
                    "用户名不可用！", "提示信息", JOptionPane.ERROR_MESSAGE);
            return "register";
        }
        else if(code_entity==null){
            JOptionPane.showMessageDialog(null,
                    "邀请码不正确！", "提示信息", JOptionPane.ERROR_MESSAGE);
            return "register";
        }
        else {
            int ismanager;
            if(code_entity.getType()==0){
                ismanager = 1;
            } else ismanager = 0;

            Admin admin = new Admin();
            admin.setUsername(username);
            admin.setPassword(password);
            admin.setCorpId(code_entity.getCorpId());
            CorporationInfo corporationInfo = corporationInfoService.getCorporationInfoById(code_entity.getCorpId());
            admin.setRole(corporationInfo.getRole());
            admin.setIsmanager(ismanager);
            int id = adminService.addAdmin(admin);
            code_entity.setUser(id);
            code_entity.setIsdeleted(1);
            invitationcodeService.updateInvitationcode(code_entity);
            return "login";
        }
    }

    @RequestMapping("/getAllAdmin.do")
    public String getAllAdmin(HttpServletRequest request,
                              HttpServletResponse response, Model model){
        List<Admin> list = adminService.getAllAdmin();
        List<CorporationInfo> corplist = corporationInfoService.getALLCorporationInfo();
        Map map = new HashMap();
        for(CorporationInfo corporationInfo:corplist){
            map.put(corporationInfo.getCorpId(),corporationInfo.getName());
        }
        model.addAttribute("list", list);
        model.addAttribute("map", map);
        return "admin-list";
    }

    @RequestMapping(value = "/getAdminById.do", method = RequestMethod.GET)
    public String getAdminById(Integer id, Model model){
        Admin admin = adminService.getAdminById(id);
        CorporationInfo corporationInfo = corporationInfoService.getCorporationInfoById(admin
                .getCorpId());
        model.addAttribute("corporationInfo", corporationInfo);
        model.addAttribute("admin", admin);
        return "admin-information";
    }

    @RequestMapping(value = "/getusernameById.do")
    public String getusernameById(Integer id, Model model){
        Admin admin = adminService.getAdminById(id);
        model.addAttribute("admin", admin);
        return "change-password";
    }

    @RequestMapping("/changePassword.do")
    public String changePassword(Integer id,String username, String password,RedirectAttributes redirectAttributes){
        if(password!=null){
            adminService.changePassword(id, password);
        }
        redirectAttributes.addAttribute("username", username);
        redirectAttributes.addAttribute("password", password);
        return "redirect:/login.do";
    }

    @RequestMapping("/toaddAdmin.do")
    public String toaddAdmin(Model model){
        List<CorporationInfo> corplist = corporationInfoService.getALLCorporationInfo();
        model.addAttribute("corplist",corplist);
        return "admin-add";
    }

    @RequestMapping(value = "/addAdmin.do", method = RequestMethod.POST)
    public String addAdmin(String username, String password, Integer corpId,int ismanager){
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        admin.setCorpId(corpId);
        CorporationInfo corporationInfo = corporationInfoService.getCorporationInfoById(corpId);
        admin.setRole(corporationInfo.getRole());
        admin.setIsmanager(ismanager);
        adminService.addAdmin(admin);
        return "redirect:/getAllAdmin.do";
    }

    @RequestMapping("/delAdmin.do")
    public String delLeader(Integer id){
        adminService.delAdmin(id);
        return "redirect:/getAllAdmin.do";
    }

    @RequestMapping("/toupdateAdmin.do")
    public String toupdateAdmin(Model model, Integer id){
        Admin admin = adminService.getAdminById(id);
        CorporationInfo corporationInfo = corporationInfoService.getCorporationInfoById(admin.getCorpId());
        model.addAttribute("corporationInfo", corporationInfo);
        model.addAttribute("admin", admin);
        return "admin-update";
    }

    @RequestMapping("/updateAdmin.do")
    public  String updateAdmin(int userId, int selecttype){
        Admin admin = adminService.getAdminById(userId);
        if((admin.getIsmanager()+1)!=selecttype){
            if(selecttype==1){
                admin.setIsmanager(0);
            }else if(selecttype==2){
                admin.setIsmanager(1);
            }
            adminService.updateAdmin(admin);
        }
        return "redirect:/getAllAdmin.do";
    }
}
