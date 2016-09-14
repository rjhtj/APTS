package com.APTS.web.controller;

import com.APTS.web.entity.CorporationInfo;
import com.APTS.web.entity.Product;
import com.APTS.web.entity.Transport;
import com.APTS.web.service.CorporationInfoService;
import com.APTS.web.service.ProductService;
import com.APTS.web.service.TransportService;
import com.APTS.web.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.sql.Date;

/**
 * Created by Yu on 2016/8/16.
 */
@Controller
public class TransportController {
    @Autowired
    private TransportService transportService;
    @Autowired
    private CorporationInfoService corporationInfoService;
    @Autowired
    private ProductService productService;

    @RequestMapping("/getAllTransport.do")
    public String getAllTransport(Model model){
        List<Transport> list = transportService.getALLTransport();
        model.addAttribute("transportList",list);
        return "transport-list";
    }

    @RequestMapping("/toaddTransport.do")
    public String toaddTransport(HttpServletRequest request, HttpServletResponse response, Model model,String list) {
        List<CorporationInfo> corporationInfoList = corporationInfoService.getCorporationInfobyrole(3);
        model.addAttribute("corporationInfoList",corporationInfoList);
        model.addAttribute("list",list);
        return "product-addtransport";
    }

    @RequestMapping("/addTransport.do")
    public String addTransport(HttpServletRequest request, HttpServletResponse response,
                               @ModelAttribute Transport transport, String selectcorpName,int selectcorpId, String list) {
        int transId = transportService.addTransport(transport);
        String[] str = list.split(",");
        for(int i=0;i<str.length;i++){
            Product product = productService.getProductById(Integer.parseInt(str[i]));
            product.setTransportId(transId);
            product.setIsTransed(1);
            productService.updateProduct(product);
        }
        return "redirect:/getAllProduct.do";
    }

    @RequestMapping("/delTransport.do")
    public String delTransport(Integer id){
        transportService.delTransport(id);
        return "index";
    }

    @RequestMapping("/getTransportById.do")
    public String getTransportById(Integer id, Model model) {
        if(id != null){Transport transport = transportService.getTransportById(id);
        model.addAttribute("Transport", transport);
        return "front/showTraInfo";}
        else{
            return "front/empty";
        }
    }

    @RequestMapping("/updateProduct_transport.do/{productId}")
    public String updateProduct_transport(HttpServletRequest request, HttpServletResponse response,
                                          @ModelAttribute Transport transport, String selecttranscorpName, int selecttranscorpId,
                                          RedirectAttributes redirectAttributes, @PathVariable int productId){
        transportService.updateTransport(transport);
        redirectAttributes.addAttribute("id", productId);
        return "redirect:/getProductById.do";
    }
}
