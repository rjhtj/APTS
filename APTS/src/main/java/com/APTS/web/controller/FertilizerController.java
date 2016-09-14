package com.APTS.web.controller;

import com.APTS.web.entity.Fertilizer;
import com.APTS.web.service.FertilizerService;
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
public class FertilizerController {
    @Autowired
    private FertilizerService fertilizerService;

    @RequestMapping("/getAllFertilizer.do")
    public String getAllFertilizer(Model model){
        List<Fertilizer> list = fertilizerService.getALLFertilizer();
        model.addAttribute("list",list);
        return "fertilizer-list";
    }

    @RequestMapping("/addFertilizer.do")
    public String addFertilizer(@ModelAttribute Fertilizer fertilizer) {
        fertilizerService.addFertilizer(fertilizer);
        return "redirect:/getAllFertilizer.do";
    }

    @RequestMapping("/delFertilizer.do")
    public String delFertilizer(Integer id){
        fertilizerService.delFertilizer(id);
        return "redirect:/getAllFertilizer.do";
    }
    @RequestMapping("/getFertilizerById.do")
    public String getFertilizerById(Integer id, Model model){
        Fertilizer fertilizer = fertilizerService.getFertilizerById(id);
        model.addAttribute("fertilizer", fertilizer);
        return "fertilizer-update";
    }

    @RequestMapping("/updateFertilizer.do/{fertId}")
    public  String updateFertilizer(@ModelAttribute Fertilizer fertilizer, @PathVariable int fertId){
        fertilizer.setFertId(fertId);
        fertilizerService.updateFertilizer(fertilizer);
        return "redirect:/getAllFertilizer.do";
    }

    @RequestMapping("/front/getFertilizerById.do")
    public String getFertilizerInfoById(Integer id, Model model){
        Fertilizer fertilizer = fertilizerService.getFertilizerById(id);
        model.addAttribute("Fertilizer", fertilizer);
        return "front/showFerInfo";
    }
}
