<%@ page import="java.sql.ResultSet" %>
<%@ page import="cn.DB" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分数查询</title>
</head>
<body>
<form action="/SearchServlet?tag=all" method="post"><input type="submit" value="所有成绩"></form>
<form action="/SearchServlet?tag=pass" method="post"><input type="submit" value="及格课程"></form>
<form action="/SearchServlet?tag=notpass" method="post"><input type="submit" value="不及格课程"></form>
<a href="student.jsp"><input type="button" value="返回"></a>
<%
    ResultSet rs1=(ResultSet)request.getSession().getAttribute("sresultset");
    try {
    if(!rs1.equals(null)){%>
        <table>
            <thead>
                    <tr>
                        <th>课程</th>
                        <th>成绩</th>
                    </tr>
            </thead>
            <tbody>
            <%while(rs1.next()){%>
                    <tr>
                        <td><%=rs1.getString("subject")%></td>
                        <td><%=rs1.getString("score")%></td>
                    </tr>
            <%}%>
            </tbody>
        </table>
<%}
}catch(Exception e){
}
%>
</body>
</html>