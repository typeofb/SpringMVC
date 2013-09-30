package kr.co.androider.spring3.userMgmt.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SmsSendController {
	
	@RequestMapping("/smsSend")
	public void smsSend(@RequestParam HashMap<Object, Object> param,
						@RequestParam(value="USR_ID_RCV", required=true) String[] usrIdRcv) {

		System.out.println("log - smsSend");
		System.out.println(param);
		System.out.println(usrIdRcv);
		for (int i = 0; i < usrIdRcv.length; i++) {
			System.out.println(usrIdRcv[i]);
		}
	}
}
