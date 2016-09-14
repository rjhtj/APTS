package com.APTS.web.controller;

import com.APTS.web.entity.Detector;
import com.APTS.web.service.DetectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Ruanjianhong on 2016/8/27.
 */
@Controller
public class DetectorController {

    @Autowired
    private DetectorService detectorService;

    @RequestMapping("/getAllDetector.do")
    public String getAllDetector(Model model){
        List<Detector> list = detectorService.getALLDetector();
        model.addAttribute("list",list);
        return "detector-list";
    }

    @RequestMapping("/addDetector.do")
    public String addDetector(@ModelAttribute Detector detector) {
        detectorService.addDetector(detector);
        return "redirect:/getAllDetector.do";
    }

    @RequestMapping("/delDetector.do")
    public String delDetector(Integer id){
        detectorService.delDetector(id);
        return "redirect:/getAllDetector.do";
    }
    @RequestMapping("/getDetectorById.do")
    public String getDetectorById(Integer id, Model model){
        Detector detector = detectorService.getDetectorById(id);
        model.addAttribute("detector", detector);
        return "detector-update";
    }

    @RequestMapping("/updateDetector.do")
    public  String updateDetector(@ModelAttribute Detector detector){
        detectorService.updateDetector(detector);
        return "redirect:/getAllDetector.do";
    }
}
