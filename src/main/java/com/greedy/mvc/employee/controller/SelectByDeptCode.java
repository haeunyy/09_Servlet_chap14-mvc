package com.greedy.mvc.employee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.mvc.employee.model.dto.EmployeeDTO;
import com.greedy.mvc.employee.model.service.EmployeeService;

/**
 * Servlet implementation class SelectByDeptCode
 */
@WebServlet("/employee/selectByDeptCode")
public class SelectByDeptCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		System.out.println(dc);
		EmployeeService es = new EmployeeService();
		EmployeeDTO emp = es.selectByDeptCode(request.getParameter("deptCode")); 
		
		String path = "";
		
		if(emp != null ) {
//			path="/WEB-INF/views/employee/"
		} else {
			
		}
		
		
	}



}
