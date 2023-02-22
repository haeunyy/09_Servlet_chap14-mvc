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
 * Servlet implementation class deleteEmpServlet
 */
@WebServlet("/employee/delete")
public class deleteEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		EmployeeDTO emp = new EmployeeDTO();
//		EmployeeService empService = new EmployeeService();
		
		String empId = request.getParameter("empId");
		
		int result = new EmployeeService().deleteEmp(empId);
		
		String path = "";
		
		if( result > 0 ) {
			path = "/WEB-INF/views/common/successPage.jsp";
			request.setAttribute("successCode", "deleteEmp");
		} else {
			path="/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "직원 정보 삭제에 실패하였습니다. ");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
		
		
	}

}
