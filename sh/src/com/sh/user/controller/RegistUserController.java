package com.sh.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sh.entity.User;
import com.sh.user.service.MySendMailThread;
import com.sh.user.service.UserService;

@Controller
@RequestMapping("/registuser")
public class RegistUserController {
	@Resource
	private UserService userService;
	@RequestMapping("/regist")
	public String regist(User u,@RequestParam("agpassword") String agpassword,HttpServletRequest request){
		if(u.getPassword().equals(agpassword)&&u.getEmail()!=null){
			String code=UUID.randomUUID().toString().replace("-","");
			u.setAcode(code);
			u.setActive(1);
			String regix = "[a-zA-Z_0-9]+@[a-zA-Z_0-9]{2,6}(\\.[a-zA-Z_0-9]{2,3})+";
			//u.setAcode("qarguugnombhihci");
			if(null==userService.listByEmail(u.getEmail())&&u.getEmail().matches(regix)){
				userService.addUser(u);
				MySendMailThread send = new MySendMailThread(u);
				send.run();
				HttpSession session = request.getSession();
				session.setAttribute("rg",new Integer(2));
				return "/registResult";
			}else{
				HttpSession session = request.getSession();
				session.setAttribute("rg",new Integer(1));
				return "/registResult";
			}
		}else{
			HttpSession session = request.getSession();
			session.setAttribute("rg",new Integer(3));
			return "/registResult";
		}
	}
	@RequestMapping("/toActive")
	public void toActive(HttpServletRequest request,HttpServletResponse response){
		
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		User u = userService.listByEmail(email);
		if(u.getActive()==1){
			try {
				session.setAttribute("count", new Integer(2));
				request.getRequestDispatcher("/result.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}else{
			session.setAttribute("count", new Integer(1));
			try {
				request.getRequestDispatcher("/result.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@RequestMapping("/checkEmail")
	public void checkEmail(HttpServletRequest request, HttpServletResponse response){
		String regix = "[a-zA-Z_0-9]+@[a-zA-Z_0-9]{2,6}(\\.[a-zA-Z_0-9]{2,3})+";
		String email = request.getParameter("email");
		User u1 = userService.listByEmail(email);
		boolean flag=false;
		if(null!=u1){
	        flag=true;
	        try {
				response.getWriter().print(true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			if(!email.matches(regix)){
				try {
					response.getWriter().print(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				try {
					response.getWriter().print(false);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
