package com.greedy.mvc.employee.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.mvc.employee.model.dto.EmployeeDTO;
import com.greedy.mvc.employee.model.service.EmployeeService;

@WebServlet("/employee/list")
public class SelectAllEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 전체 사원의 정보 조회 결과에 따라 employee/employeeList.jsp or errorPage.jsp로 응답*/
		EmployeeService empService = new EmployeeService();
		List<EmployeeDTO> selectAll = empService.selectAllEmp();
		
		String path = "";
		
		if( selectAll != null ) {
			path = "/WEB-INF/views/employee/employeeList.jsp";
			request.setAttribute("selectAll", selectAll);
		} else {
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "조회가 안됐습니다~~~");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
	}

}
