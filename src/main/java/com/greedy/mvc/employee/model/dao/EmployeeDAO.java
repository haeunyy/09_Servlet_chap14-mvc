package com.greedy.mvc.employee.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.greedy.mvc.employee.model.dto.EmployeeDTO;

public class EmployeeDAO {

	public EmployeeDTO selectOneEmpById(SqlSession session, String empId) {
		
		/* xml 설정 버전으로 구현중인 상태 / 호출 */
		
		return session.selectOne("EmployeeDAO.selectOneEmpById",empId);
		
	}

	public List<EmployeeDTO> selectAll(SqlSession session) {
		
		return session.selectList("EmployeeDAO.selectAll");
	}

	public int insertEmp(SqlSession session, EmployeeDTO emp) { 
	
		return session.insert("EmployeeDAO.insertEmp", emp);
	}

	public int updateEmp(SqlSession session, EmployeeDTO emp) {
		
		return session.update("EmployeeDAO.updateEmp", emp);
	}

	public int deleteEmp(SqlSession session, String empId) {
		
		return session.delete("EmployeeDAO.deleteEmp",empId);
	}

}
