package com.greedy.mvc.employee.model.service;

import static com.greedy.mvc.common.mybatis.Template.getSqlSession;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.greedy.mvc.employee.model.dao.EmployeeDAO;
import com.greedy.mvc.employee.model.dto.EmployeeDTO;

public class EmployeeService {

	private final EmployeeDAO empDAO;
	
	public EmployeeService() {
		empDAO = new EmployeeDAO();
	}
	
	public EmployeeDTO selectOneEmpById(String empId) {
		
		/* SqlSession 객체 생성 */
		SqlSession session = getSqlSession();
		System.out.println(session);
		
		/* DAO 로 empId 전달하여 employee 객체 반환 요청 */
		EmployeeDTO selectedEmp = empDAO.selectOneEmpById(session, empId);	
		
		/* sqlSession 객체 닫기 */
		session.close();
		
		/* 조회 결과 반환 */
		return selectedEmp;
	}
	
	public List<EmployeeDTO> selectAllEmp() {
		
		SqlSession session = getSqlSession();
		
		List<EmployeeDTO> empList = empDAO.selectAll(session);
		
		session.close();
		
		return empList;
	}

	public int insertEmp(EmployeeDTO emp) {
		
		SqlSession session = getSqlSession();
		
		int result = empDAO.insertEmp(session, emp);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		
		return result;
	}

	public int updateEmp(EmployeeDTO emp) {
		SqlSession session = getSqlSession();
		
		int result = empDAO.updateEmp(session,emp);
		
		if(result>0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		return result;
	}

	public int deleteEmp(String empId) {
		
		SqlSession session = getSqlSession();
		
		int result = empDAO.deleteEmp(session,empId);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		
		return result;
	}

	public EmployeeDTO selectByDeptCode(String parameter) {
		// TODO Auto-generated method stub
		return null;
	}

}
