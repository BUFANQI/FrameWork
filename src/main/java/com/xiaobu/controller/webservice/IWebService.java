package com.xiaobu.controller.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.xiaobu.model.Member;

@WebService
@SOAPBinding(style = Style.RPC)
public interface IWebService {
	@WebMethod
	String sayhello(String name);
	@WebMethod
	String save(String name ,String pwd);
	@WebMethod
    Member findMemberByPhone(String phoneNumber);
	//C:\Users\FANQIBU>  wsimport -d E:\\workspace\\Demo\\src -keep  -verbose http://192.168.1.105:8000/WebService?wsdl
}
