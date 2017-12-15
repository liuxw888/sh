package com.sh.user.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sh.user.service.UserService;

@Controller
@RequestMapping("/userController")
public class UserController {
	@Resource
	private UserService userService;
	@RequestMapping("/deleteUser")
	public void deleteUser(Integer id){
		userService.deleteById(id);
	}
}
