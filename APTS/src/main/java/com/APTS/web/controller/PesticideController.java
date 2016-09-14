package com.APTS.web.controller;

import com.APTS.web.entity.Pesticide;
import com.APTS.web.service.PesticideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.sql.Date;

/**
 * Created by Yu on 2016/8/15.
 */
@Controller
public class PesticideController {
    @Autowired
    private PesticideService pesticideService;

    @RequestMapping("/getAllPesticide.do")
    public String getAllPesticide(Model model){
        List<Pesticide> list = pesticideService.getALLPesticide();
        model.addAttribute("list",list);
        return "pesticide-list";
    }

    @RequestMapping("/addPesticide.do")
    public String addPesticide(@ModelAttribute Pesticide pesticide) {
        pesticideService.addPesticide(pesticide);
        return "redirect:/getAllPesticide.do";
    }

    @RequestMapping("/delPesticide.do")
    public String delPesticide(Integer id){
        pesticideService.delPesticide(id);
        return "redirect:/getAllPesticide.do";
    }

    @RequestMapping("/getPesticideById.do")
    public String getPesticideById(Integer id, Model model){
        Pesticide pesticide = pesticideService.getPesticideById(id);
        model.addAttribute("pesticide", pesticide);
        return "pesticide-update";
    }

    @RequestMapping("/updatePesticide.do/{pestId}")
    public  String updatePesticide(@ModelAttribute Pesticide pesticide, @PathVariable int pestId){
        pesticide.setPestId(pestId);
        pesticideService.updatePesticide(pesticide);
        return "redirect:/getAllPesticide.do";
    }

    @RequestMapping("/front/getPesticideById.do")
    public String getPesticideInfoById(Integer id, Model model){
        Pesticide pesticide = pesticideService.getPesticideById(id);
        model.addAttribute("Pesticide", pesticide);
        return "front/showPesInfo";
    }
}
