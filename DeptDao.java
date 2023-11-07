package com.momo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.momo.common.DBConnection;
import com.momo.dto.DeptDto;
import com.momo.dto.Job;

public class DeptDao extends DBConnection{
	
	public DeptDao(ServletContext application) {
		super(application);
	}
	
	/*
	 * job 테이블의 내용을 조회 후 리스트에 담아서 반환
	 * @return
	 */
	public List<DeptDto> getList(){
		List<DeptDto> list = new ArrayList<>();
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from department d, location l where d.location_id = l.local_code");
			while(rs.next()) {
				DeptDto deptDto = new DeptDto();
				deptDto.setDept_id(rs.getString(1));
				deptDto.setDept_title(rs.getString(2));
				deptDto.setLocation_id(rs.getString(3));
				deptDto.setLocal_code(rs.getString(4));
				deptDto.setNational_code(rs.getString(5));
				deptDto.setLocal_name(rs.getString(6));

				list.add(deptDto);
			}
			
		} catch (SQLException e) {
			System.out.println("DeptDao 에러발생!!!!!!!!!!!!!!!");
			e.printStackTrace();
		}
		
		return list;
	}
}
