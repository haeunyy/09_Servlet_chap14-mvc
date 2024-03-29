package com.greedy.mvc.common.controller;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.greedy.mvc.common.config.ConfigLocation;

// loadOnStartup 서버가 돌 때 호출되라는 의미
@WebServlet(urlPatterns = {}, loadOnStartup = 1)
public class InitialLoadingServlet extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) {
		
		ConfigLocation.mybatisConfigLocation = config.getServletContext().getInitParameter("mybatis-config-location");
		
		System.out.println(ConfigLocation.mybatisConfigLocation);
	}
}
