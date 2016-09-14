package com.APTS.web.controller;

import com.APTS.web.entity.Certificate;
import com.APTS.web.entity.CorporationInfo;
import com.APTS.web.entity.Detector;
import com.APTS.web.service.CertificateService;
import com.APTS.web.service.CorporationInfoService;
import com.APTS.web.service.DetectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ruanjianhong on 2016/8/27.
 */
@Controller
public class CertificateController {
    @Autowired
    private CertificateService certificateService;
    @Autowired
    private DetectorService detectorService;
    @Autowired
    private CorporationInfoService corporationInfoService;

    @RequestMapping("/getFilesbyCorpId.do")
    public String getFilesbyCorpId(HttpServletRequest request, HttpServletResponse response,Integer corpId,Model model){
        List<Certificate> certificateList = new ArrayList<Certificate>();
        if(corpId!=null){
            certificateList = certificateService.getCertificatesbyCorpId(corpId);
        }else if((Integer)request.getSession().getAttribute("role")==0){
            certificateList = certificateService.getAllCertificates();
        }
        List<CorporationInfo> corplist = corporationInfoService.getALLCorporationInfo();
        Map map = new HashMap();
        for(CorporationInfo corporationInfo:corplist){
            map.put(corporationInfo.getCorpId(),corporationInfo.getName());
        }
        model.addAttribute("list",certificateList);
        model.addAttribute("corpId",corpId);
        model.addAttribute("map",map);
        model.addAttribute("role",request.getSession().getAttribute("role"));
        return "file-list";
    }

    @RequestMapping("/touploadCertificate.do")
    public String touploadCertificate(int corpId,Model model){
        List<Detector> detectorList = detectorService.getALLDetector();
        model.addAttribute("list",detectorList);
        model.addAttribute("corpId",corpId);
        return "file-upload";
    }
}
