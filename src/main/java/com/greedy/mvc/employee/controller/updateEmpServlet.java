package com.greedy.mvc.employee.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.mvc.employee.model.dto.EmployeeDTO;
import com.greedy.mvc.employee.model.service.EmployeeService;

/**
 * Servlet implementation class updateEmpServlet
 */
@WebServlet("/employee/update")
public class updateEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String empId = request.getParameter("empId");
		Date entDate = Date.valueOf(request.getParameter("entDate"));
		
		EmployeeDTO emp = new EmployeeDTO();
		emp.setEmpId(empId);
		emp.setEntDate(entDate);
		
		EmployeeService empService = new EmployeeService();
		int result = empService.updateEmp(emp);
		
		String path = "";
		
		if(result > 0) {
			request.setAttribute("successCode", "updateEmp");
			path = "/WEB-INF/views/common/successPage.jsp";
		} else {
			request.setAttribute("message", "직원 정보 수정에 실패하였습니다.");
			path = "/WEB-INF/views/common/errorPage.jsp";
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

		
	}


