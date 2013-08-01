package kr.co.androider.spring3.hello.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

	@RequestMapping("/hello")
	public ModelAndView helloWorld() {
	    
		System.out.println("log - helloWorld");
		String message = "Hello World, Spring 3.0!";
		System.out.println(message);
		return new ModelAndView("hello", "message", message);
	}
	
	@RequestMapping("/fileUpload")
    public void fileUpload(HttpServletRequest request, HttpServletResponse response,
    		@RequestParam HashMap<Object, Object> param) throws Exception {

		// form token
		System.out.println(param);
		
        /*DiskFileItemFactory factory = new DiskFileItemFactory();
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
            out.println("<script>");
            out.println("alert('Upload has been done successfully!');");
            out.println("location.href='" + request.getContextPath() + "/hello.do" + "';");
            out.println("</script>");
        }*/
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
		MultipartFile mFile = multipartRequest.getFile("attachFile");
		String fileName = mFile.getOriginalFilename();
		String filePath = System.getProperty("java.io.tmpdir") + fileName;
		File file = new File(filePath);
		
		FileCopyUtils.copy(mFile.getInputStream(), new FileOutputStream(file));
		
		response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write("{\"jsonResult\":\"Upload has been done successfully!\", \"fileName\":\"" + fileName + "\"}");
    }
	
	@RequestMapping("/fileDownload")
    public void fileDownload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
    	request.setCharacterEncoding("utf-8");
        String fileName = request.getParameter("fileName");
        response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(fileName, "utf-8").replaceAll("\\+", "%20") + ";");
        
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