package com.xiaobu.controller.webservice.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.xml.ws.Endpoint;

import org.apache.log4j.Logger;

import com.xiaobu.controller.webservice.impl.IWebServiceImpl;
@WebListener
public class WebServicePublishListener implements ServletContextListener{
	Logger logger=Logger.getLogger(WebServicePublishListener.class);
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		 //WebService的发布地址
        String address = "http://10.0.245.36:8000/WebService";
      //发布WebService，WebServiceImpl类是WebServie接口的具体实现类
        Endpoint.publish(address , new IWebServiceImpl());
        logger.info("WebServicePublishListener启动!");
	}

}
