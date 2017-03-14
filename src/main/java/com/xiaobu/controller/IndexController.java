package com.xiaobu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	@RequestMapping("/login")
	public String redirectIndex(){
		System.out.println("index-------------");
		return "index";
	}
}
