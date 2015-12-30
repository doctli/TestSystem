<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: doctli
  Date: 2015/12/22
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>考试页面</title>

</head>
<body>
<jsp:useBean id="teststart" class="cn.DB"></jsp:useBean>
<%
    response.setContentType("text/html;charset=UTF-8");
    String Pno=request.getParameter("hidden");
    String sql="SELECT * FROM testsystem.testpaper where Pno='"+Pno+"' order by Qno;";
    ResultSet rs=teststart.search(sql);

%>
<form action="/testsubmitServlet" method="post">
    <input type="hidden" value=<%=Pno%> name="Pno">
    <input type="hidden" value="<%=request.getSession().getAttribute("userno")%>"  name="Sno">
    <table>
        <thead>
        <tr>
            <th>题号</th>
            <th>题目</th>
            <th>类型</th>
            <th>作答</th>
        </tr>
        </thead>
        <tbody>
        <%while(rs.next()){%>
        <tr>
            <td><%=rs.getString("Qno")%></td>
            <td><%=rs.getString("question")%></td>
            <td><%=rs.getString("type")%></td>
            <td><input type="text" name="<%=rs.getString("Qno")%>" ></td>
        </tr>
        <%}%>
        </tbody>
    </table>
    <input type="submit" value="提交试卷">
</form>
<%=request.getParameter("hidden")%>
<%=request.getSession().getAttribute("username")%>

</body>
</html>
