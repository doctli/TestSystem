<%--
  Created by IntelliJ IDEA.
  User: doctli
  Date: 2015/12/22
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="teststart" class="cn.DB"></jsp:useBean>
<%
    String Pno=request.getParameter("hidden");
    String sql="select * from testsystem.testpa";
%>
<%=request.getParameter("hidden")%>

</body>
</html>
