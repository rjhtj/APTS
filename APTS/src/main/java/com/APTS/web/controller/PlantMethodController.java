package com.APTS.web.controller;

import com.APTS.web.entity.PlantMethod;
import com.APTS.web.service.PlantMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.sql.Date;

/**
 * Created by Yu on 2016/8/15.
 */
@Controller
public class PlantMethodController {
    @Autowired
    private PlantMethodService plantMethodService;

    @RequestMapping("/getAllPlantMethod.do")
    public String getAllPlantMethod(Model model){
        List<PlantMethod> list = plantMethodService.getALLPlantMethod();
        model.addAttribute("plantMethodList",list);
        return "plantMethod-list";
    }

    @RequestMapping("/delPlantMethod.do")
    public String delPlantMethod(Integer id){
        plantMethodService.delPlantMethod(id);
        return "index";
    }

    @RequestMapping("/getPlantMethodById.do")
    public String getPlantMethodById(Integer id, Model model){
        PlantMethod plantMethod = plantMethodService.getPlantMethodById(id);
        //JLC
        String[] waterDate = plantMethod.getWaterDate().split(",");
        java.sql.Date[] WD = new java.sql.Date[waterDate.length];
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        for(int i = 0; i < waterDate.length; i++){
            try{
                java.util.Date temp = form.parse(waterDate[i]);
                WD[i] = new java.sql.Date(temp.getTime());
            }catch (ParseException e){
                e.printStackTrace();
            }
        }
        model.addAttribute("WaterDate", WD);
        model.addAttribute("PlantMethod", plantMethod);
        return "/front/showPlanMet";
    }
}
