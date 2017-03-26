package com.xiaobu.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/index")
public class IndexController {
	Logger log=Logger.getLogger(IndexController.class);
	@RequestMapping("/login")
	public String redirectIndex(){
		log.info("index-------------");
		return "index.jsp";
	}
	@RequestMapping("/welcom")
	public String redirectWelcom(Model model){
		log.info("welcom-------------");
		model.addAttribute("welcom", "test velocity");
		return "welcom.vm";
	}
}
