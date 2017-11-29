package com.sh.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sh.entity.User;
import com.sh.user.service.UserService;

@Controller
@RequestMapping("/loginuser")
public class LoginUserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(@RequestParam("email") String email,
			@RequestParam("password") String password,
			Model model, HttpSession session){
		User u = userService.listByEmail(email);
		if(u!=null&&u.getPassword().equals(password)){
			session.setAttribute("u", u);
			return "success";
		}else{
			model.addAttribute("errorinfo", "您的账号密码不正确！");
			return "login";
		}
	}

}
