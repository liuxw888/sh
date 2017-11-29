package com.sh.user.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sh.entity.User;
import com.sh.user.service.UserService;

@Controller
@RequestMapping("/registuser")
public class RegistUserController {
	@Resource
	private UserService userService;
	@RequestMapping("/regist")
	public String regist(User u,@RequestParam("agpassword") String agpassword){
		if(u.getPassword().equals(agpassword)){
			userService.addUser(u);
			return "main";
		}else{
			return "error";
		}
	}
	@RequestMapping("/checkEmail")
	public void checkEmail(HttpServletRequest request, HttpServletResponse response){
		String regix = "[a-zA-Z_0-9]+@[a-zA-Z_0-9]{2,6}(\\.[a-zA-Z_0-9]{2,3})+";
		String email = request.getParameter("email");
		List<User> list = userService.listAllUser();
		boolean flag=false;
		for(User u1:list){
			if(u1.getEmail().equals(email)) {  
		        flag=true; 
		        break;
		    }
		}
		if(flag==true){
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
