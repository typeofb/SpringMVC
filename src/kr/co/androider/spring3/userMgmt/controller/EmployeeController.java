package kr.co.androider.spring3.userMgmt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.androider.spring3.common.controller.UserController;
import kr.co.androider.spring3.userMgmt.vo.EmployeeVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springmodules.validation.commons.DefaultBeanValidator;

@Controller
public class EmployeeController extends UserController {
	
//	@Autowired
	@Resource(name = "beanValidator")
	private DefaultBeanValidator beanValidator;
	
	@RequestMapping("/employee")
	public ModelAndView employee() {
		return new ModelAndView("userMgmt/employee", "employeeCommand", new EmployeeVo());
	}
	
	@RequestMapping("/saveEmployee")
	public void saveEmployee(HttpServletRequest request, HttpServletResponse response,
			@RequestParam HashMap<Object, Object> param,
			@ModelAttribute("employee") EmployeeVo employee,
			BindingResult bindingResult, Model model) throws IOException {

		System.out.println("log - employee");
		System.out.println(param);
		
		beanValidator.validate(employee, bindingResult); // validation 수행
		if (bindingResult.hasErrors()) { // 만일 validation 에러(전화번호가 String 일 경우)가 있으면...
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('Validation Error');");
			out.println("window.history.back();");
			out.println("</script>");
			out.flush();
			return;
		}
//		employeeManageService.updateEmployee(employee);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('Validation Success');");
		out.println("window.history.back();");
		out.println("</script>");
		out.flush();
	}
}
