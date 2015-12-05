<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分数查询</title>
</head>
<body>
<%%>
<form action="goalserach.jsp">
<%--科目<select name="course">--%>
    <%--<option value=null>请选择科目</option>--%>
    <%--<option value="Chinese">语文</option>--%>
    <%--<option value="mathematics">数学</option>--%>
    <%--<option value="English">英语</option>--%>
    <%--<option value="huaxue">化学</option>--%>
    <%--<option value="wuli">物理</option>--%>
<%--</select>--%>
学年<select name="year" >
    <option value=null>请选择科目</option>
    <option value="2013-2014">2013-2014</option>
    <option value="2014-2015">2014-2015</option>
    <option value="2015-2016">2015-2016</option>
</select>
学期<select name="term" >
    <option value=null>请选择科目</option>
    <option value="first">上</option>
    <option value="last">下</option>
</select><br/>
<input type="submit" value="查询"><input type="button" name="返回" value="返回">
</form>
<%=request.getParameter("year")%>
<%=request.getParameter("term")%>

</body>
</html>