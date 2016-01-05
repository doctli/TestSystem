<%@ page import="java.sql.ResultSet" %>
<%@ page import="cn.DB" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师</title>
</head>
<body>
<%%>
工号：<%=request.getSession().getAttribute("userno")%><br>
教师：<%=request.getSession().getAttribute("username")%><br>
科目：<%=request.getSession().getAttribute("subject")%><br>
<form action="/loginoutServlet" method="post"><input type="submit" value="注销"></form>
<br>
我的试卷:
<%String Pnojudege=(String)request.getSession().getAttribute("Pnojudege");


    if(Pnojudege.equals(null)){
        Pnojudege =request.getParameter("Pnojudege");
        request.getSession().setAttribute("Pnojudege",Pnojudege);
        System.out.println(request.getParameter("Pnojudege"));
    }
    else {
        response.sendRedirect("answerjudege.jsp");
    }
%>
<form action="teacher.jsp">
    <table>
        <thead>
        <tr>
            <td>试卷号</td>
            <td>班级</td>
            <td>科目</td>
            <td>操作</td>
        </tr>
        </thead>
        <%String sql="select * from testsystem.testpaperinfo where Wno='"+request.getSession().getAttribute("userno")+"';";
            try {
                ResultSet rs = (new DB().search(sql));
                while (rs.next()) {%>
                    <tr>
                        <td><%=rs.getString("Pno")%></td>
                        <td><%=rs.getString("class")%></td>
                        <td><%=rs.getString("subject")%></td>
                        <td><input type="radio" name="Pnojudege" value=<%=rs.getString("Pno")%> ></td>
                    </tr>
                <%}
            } catch (Exception e) {
            }%>
    </table>
    <input type="submit" value="批改">
</form>
<%call%>

<%--<a href="answerjudege.jsp"> <input type="button" name="pigai" value="批改试卷"></a>--%>
<br/>
<input type="button" name="tongji" value="统计成绩">
</body>
</html>