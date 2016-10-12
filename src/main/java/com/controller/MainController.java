package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/")
	public String getMain(){
		return "index";
	}
	
	@RequestMapping("/users")
	public void users(){
	}
	
	@RequestMapping("/admin")
	public void admin(){
	}
	
	@RequestMapping("/login")
	public void login(){}
	
	
	@RequestMapping("/posts/@Id")
	public ModelAndView getPosts(){
		return null;
	}
}
