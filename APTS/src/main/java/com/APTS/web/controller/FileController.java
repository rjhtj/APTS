package com.APTS.web.controller;

import com.APTS.web.entity.Certificate;
import com.APTS.web.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.security.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RuanJH on 2015/12/2.
 */
@Controller
public class FileController {

    @Autowired
    private CertificateService certificateService;

/*    @RequestMapping("/getfilelist.do")
         public String getformlist(String folder,Model model){
        String path = "E:\\Workspaces\\IdeaProjects\\wusonghaishiju\\wusong\\web\\resources\\"+folder+"\\";
        List<String> list = getlist(path);
        model.addAttribute("folder",folder);
        model.addAttribute("list",list);
        return "file-list";
    }*/

    @RequestMapping("/delfile.do")
    public String delfile(int id, int corpId, RedirectAttributes redirectAttributes){
        Certificate certificate = certificateService.getCertificateById(id);
        String file = certificate.getName();
        String path = certificate.getPath()+file;
        File thefile = new File(path);
        if(thefile.isFile() &&thefile.exists()){
            thefile.delete();
        }
        certificateService.delCertificate(id);
        redirectAttributes.addAttribute("corpId",corpId);
        return "redirect:/getFilesbyCorpId.do";
    }

    @RequestMapping("/upload.do")
    public String upload(HttpServletRequest request, HttpServletResponse response,@RequestParam("filename") String filename,@RequestParam("uploadfile") MultipartFile uploadfile,String name, int corpId, int detectorId, Date detectDate, RedirectAttributes redirectAttributes){
        // 获得项目的路径
        ServletContext sc = request.getSession().getServletContext();
        // 上传位置
        String dir = sc.getRealPath("/files")+ "\\";
        File f = new File(dir);
        if (!f.exists())
            f.mkdirs();
        String path = dir + filename;
        if (!uploadfile.isEmpty()) {
            try {
                byte[] bytes = uploadfile.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(path)));
                stream.write(bytes);
                stream.close();
            } catch (Exception e) {
            }
        }
        Certificate certificate = new Certificate();
        certificate.setCorpId(corpId);
        certificate.setDetectorId(detectorId);
        certificate.setDetectDate(detectDate);
        certificate.setName(name);
        certificate.setPath(path);
        certificateService.addCertificate(certificate);
        redirectAttributes.addAttribute("corpId",corpId);
        return "redirect:/getFilesbyCorpId.do";
    }
    private List<String> getlist(String path){
        File file = new File(path);
        String[] fileName = file.list();
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < fileName.length; i++){
            list.add(fileName[i]);
        }
        return list;
    }


    @RequestMapping("/tofileshow.do")
    public String tofileshow(String path, Model model){
        String s[] = path.split("\\\\");
        String filename = s[s.length-1];
        model.addAttribute("filename", filename);
        return "file-show";
    }

    @RequestMapping("downloadFiles.do")
    public void downLoad(int id, HttpServletRequest request, HttpServletResponse response) throws IOException {
            Certificate certificate = certificateService.getCertificateById(id);
            String s[] = certificate.getPath().split("\\.");
            String suf = '.'+ s[s.length-1];
            File file = new File(certificate.getPath());
            if (file.exists()) {
                InputStream inputStream = null;
                OutputStream outputStream = null;
                // 以流的形式下载文件
                try {
                    inputStream = new BufferedInputStream( new FileInputStream(file));
                    outputStream = new BufferedOutputStream(response.getOutputStream());
                    byte[] buffer = new byte[inputStream.available()];
                    inputStream.read(buffer);
                    inputStream.close();
                    // 清空response
                    response.reset();
                    // 设置response的Header
                    response.addHeader("Content-Disposition","attachment;filename=" + certificate.getName()+suf);
                    response.addHeader("Content-Length", "" + file.length());
                    response.setContentType("application/octet-stream");
                    outputStream.write(buffer);
                    outputStream.flush();
                } catch (Exception e) {
                    // TODO: handle exception
                }finally{
                    inputStream.close();
                    outputStream.close();
                }
                System.out.println("------------->文件下载成功！！！");
            } else {
                System.out.println("------------->该文件不存在！！！");
            }
        }
}
