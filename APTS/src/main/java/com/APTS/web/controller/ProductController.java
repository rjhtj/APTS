package com.APTS.web.controller;

import com.APTS.web.entity.*;
import com.APTS.web.service.*;
import com.APTS.web.vo.ProductVo;
import com.APTS.web.vo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.*;
import java.util.*;
import java.util.List;
import java.util.Date;

/**
 * Created by Yu on 2016/8/16.
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private PlantMethodService plantMethodService;
    @Autowired
    private ProducerService producerService;
    @Autowired
    private StorageService storageService;
    @Autowired
    private TransportService transportService;
    @Autowired
    private DistributionService distributionService;
    @Autowired
    private PesticideService pesticideService;
    @Autowired
    private FertilizerService fertilizerService;
    @Autowired
    private CorporationInfoService corporationInfoService;
    @Autowired
    private CertificateService certificateService;
    @RequestMapping("/getAllProduct.do")
    public String getAllProduct(HttpServletRequest request,
                                HttpServletResponse response, int all,Model model){
        List<Product> productList = productService.getALLProduct(all);
        model.addAttribute("role", request.getSession().getAttribute("role"));
        model.addAttribute("productList", productList);
        model.addAttribute("all", all);
        return "product-list";
    }

    @RequestMapping("/getCorporationInfobyrole.do/{role}")
    public @ResponseBody Map<String,Object> getCorporationInfobyrole(@PathVariable("role") int role){
        List<CorporationInfo> corporationInfoList = corporationInfoService.getCorporationInfobyrole(role);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("data", corporationInfoList);
        return result;
    }

    @RequestMapping("/toaddProduct.do")
    public String toaddProduct(HttpServletRequest request, HttpServletResponse response, Model model) {
        List<Pesticide> pesticideList = pesticideService.getALLPesticide();
        List<Fertilizer> fertilizerList = fertilizerService.getALLFertilizer();
        List<CorporationInfo> corporationInfoList = corporationInfoService.getCorporationInfobyrole(1);
        model.addAttribute("pesticideList", pesticideList);
        model.addAttribute("fertilizerList", fertilizerList);
        model.addAttribute("corporationInfoList", corporationInfoList);
        return "product-add";
    }

    @RequestMapping("/addProduct.do")
    public String addProduct(HttpServletRequest request, HttpServletResponse response,
                             @ModelAttribute ProductVo productVo, @RequestParam("waterDate") java.sql.Date[] waterDate, String selectcorpName,String selectpestName,String selectfertName,
                             int selectcorpId,int selectpestId,int selectfertId, int amount, RedirectAttributes redirectAttributes) {
        if(amount>=0){
            for(int x = 0; x<amount; x++) {
                Product product = productVo.getProduct();
                Producer producer = productVo.getProducer();
                PlantMethod plantMethod = productVo.getPlantMethod();
                //JLC
                String WaterDate = "";
                for(int i = 0; i < waterDate.length; i++){
                    String temp = new SimpleDateFormat("yyyy-MM-dd").format(waterDate[i]);
                    WaterDate = WaterDate + temp + ",";
                }
                WaterDate = WaterDate.substring(0, WaterDate.length()-1);
                plantMethod.setWaterDate(WaterDate);

                int pltmthId = plantMethodService.addPlantMethod(plantMethod);
                producer.setProduceTime(product.getProduceTime());
                int producerId = producerService.addProducer(producer);
                product.setProducerId(producerId);
                product.setPlantMethodId(pltmthId);
                product.setIsProded(1);
                product.setIsDisted(0);
                product.setIsStored(0);
                product.setIsTransed(0);
                String time = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
                String identifier = "";
                DecimalFormat df = new DecimalFormat("0000");
                identifier = df.format(producer.getCorpId()) + time + df.format(x);
                product.setIdentifier(identifier);
                productService.addProduct(product);
            }
        }
        redirectAttributes.addAttribute("all",1);
        return "redirect:/getAllProduct.do";
    }

    @RequestMapping("/delProduct.do")
    public String delProduct(Integer id,RedirectAttributes redirectAttributes){
        productService.delProduct(id);
        redirectAttributes.addAttribute("all", 1);
        return "redirect:/getAllProduct.do";
    }

    @RequestMapping("/delmulproducts.do")
    public String delmulNews(String dellist,Model model,RedirectAttributes redirectAttributes){
        String[] str = dellist.split(",");
        List<Integer> idlist = new ArrayList<Integer>();
        for(int i=0;i<str.length;i++){
            idlist.add(Integer.parseInt(str[i]));
        }
        for (int x:idlist) {
            productService.delProduct(x);
        }
        redirectAttributes.addAttribute("all",1);
        return "redirect:/getAllProduct.do";
    }

    @RequestMapping("/getProductById.do")
    public String getProductById(HttpServletRequest request, HttpServletResponse response,Integer id, Model model){
        Product product = productService.getProductById(id);
        Producer producer = producerService.getProducerById(product.getProducerId());
        PlantMethod plantMethod = plantMethodService.getPlantMethodById(product.getPlantMethodId());
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

        List<Certificate> certificateList = new ArrayList<Certificate>();
        Storage storage = new Storage();
        if(product.getStorageId()!=null){
            storage = storageService.getStorageById(product.getStorageId());
        }
        Transport transport = new Transport();
        if(product.getTransportId()!=null){
            transport = transportService.getTransportById(product.getTransportId());
        }
        Distribution distribution = new Distribution();
        if(product.getDistributionId()!=null){
            distribution = distributionService.getDistributionById(product.getDistributionId());
        }
        CorporationInfo storage_corporationInfo = new CorporationInfo();
        if(storage.getCorpId()!=null){
            storage_corporationInfo = corporationInfoService.getCorporationInfoById(storage.getCorpId());
            certificateList.addAll(certificateService.getCertificatesbyCorpId(storage.getCorpId()));
        }
        CorporationInfo transport_corporationInfo = new CorporationInfo();
        if(transport.getCorpId()!=null){
            transport_corporationInfo = corporationInfoService.getCorporationInfoById(transport.getCorpId());
            certificateList.addAll(certificateService.getCertificatesbyCorpId(transport.getCorpId()));
        }
        CorporationInfo distribution_corporationInfo = new CorporationInfo();
        if(distribution.getCorpId()!=null){
            distribution_corporationInfo = corporationInfoService.getCorporationInfoById(distribution.getCorpId());
            certificateList.addAll(certificateService.getCertificatesbyCorpId(distribution.getCorpId()));
        }
        CorporationInfo producer_corporationInfo = new CorporationInfo();
        if(producer.getCorpId()!=null){
            producer_corporationInfo = corporationInfoService.getCorporationInfoById(producer.getCorpId());
            certificateList.addAll(certificateService.getCertificatesbyCorpId(producer.getCorpId()));
        }
        Fertilizer fertilizer = new Fertilizer();
        if(plantMethod.getFertId()!=null){
            fertilizer = fertilizerService.getFertilizerById(plantMethod.getFertId());
        }
        Pesticide pesticide = new Pesticide();
        if(plantMethod.getPestId()!=null){
            pesticide =  pesticideService.getPesticideById(plantMethod.getPestId());
        }
        if(product.getProducerId()!=null){
            certificateList.addAll(certificateService.getCertificatesbyProducerId(product.getProducerId()));
        }
        model.addAttribute("role", request.getSession().getAttribute("role"));
        model.addAttribute("product", product);
        model.addAttribute("producer", producer);
        model.addAttribute("plantMethod", plantMethod);
        model.addAttribute("waterDate", WD);
        model.addAttribute("storage", storage);
        model.addAttribute("transport", transport);
        model.addAttribute("distribution", distribution);
        model.addAttribute("stor_corInfo", storage_corporationInfo);
        model.addAttribute("trans_corInfo", transport_corporationInfo);
        model.addAttribute("dist_corInfo", distribution_corporationInfo);
        model.addAttribute("prod_corInfo", producer_corporationInfo);
        model.addAttribute("fertilizer", fertilizer);
        model.addAttribute("pesticide", pesticide);
        model.addAttribute("certificateList", certificateList);
        return "product-information";
    }

    @RequestMapping("/toupdateProduct.do")
    public String toupdateProduct(HttpServletRequest request, HttpServletResponse response,Integer id, Integer type, Model model){
        Product product = productService.getProductById(id);
        Producer producer = producerService.getProducerById(product.getProducerId());
        PlantMethod plantMethod = plantMethodService.getPlantMethodById(product.getPlantMethodId());
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

        Storage storage = new Storage();
        if(product.getStorageId()!=null){
            storage = storageService.getStorageById(product.getStorageId());
        }
        Transport transport = new Transport();
        if(product.getTransportId()!=null){
            transport = transportService.getTransportById(product.getTransportId());
        }
        Distribution distribution = new Distribution();
        if(product.getDistributionId()!=null){
            distribution = distributionService.getDistributionById(product.getDistributionId());
        }
        CorporationInfo storage_corporationInfo = new CorporationInfo();
        if(storage.getCorpId()!=null){
            storage_corporationInfo = corporationInfoService.getCorporationInfoById(storage.getCorpId());
        }
        CorporationInfo transport_corporationInfo = new CorporationInfo();
        if(transport.getCorpId()!=null){
            transport_corporationInfo = corporationInfoService.getCorporationInfoById(transport.getCorpId());
        }
        CorporationInfo distribution_corporationInfo = new CorporationInfo();
        if(distribution.getCorpId()!=null){
            distribution_corporationInfo = corporationInfoService.getCorporationInfoById(distribution.getCorpId());
        }
        CorporationInfo producer_corporationInfo = new CorporationInfo();
        if(producer.getCorpId()!=null){
            producer_corporationInfo = corporationInfoService.getCorporationInfoById(producer
                    .getCorpId());
        }
        Fertilizer fertilizer = fertilizerService.getFertilizerById(plantMethod.getFertId());
        Pesticide pesticide = pesticideService.getPesticideById(plantMethod.getPestId());
        List<Pesticide> pesticideList = pesticideService.getALLPesticide();
        List<Fertilizer> fertilizerList = fertilizerService.getALLFertilizer();
        List<CorporationInfo> producer_corporationInfoList = corporationInfoService.getCorporationInfobyrole(1);
        List<CorporationInfo> storage_corporationInfoList = corporationInfoService.getCorporationInfobyrole(2);
        List<CorporationInfo> transport_corporationInfoList = corporationInfoService.getCorporationInfobyrole(3);
        List<CorporationInfo> distribution_corporationInfoList = corporationInfoService.getCorporationInfobyrole(4);

        model.addAttribute("pesticideList",pesticideList);
        model.addAttribute("fertilizerList",fertilizerList);
        model.addAttribute("producer_corporationInfoList",producer_corporationInfoList);
        model.addAttribute("storage_corporationInfoList",storage_corporationInfoList);
        model.addAttribute("transport_corporationInfoList",transport_corporationInfoList);
        model.addAttribute("distribution_corporationInfoList",distribution_corporationInfoList);
        model.addAttribute("type", type);
        model.addAttribute("product", product);
        model.addAttribute("producer", producer);
        model.addAttribute("plantMethod", plantMethod);
        model.addAttribute("waterDate", WD);
        model.addAttribute("storage", storage);
        model.addAttribute("transport", transport);
        model.addAttribute("distribution", distribution);
        model.addAttribute("prod_corInfo", producer_corporationInfo);
        model.addAttribute("stor_corInfo", storage_corporationInfo);
        model.addAttribute("trans_corInfo", transport_corporationInfo);
        model.addAttribute("dist_corInfo", distribution_corporationInfo);
        model.addAttribute("fertilizer", fertilizer);
        model.addAttribute("pesticide", pesticide);
        return "product-update";
    }

    @RequestMapping("/updateProduct_producer.do")
    public String updateProduct_producer(HttpServletRequest request, HttpServletResponse response,
                                         @ModelAttribute ProductVo productVo, @RequestParam("waterDate") java.sql.Date[] waterDate, String selectprocorpName,String selectpestName,String selectfertName,
                                         int selectprocorpId,int selectpestId,int selectfertId, RedirectAttributes redirectAttributes){
        Product product = productVo.getProduct();
        Producer producer = productVo.getProducer();
        PlantMethod plantMethod = productVo.getPlantMethod();
        producer.setProduceTime(product.getProduceTime());
        productService.updateProduct(product);
        producerService.updateProducer(producer);
        //JLC
        String WaterDate = "";
        for(int i = 0; i < waterDate.length; i++){
            String temp = new SimpleDateFormat("yyyy-MM-dd").format(waterDate[i]);
            WaterDate = WaterDate + temp + ",";
        }
        WaterDate = WaterDate.substring(0, WaterDate.length()-1);
        plantMethod.setWaterDate(WaterDate);

        plantMethodService.updatePlantMethod(plantMethod);
        redirectAttributes.addAttribute("id", product.getProductId());
        return "redirect:/getProductById.do";
    }

    @RequestMapping("/searchbyIden.do")
    public String searchbyIden(HttpServletRequest request, HttpServletResponse response, String identifier, Model model){
        List<Product> productList = productService.searchbyIden(identifier);
        model.addAttribute("role", request.getSession().getAttribute("role"));
        model.addAttribute("productList", productList);
        model.addAttribute("identifier", identifier);
        return "product-list";
    }

    @RequestMapping("/search.do")
    public String search(HttpServletRequest request, HttpServletResponse response,String logmin,String logmax, Integer type, Integer corp, Integer batch,Model model){
        java.sql.Date begindate = null;
        java.sql.Date enddate = null;
        if(!logmin.equals("")){
            begindate = java.sql.Date.valueOf(logmin);
        }
        if(!logmax.equals("")){
            enddate = java.sql.Date.valueOf(logmax);
        }
        List<Product> productList = productService.search(type,corp,batch,begindate,enddate);
        model.addAttribute("role", request.getSession().getAttribute("role"));
        model.addAttribute("productList", productList);
        model.addAttribute("logmin", logmin);
        model.addAttribute("logmax", logmax);
        model.addAttribute("type", type);
        model.addAttribute("corp", corp);
        model.addAttribute("batch", batch);
        return "product-list";
    }

    @RequestMapping("/getProductByIden.do")
    public String getProductByIden(String identifier, Model model){
        Product product = productService.getProductByIden(identifier);
        if(product==null){
            model.addAttribute("isExist","isExist");
            return "front/index_front";
        }
        model.addAttribute("Product", product);
        return "front/show";
    }

    @RequestMapping("/getProductInfo.do")
    public String getProductInfo(Integer id, Model model){
        Product product = productService.getProductById(id);
        Producer producer = producerService.getProducerById(product.getProducerId());
        model.addAttribute("Product", product);
        model.addAttribute("Producer", producer);
        return "front/showProPlan";
    }

    @RequestMapping("/getCertificate.do")
    public String getCertificate(HttpServletRequest request, HttpServletResponse response,Integer id, Model model){
        Product product = productService.getProductById(id);
        Producer producer = producerService.getProducerById(product.getProducerId());
        List<Certificate> certificateList = new ArrayList<Certificate>();
        Storage storage = new Storage();
        if(product.getStorageId()!=null){
            storage = storageService.getStorageById(product.getStorageId());
        }
        Transport transport = new Transport();
        if(product.getTransportId()!=null){
            transport = transportService.getTransportById(product.getTransportId());
        }
        Distribution distribution = new Distribution();
        if(product.getDistributionId()!=null){
            distribution = distributionService.getDistributionById(product.getDistributionId());
        }
        if(storage.getCorpId()!=null){
            certificateList.addAll(certificateService.getCertificatesbyCorpId(storage.getCorpId()));
        }
        if(transport.getCorpId()!=null){
            certificateList.addAll(certificateService.getCertificatesbyCorpId(transport.getCorpId()));
        }
        if(distribution.getCorpId()!=null){
            certificateList.addAll(certificateService.getCertificatesbyCorpId(distribution.getCorpId()));
        }
        if(producer.getCorpId()!=null){
            certificateList.addAll(certificateService.getCertificatesbyCorpId(producer.getCorpId()));
        }
        if(product.getProducerId()!=null){
            certificateList.addAll(certificateService.getCertificatesbyProducerId(product.getProducerId()));
        }
        model.addAttribute("certificateList", certificateList);
        return "front/showFiles";
    }
}
