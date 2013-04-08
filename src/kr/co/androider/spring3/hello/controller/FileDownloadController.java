package kr.co.androider.spring3.hello.controller;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileDownloadController {

    @RequestMapping("/fileDownload")
    public void onSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        String fileName = new String(request.getParameter("fileName").getBytes("8859_1"), "utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ";");
        
        InputStream is = new FileInputStream(System.getProperty("java.io.tmpdir") + fileName);
        BufferedInputStream bis = new BufferedInputStream(is);
        
        BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
        
        int byteRead = 0;
        byte[] buffer = new byte[4096];
        while ((byteRead = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, byteRead);
        }
        
        bos.close();
        bis.close();
        is.close();
    }
}