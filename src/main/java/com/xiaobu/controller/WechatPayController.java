package com.xiaobu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaobu.model.Member;
import com.xiaobu.service.IMemberService;
import com.xiaobu.utils.JsonViewUtils;

import jxl.common.Logger;

@Controller
@RequestMapping("/wechat")
public class WechatPayController {
	private static Logger logger = Logger.getLogger(WechatPayController.class);
	@Autowired
	private IMemberService memberService;
	@RequestMapping("/qrcode")
	public void  wchatQrcode(HttpServletRequest request,HttpServletResponse response){
		logger.info("进入wchatQrcode()微信二维码");
	}
	@RequestMapping("/getMeber")
	public void getMeber(HttpServletRequest request,HttpServletResponse response){
		List<Member> members =memberService.queryData(null);
		JsonViewUtils.render(members, response);
	}
}
