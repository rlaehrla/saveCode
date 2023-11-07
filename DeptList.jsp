<%@page import="com.momo.dto.DeptDto"%>
<%@page import="com.momo.dao.DeptDao"%>
<%@page import="com.momo.dto.Job"%>
<%@page import="java.util.List"%>
<%@page import="com.momo.dao.JobDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>데이터베이스 출력</h1>

<%
	DeptDao deptDao = new DeptDao(application);
	List<DeptDto> list = deptDao.getList();
	
	deptDao.close();
	
	
	for(DeptDto ddto : list){
		out.print("<br>");
		out.print(ddto.getDept_id());
		out.print(ddto.getDept_title());
		out.print(ddto.getLocal_code());
		out.print(ddto.getLocal_name());
		out.print(ddto.getLocation_code());
		out.print(ddto.getLocation_id());
		}
%>

</body>
</html>