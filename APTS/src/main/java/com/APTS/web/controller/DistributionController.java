package com.APTS.web.controller;

import com.APTS.web.entity.CorporationInfo;
import com.APTS.web.entity.Product;
import com.APTS.web.service.CorporationInfoService;
import com.APTS.web.service.DistributionService;
import com.APTS.web.entity.Distribution;
import com.APTS.web.service.ProductService;
import com.APTS.web.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Yu on 2016/8/16.
 */
@Controller
public class DistributionController {
    @Autowired
    private DistributionService distributionService;
    @Autowired
    private CorporationInfoService corporationInfoService;
    @Autowired
    private ProductService productService;

    @RequestMapping("/getAllDistribution.do")
    public String getAllDistribution(Model model){
        List<Distribution> list = distributionService.getALLDistribution();
        model.addAttribute("distributionList",list);
        return "distribution-list";
    }

    @RequestMapping("/toaddDistribution.do")
    public String toaddDistribution(HttpServletRequest request, HttpServletResponse response, Model model,String list) {
        List<CorporationInfo> corporationInfoList = corporationInfoService.getCorporationInfobyrole(4);
        model.addAttribute("corporationInfoList",corporationInfoList);
        model.addAttribute("list",list);
        return "product-adddistribution";
    }

    @RequestMapping("/addDistribution.do")
    public String addDistribution(HttpServletRequest request, HttpServletResponse response,
                                  @ModelAttribute Distribution distribution, String selectcorpName,int selectcorpId, String list) {
        int distId = distributionService.addDistribution(distribution);
        String[] str = list.split(",");
        for(int i=0;i<str.length;i++){
            Product product = productService.getProductById(Integer.parseInt(str[i]));
            product.setDistributionId(distId);
            product.setIsDisted(1);
            productService.updateProduct(product);
        }
        return "redirect:/getAllProduct.do";
    }

    @RequestMapping("/delDistribution.do")
    public String delDistribution(Integer id){
        distributionService.delDistribution(id);
        return "index";
    }

    @RequestMapping("/getDistributionById.do")
    public String getDistributionById(Integer id, Model model){
        if(id != null){
            Distribution distribution = distributionService.getDistributionById(id);
            model.addAttribute("Distribution", distribution);
            return "front/showDisInfo";
        }
        else{
            return "front/empty";
        }

    }

    @RequestMapping("/updateProduct_distribution.do/{productId}")
    public String updateProduct_distribution(HttpServletRequest request, HttpServletResponse response,
                                             @ModelAttribute Distribution distribution, String selectdistcorpName, int selectdistcorpId,
                                             RedirectAttributes redirectAttributes, @PathVariable int productId){
        distributionService.updateDistribution(distribution);
        redirectAttributes.addAttribute("id", productId);
        return "redirect:/getProductById.do";
    }
}
