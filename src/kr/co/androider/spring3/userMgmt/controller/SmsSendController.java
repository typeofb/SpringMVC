package kr.co.androider.spring3.userMgmt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import kr.co.androider.spring3.userMgmt.dao.SmsSendDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SmsSendController {
	
	@Autowired
	private SmsSendDaoImpl dao;
	
	@RequestMapping("/smsSend")
	public void smsSend(HttpServletResponse response,
			@RequestParam HashMap<Object, Object> param,
			@RequestParam(value="USR_ID_RCV", required=true) String[] usrIdRcv) throws IOException {

		System.out.println("log - smsSend");
		
		// kepcoDB
		List<HashMap<String, Object>> list = dao.selectUser();
		System.out.println(list);
		
		System.out.println(param);
		System.out.println(usrIdRcv);
		for (int i = 0; i < usrIdRcv.length; i++) {
			System.out.println(usrIdRcv[i]);
		}
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("정상적으로 발송되었습니다");
		out.flush();
	}
}
