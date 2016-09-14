package com.APTS.web.controller;

import com.APTS.web.entity.Certificate;
import com.APTS.web.entity.CorporationInfo;
import com.APTS.web.entity.Invitationcode;
import com.APTS.web.service.CertificateService;
import com.APTS.web.service.CorporationInfoService;
import com.APTS.web.service.InvitationcodeService;
import com.APTS.web.util.CodecUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Parameter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.sql.Date;

/**
 * Created by Yu on 2016/8/16.
 */
@Controller
public class CorporationInfoController {
    @Autowired
    private CorporationInfoService corporationInfoService;
    @Autowired
    private InvitationcodeService invitationcodeService;
    @Autowired
    private CertificateService certificateService;

    @RequestMapping("/getAllCorporationInfo.do")
    public String getAllCorporationInfo(int role, Model model){
        List<CorporationInfo> list = corporationInfoService.getALLbyRole(role);
        model.addAttribute("list",list);
        return "corporation-list";
    }

    @RequestMapping("/addCorpotation.do")
    public String addCorporationInfo(HttpServletRequest request,
                                     HttpServletResponse response,@ModelAttribute CorporationInfo corporationInfo, int corptype, @RequestParam("uploadfile") MultipartFile[] uploadfile, String[] filename, Model model) {
        corporationInfo.setRole(corptype);
        corporationInfo.setAuthentic(0);

        int corpId = corporationInfoService.addCorporationInfo(corporationInfo);
        ServletContext sc = request.getSession().getServletContext();
        // 上传位置
        String dir = sc.getRealPath("/files")+ "\\";
        File f = new File(dir);
        if (!f.exists())
            f.mkdirs();
        if(uploadfile!=null&&uploadfile.length>0){
            //循环获取uploadfile数组中得文件
            for(int i = 0;i<uploadfile.length;i++){
                MultipartFile file = uploadfile[i];
                String path = dir + file.getOriginalFilename();
                //保存文件
                saveFile(path, file);
                Certificate certificate = new Certificate();
                certificate.setCorpId(corpId);
                certificate.setName(filename[i]);
                certificate.setPath(path);
                certificateService.addCertificate(certificate);
            }
        }
        return "login";
    }

    private boolean saveFile(String path, MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(path)));
                stream.write(bytes);
                stream.close();
                return  true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    @RequestMapping("/delCorporationInfo.do")
    public String delCorporationInfo(Integer id, int role, RedirectAttributes redirectAttributes){
        corporationInfoService.delCorporationInfo(id);
        redirectAttributes.addAttribute("role", role);
        return "redirect:/getAllCorporationInfo.do";
    }

    @RequestMapping("/getCorporationInfoById.do")
    public String getCorporationInfoById(Integer id, Model model){
        CorporationInfo corporationInfo = corporationInfoService.getCorporationInfoById(id);
        List<Certificate> certificateList = certificateService.getCertificatesbyCorpId(id);
        model.addAttribute("certificateList", certificateList);
        model.addAttribute("corporationInfo", corporationInfo);
        return "corporation-information";
    }

    @RequestMapping("/authentic.do")
    public String authentic(HttpServletRequest request,
                            HttpServletResponse response, Integer id, int role, Model model,RedirectAttributes redirectAttributes){
        CorporationInfo corporationInfo = corporationInfoService.getCorporationInfoById(id);
        corporationInfo.setAuthentic(1);
        corporationInfoService.updateCorporationInfo(corporationInfo);

        java.util.Date date = new java.util.Date();
        long code = date.getTime();
        String inv_code = CodecUtil.md5Hex(Long.toString(code));
        Integer creator = (Integer) request.getSession().getAttribute("id");
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd=sf.format(new java.util.Date());
        Timestamp timestamp = Timestamp.valueOf(sd);
        Invitationcode invitationcode = new Invitationcode();
        invitationcode.setInvitationCode(inv_code);
        invitationcode.setType(1);
        invitationcode.setIsdeleted(0);;
        invitationcode.setCreator(creator);
        invitationcode.setCreateTime(timestamp);
        invitationcode.setCorpId(corporationInfo.getCorpId());
        invitationcodeService.addInvitationcode(invitationcode);
        redirectAttributes.addAttribute("role", role);
        return "redirect:/getAllCorporationInfo.do";
    }

    @RequestMapping("/toupdateCorpotation.do")
    public String toupdateCorpotation(HttpServletRequest request,
                                      HttpServletResponse response, int corpId, Model model){
        CorporationInfo corporationInfo = corporationInfoService.getCorporationInfoById(corpId);
        model.addAttribute("corporationInfo", corporationInfo);
        return "corporation-update";
    }

    @RequestMapping("/updateCorpotation.do")
    public String updateCorpotation(HttpServletRequest request,
                                      HttpServletResponse response,@ModelAttribute CorporationInfo corporationInfo, Model model){
        corporationInfo.setAuthentic(1);
        corporationInfoService.updateCorporationInfo(corporationInfo);
        model.addAttribute("corporationInfo", corporationInfo);
        return "corporation-update";
    }

    @RequestMapping("/front/getCorporationInfoById.do")
    public String getfrontCorporationInfoById(Integer id, Model model){
        CorporationInfo corporationInfo = corporationInfoService.getCorporationInfoById(id);
        model.addAttribute("CorporationInfo", corporationInfo);
        return "front/showCorporation";
    }
}
