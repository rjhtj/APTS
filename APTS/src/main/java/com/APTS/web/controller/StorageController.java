package com.APTS.web.controller;

import com.APTS.web.entity.CorporationInfo;
import com.APTS.web.entity.Product;
import com.APTS.web.entity.Storage;
import com.APTS.web.service.CorporationInfoService;
import com.APTS.web.service.ProductService;
import com.APTS.web.service.StorageService;
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
 * Created by Yu on 2016/8/15.
 */
@Controller
public class StorageController {
    @Autowired
    private StorageService storageService;
    @Autowired
    private CorporationInfoService corporationInfoService;
    @Autowired
    private ProductService productService;

    @RequestMapping("/getAllStorage.do")
    public String getAllStorage(Model model){
        List<Storage> list = storageService.getALLStorage();
        model.addAttribute("storageList",list);
        return "storage-list";
    }

    @RequestMapping("/toaddStorage.do")
    public String toaddStorage(HttpServletRequest request, HttpServletResponse response, Model model,String list) {
        List<CorporationInfo> corporationInfoList = corporationInfoService.getCorporationInfobyrole(2);
        model.addAttribute("corporationInfoList",corporationInfoList);
        model.addAttribute("list",list);
        return "product-addstorage";
    }

    @RequestMapping("/addStorage.do")
        public String addStorage(HttpServletRequest request, HttpServletResponse response,
                                 @ModelAttribute Storage storage, String selectcorpName,int selectcorpId, String list) {
        int storId = storageService.addStorage(storage);
        String[] str = list.split(",");
        for(int i=0;i<str.length;i++){
            Product product = productService.getProductById(Integer.parseInt(str[i]));
            product.setStorageId(storId);
            product.setIsStored(1);
            productService.updateProduct(product);
        }
        return "redirect:/getAllProduct.do";
    }

    @RequestMapping("/delStorage.do")
    public String delStorage(Integer id){
        storageService.delStorage(id);
        return "index";
    }

    @RequestMapping("/getStorageById.do")
    public String getStorageById(Integer id, Model model){
        if(id != null){
            Storage storage = storageService.getStorageById(id);
            model.addAttribute("Storage", storage);
            return "front/showStoInfo";
        }
        else{
            return "front/empty";
        }
    }

    @RequestMapping("/updateProduct_storage.do/{productId}")
    public String updateProduct_storage(HttpServletRequest request, HttpServletResponse response,
                                        @ModelAttribute Storage storage, String selectstorcorpName, int selectstorcorpId,
                                        RedirectAttributes redirectAttributes, @PathVariable int productId){
        storageService.updateStorage(storage);
        redirectAttributes.addAttribute("id", productId);
        return "redirect:/getProductById.do";
    }
}
