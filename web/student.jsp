<%--
  Created by IntelliJ IDEA.
  User: doctli
  Date: 2015/11/25
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>学生界面</title>
</head>
<body>
<div align="center">
欢迎你   <%=request.getSession().getAttribute("username")%>

<br>
<a href="goalsearch.jsp"> <input type="button" name="serach" value="查询分数" class="btn btn-info"></a>
<a href="test.jsp"> <input type="button" name="test" value="进入考试"></a>
    <form action="/loginoutServlet" method="post"><input type="submit" value="注销"></form>
</div>
</body>
</html>
