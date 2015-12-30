<%@ page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考试模块</title>
</head>
<body>
<jsp:useBean id="test" class="cn.DB"></jsp:useBean>
<%
    ResultSet rs2=null;
    String sno=(String)request.getSession().getAttribute("userno");
    String sql="select * from testsystem.testpaperinfo where class=(select class from testsystem.studentinfo where Sno='"+sno+"') AND subject not in  (SELECT subject from testsystem.courseschedule where Sno='"+sno+"');";
    try {rs2=test.search(sql);}catch (Exception e){}
    %>
考试科目:
<br/>
<table>
    <thead>
            <tr>
                <th>科目</th>
                <th>教师</th>
                <th>操作</th>
            </tr>
    </thead>
    <tbody>
        <%while (rs2.next()){%>
                <tr>
                    <td><%=rs2.getString("subject")%></td>
                    <td><%=rs2.getString("Wno")%></td>
                    <td><form action="/teststart.jsp" method="post"><input type="hidden" name="hidden" value=<%=rs2.getString("Pno")%>><input type="submit" value="考试" ></form></td>
                </tr>
            <%}%>
    </tbody>
</table>
<br>
<a href="student.jsp"><input type="button" value="返回"></a>
</body>
</html>