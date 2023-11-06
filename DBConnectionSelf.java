package com.momo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.momo.dto.Job;

public class DBConnectionSelf {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id  = "test";
		String pw  = "1234";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<Job> list = new ArrayList<>();
		/*
		 * 1. 드라이버로딩
		 * 		DB에 접근하기 위해 필요한 라이브러리가 있는지 확인
		 * 
		 * 2. 커넥션 객체를 생성
		 * 
		 */
		try {
			// 1. 라이브러리 확인
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. Connection 객체 생성
			con = DriverManager.getConnection(url, id, pw);
					
			// 3. 쿼리 문장 준비
			String sql = "select * from job";
			
			// 4. 쿼리 문장 실행
			stmt = con.createStatement();
			
			// stmt.executeQuery(sql)
			// 		select 문장을 실행 할 경우 ResultSet을 반환 합니다.
			// stmt.executeUpdate(sql)
			// 		update, insert, delete 의 경우 int 타입을 반환 합니다.
			// 		-> 실행 결과 몇 건이 처리되었는지
			rs = stmt.executeQuery(sql);
			
			// 숫자를 입력시 1부터
			// 숫자 또는 결과 집합의 컬럼명
			while (rs.next()) {
				Job job = new Job();
				job.setJob_Code(rs.getString(1));
				job.setJob_Name(rs.getString(2));
				System.out.print(rs.getString(1));
				System.out.print(rs.getString(2));
				System.out.println();
				
				list.add(job);
			}		
			System.out.println("========================");
			System.out.println(list);
						
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Connection 객체 생성 실패");
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();				
			} catch (Exception e){
				System.out.println("자원 해제중 예외사항이 발생 하였습니다.");
				e.printStackTrace();
			}
		}
		
	}

}
