package com.APTS.web.controller;

import com.APTS.web.entity.Producer;
import com.APTS.web.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.sql.Date;

/**
 * Created by Yu on 2016/8/16.
 */
@Controller
public class ProducerController {
    @Autowired
    private ProducerService producerService;

    @RequestMapping("/getAllProducer.do")
    public String getAllProducer(Model model){
        List<Producer> list = producerService.getALLProducer();
        model.addAttribute("producerList",list);
        return "producer-list";
    }

    @RequestMapping("/addProducer.do")
    public String addProducer(Integer corp_id, String producer_map, Date produce_time, Integer batch_num) {
        Producer producer = new Producer();
        producer.setCorpId(corp_id);
        producer.setProducerMap(producer_map);
        producer.setBatchNum(batch_num);
        producer.setProduceTime(produce_time);

        System.out.println(producer);
        producerService.addProducer(producer);
        return "index";
    }

    @RequestMapping("/delProducer.do")
    public String delProducer(Integer id){
        producerService.delProducer(id);
        return "index";
    }

    @RequestMapping("/getProducerById.do")
    public String getProducerById(Integer id, Model model){
        Producer producer = producerService.getProducerById(id);
        model.addAttribute("Producer", producer);
        return "front/showPlanter";
    }
}
