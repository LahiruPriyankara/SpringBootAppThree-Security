package com.lhu.springbootSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String homePage() {
		return "index";
	}
	@RequestMapping("/userDetail")
	public String userDetail() {
		return "index";
	}
	@RequestMapping("/login")
	public String loginProcess() {
		return "login";
	}
	@RequestMapping("/logout")
	public String logoutProcess() {
		return "login";
	}

}
