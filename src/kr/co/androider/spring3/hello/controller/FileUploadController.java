package kr.co.androider.spring3.hello.controller;

import java.util.List;
import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.FileItem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileUploadController {

    @RequestMapping("/fileUpload")
    public void onSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("utf-8");
        List<FileItem> items = upload.parseRequest(request);
        for (FileItem item : items) {
            String fileName = new File(item.getName()).getName();
            String filePath = System.getProperty("java.io.tmpdir") + fileName;
            File file = new File(filePath);

            item.write(file);
            
            response.setContentType("text/html; charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write("{\"jsonResult\":\"Upload has been done successfully!\", \"fileName\":\"" + fileName + "\"}");
            /*out.println("<script>");
            out.println("alert('Upload has been done successfully!');");
            out.println("location.href='" + request.getContextPath() + "/hello.do" + "';");
            out.println("</script>");*/
        }
    }
}