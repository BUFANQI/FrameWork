package com.xiaobu.controller.webservice.impl;

import javax.jws.WebService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.xiaobu.controller.webservice.IWebService;
import com.xiaobu.controller.webservice.util.SpringBeanFactoryUtils;
import com.xiaobu.model.Member;
import com.xiaobu.service.IMemberService;

import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

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
