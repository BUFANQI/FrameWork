package com.xiaobu.controller.webservice.impl;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.apache.log4j.Logger;

import com.xiaobu.controller.webservice.IWebService;
import com.xiaobu.model.Member;
import com.xiaobu.service.IMemberService;
import com.xiaobu.utils.SpringBeanFactoryUtils;

@WebService
@SOAPBinding(style = Style.RPC)
public class IWebServiceImpl implements IWebService{
	Logger logger=Logger.getLogger(IWebServiceImpl.class);	
	@Override
	public String sayhello(String name) {
		return "sayheolle"+name;
	}

	@Override
	public String save(String name, String pwd) {
		return "save "+name+":"+pwd;
	}

	@Override
	public Member findMemberByPhone(String phoneNumber) {
		IMemberService memberService=(IMemberService) SpringBeanFactoryUtils.getBean("memberServiceImpl");
		Member member =memberService.findMemberByPhone(phoneNumber);
		return member;
	}
	
}
